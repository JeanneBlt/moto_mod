package com.pyloufass.motomod.entity.custom;

import com.google.common.collect.Lists;
import com.pyloufass.motomod.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreakingEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractBoatEntity;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.c2s.play.BoatPaddleStateC2SPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public abstract class AbstractMotoEntity extends AnimalEntity implements RideableInventory, Tameable, JumpingMount {
    public static final int field_30414 = 499;
    public static final int field_30415 = 500;
    public static final double field_42647 = 0.15;
    private static final float MIN_MOVEMENT_SPEED_BONUS = (float)getChildMovementSpeedBonus(() -> 0.0);
    private static final float MAX_MOVEMENT_SPEED_BONUS = (float)getChildMovementSpeedBonus(() -> 1.0);
    private static final float MIN_JUMP_STRENGTH_BONUS = (float)getChildJumpStrengthBonus(() -> 0.0);
    private static final float MAX_JUMP_STRENGTH_BONUS = (float)getChildJumpStrengthBonus(() -> 1.0);
    private static final float MIN_HEALTH_BONUS = getChildHealthBonus(max -> 0);
    private static final float MAX_HEALTH_BONUS = getChildHealthBonus(max -> max - 1);
    private static final float field_42979 = 0.25F;
    private static final float field_42980 = 0.5F;
    private static final TargetPredicate.EntityPredicate IS_BRED_HORSE = (entity, world) -> entity instanceof AbstractMotoEntity abstractMotoEntity
            && abstractMotoEntity.isBred();
    private static final TargetPredicate PARENT_HORSE_PREDICATE = TargetPredicate.createNonAttackable()
            .setBaseMaxDistance(16.0)
            .ignoreVisibility()
            .setPredicate(IS_BRED_HORSE);
    private static final TrackedData<Byte> MOTO_FLAGS = DataTracker.registerData(AbstractMotoEntity.class, TrackedDataHandlerRegistry.BYTE);
    private static final int TAMED_FLAG = 2;
    private static final int BRED_FLAG = 8;
    private static final int EATING_GRASS_FLAG = 16;
    private static final int ANGRY_FLAG = 32;
    private static final int EATING_FLAG = 64;
    public static final int field_52488 = 3;
    private static final int DEFAULT_TEMPER = 0;
    private static final boolean DEFAULT_EATING_GRASS = false;
    private static final boolean DEFAULT_BRED = false;
    private static final boolean DEFAULT_TAME = false;
    private int eatingGrassTicks;
    private int eatingTicks;
    private int angryTicks;
    public int tailWagTicks;
    public int field_6958;
    protected boolean inAir;
    protected SimpleInventory items;
    protected int temper = 0;
    protected float jumpStrength;
    protected boolean jumping;
    private float eatingGrassAnimationProgress;
    private float lastEatingGrassAnimationProgress;
    private float angryAnimationProgress;
    private float lastAngryAnimationProgress;
    private float eatingAnimationProgress;
    private float lastEatingAnimationProgress;
    protected boolean playExtraHorseSounds = true;
    protected int soundTicks;
    @Nullable
    private LazyEntityReference<LivingEntity> ownerReference;

    protected AbstractMotoEntity(EntityType<? extends AbstractMotoEntity> entityType, World world) {
        super(entityType, world);
        this.onChestedStatusChanged();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.2));
        this.goalSelector.add(1, new MotoBondWithPlayerGoal(this, 1.2));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0, AbstractMotoEntity.class));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.0));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.7));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        if (this.shouldAmbientStand()) {
            this.goalSelector.add(9, new ModAmbiantStandGoal(this));
        }

        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(3, new TemptGoal(this, 1.25, stack -> stack.isIn(ItemTags.HORSE_TEMPT_ITEMS), false));
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(MOTO_FLAGS, (byte)0);
    }

    protected boolean getHorseFlag(int bitmask) {
        return (this.dataTracker.get(MOTO_FLAGS) & bitmask) != 0;
    }

    protected void setHorseFlag(int bitmask, boolean flag) {
        byte b = this.dataTracker.get(MOTO_FLAGS);
        if (flag) {
            this.dataTracker.set(MOTO_FLAGS, (byte)(b | bitmask));
        } else {
            this.dataTracker.set(MOTO_FLAGS, (byte)(b & ~bitmask));
        }
    }

    public boolean isTame() {
        return this.getHorseFlag(TAMED_FLAG);
    }

    @Nullable
    @Override
    public LazyEntityReference<LivingEntity> getOwnerReference() {
        return this.ownerReference;
    }

    public void setOwner(@Nullable LivingEntity entity) {
        this.ownerReference = entity != null ? new LazyEntityReference<>(entity) : null;
    }

    public boolean isInAir() {
        return this.inAir;
    }

    public void setTame(boolean tame) {
        this.setHorseFlag(TAMED_FLAG, tame);
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }

    @Override
    public boolean beforeLeashTick(Entity leashHolder, float distance) {
        if (distance > 6.0F && this.isEatingGrass()) {
            this.setEatingGrass(false);
        }

        return true;
    }

    public boolean isEatingGrass() {
        return this.getHorseFlag(EATING_GRASS_FLAG);
    }

    public boolean isAngry() {
        return this.getHorseFlag(ANGRY_FLAG);
    }

    public boolean isBred() {
        return this.getHorseFlag(BRED_FLAG);
    }

    public void setBred(boolean bred) {
        this.setHorseFlag(BRED_FLAG, bred);
    }

    @Override
    public boolean canUseSlot(EquipmentSlot slot) {
        return slot != EquipmentSlot.SADDLE ? super.canUseSlot(slot) : this.isAlive() && !this.isBaby() && this.isTame();
    }

    public void equipHorseArmor(PlayerEntity player, ItemStack stack) {
        if (this.canEquip(stack, EquipmentSlot.BODY)) {
            this.equipBodyArmor(stack.splitUnlessCreative(1, player));
        }
    }

    @Override
    protected boolean canDispenserEquipSlot(EquipmentSlot slot) {
        return (slot == EquipmentSlot.BODY || slot == EquipmentSlot.SADDLE) && this.isTame() || super.canDispenserEquipSlot(slot);
    }

    public int getTemper() {
        return this.temper;
    }

    public void setTemper(int temper) {
        this.temper = temper;
    }

    public int addTemper(int difference) {
        int i = MathHelper.clamp(this.getTemper() + difference, 0, this.getMaxTemper());
        this.setTemper(i);
        return i;
    }

    @Override
    public boolean isPushable() {
        return !this.hasPassengers();
    }

    private void playEatingAnimation() {
        this.setEating();
        if (!this.isSilent()) {
            SoundEvent soundEvent = this.getEatSound();
            if (soundEvent != null) {
                this.getWorld()
                        .playSound(
                                null, this.getX(), this.getY(), this.getZ(), soundEvent, this.getSoundCategory(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F
                        );
            }
        }
    }

    @Override
    public boolean handleFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource) {
        if (fallDistance > 1.0) {
            this.playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4F, 1.0F);
        }

        int i = this.computeFallDamage(fallDistance, damagePerDistance);
        if (i <= 0) {
            return false;
        } else {
            this.serverDamage(damageSource, i);
            this.handleFallDamageForPassengers(fallDistance, damagePerDistance, damageSource);
            this.playBlockFallSound();
            return true;
        }
    }

    public final int getInventorySize() {
        return getInventorySize(this.getInventoryColumns());
    }

    public static int getInventorySize(int columns) {
        return columns * 3;
    }

    protected void onChestedStatusChanged() {
        SimpleInventory simpleInventory = this.items;
        this.items = new SimpleInventory(this.getInventorySize());
        if (simpleInventory != null) {
            int i = Math.min(simpleInventory.size(), this.items.size());

            for (int j = 0; j < i; j++) {
                ItemStack itemStack = simpleInventory.getStack(j);
                if (!itemStack.isEmpty()) {
                    this.items.setStack(j, itemStack.copy());
                }
            }
        }
    }

    @Override
    protected RegistryEntry<SoundEvent> getEquipSound(EquipmentSlot slot, ItemStack stack, EquippableComponent equippableComponent) {
        return (RegistryEntry<SoundEvent>)(slot == EquipmentSlot.SADDLE ? SoundEvents.ENTITY_HORSE_SADDLE : super.getEquipSound(slot, stack, equippableComponent));
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        boolean bl = super.damage(world, source, amount);
        if (bl && this.random.nextInt(3) == 0) {
            this.updateAnger();
        }

        return bl;
    }

    protected boolean shouldAmbientStand() {
        return true;
    }

    @Nullable
    protected SoundEvent getEatSound() {
        return null;
    }

    @Nullable
    protected SoundEvent getAngrySound() {
        return null;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        if (!state.isLiquid()) {
            BlockState blockState = this.getWorld().getBlockState(pos.up());
            BlockSoundGroup blockSoundGroup = state.getSoundGroup();
            if (blockState.isOf(Blocks.SNOW)) {
                blockSoundGroup = blockState.getSoundGroup();
            }

            if (this.hasPassengers() && this.playExtraHorseSounds) {
                this.soundTicks++;
                if (this.soundTicks > 5 && this.soundTicks % 3 == 0) {
                    this.playWalkSound(blockSoundGroup);
                } else if (this.soundTicks <= 5) {
                    this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
                }
            } else if (this.isWooden(blockSoundGroup)) {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            } else {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP, blockSoundGroup.getVolume() * 0.15F, blockSoundGroup.getPitch());
            }
        }
    }

    private boolean isWooden(BlockSoundGroup soundGroup) {
        return soundGroup == BlockSoundGroup.WOOD
                || soundGroup == BlockSoundGroup.NETHER_WOOD
                || soundGroup == BlockSoundGroup.NETHER_STEM
                || soundGroup == BlockSoundGroup.CHERRY_WOOD
                || soundGroup == BlockSoundGroup.BAMBOO_WOOD;
    }

    protected void playWalkSound(BlockSoundGroup group) {
        this.playSound(SoundEvents.ENTITY_HORSE_GALLOP, group.getVolume() * 0.15F, group.getPitch());
    }

    public static DefaultAttributeContainer.Builder createBaseHorseAttributes() {
        return AnimalEntity.createAnimalAttributes()
                .add(EntityAttributes.JUMP_STRENGTH, 0.7)
                .add(EntityAttributes.MAX_HEALTH, 53.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.225F)
                .add(EntityAttributes.STEP_HEIGHT, 1.0)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 6.0)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.5);
    }

    @Override
    public int getLimitPerChunk() {
        return 6;
    }

    public int getMaxTemper() {
        return 100;
    }

    @Override
    protected float getSoundVolume() {
        return 0.8F;
    }

    @Override
    public int getMinAmbientSoundDelay() {
        return 400;
    }

    @Override
    public void openInventory(PlayerEntity player) {

    }

    public ActionResult interactHorse(PlayerEntity player, ItemStack stack) {
        boolean bl = this.receiveFood(player, stack);
        if (bl) {
            stack.decrementUnlessCreative(1, player);
        }

        return (ActionResult)(!bl && !this.getWorld().isClient ? ActionResult.PASS : ActionResult.SUCCESS_SERVER);
    }

    protected boolean receiveFood(PlayerEntity player, ItemStack item) {
        boolean bl = false;
        float f = 0.0F;
        int i = 0;
        int j = 0;
        if (item.isOf(Items.WHEAT)) {
            f = 2.0F;
            i = 20;
            j = 3;
        } else if (item.isOf(Items.SUGAR)) {
            f = 1.0F;
            i = 30;
            j = 3;
        } else if (item.isOf(Blocks.HAY_BLOCK.asItem())) {
            f = 20.0F;
            i = 180;
        } else if (item.isOf(Items.APPLE)) {
            f = 3.0F;
            i = 60;
            j = 3;
        } else if (item.isOf(Items.GOLDEN_CARROT)) {
            f = 4.0F;
            i = 60;
            j = 5;
            if (!this.getWorld().isClient && this.isTame() && this.getBreedingAge() == 0 && !this.isInLove()) {
                bl = true;
                this.lovePlayer(player);
            }
        } else if (item.isOf(Items.GOLDEN_APPLE) || item.isOf(Items.ENCHANTED_GOLDEN_APPLE)) {
            f = 10.0F;
            i = 240;
            j = 10;
            if (!this.getWorld().isClient && this.isTame() && this.getBreedingAge() == 0 && !this.isInLove()) {
                bl = true;
                this.lovePlayer(player);
            }
        }

        if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
            this.heal(f);
            bl = true;
        }

        if (this.isBaby() && i > 0) {
            this.getWorld().addParticleClient(ParticleTypes.HAPPY_VILLAGER, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), 0.0, 0.0, 0.0);
            if (!this.getWorld().isClient) {
                this.growUp(i);
                bl = true;
            }
        }

        if (j > 0 && (bl || !this.isTame()) && this.getTemper() < this.getMaxTemper() && !this.getWorld().isClient) {
            this.addTemper(j);
            bl = true;
        }

        if (bl) {
            this.playEatingAnimation();
            this.emitGameEvent(GameEvent.EAT);
        }

        return bl;
    }

    protected void putPlayerOnBack(PlayerEntity player) {
        this.setEatingGrass(false);
        this.setAngry(false);
        if (!this.getWorld().isClient) {
            player.setYaw(this.getYaw());
            player.setPitch(this.getPitch());
            player.startRiding(this);
        }
    }

    @Override
    public boolean isImmobile() {
        return super.isImmobile() && this.hasPassengers() && this.hasSaddleEquipped() || this.isEatingGrass() || this.isAngry();
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.HORSE_FOOD);
    }

    private void wagTail() {
        this.tailWagTicks = 1;
    }

    @Override
    protected void dropInventory(ServerWorld world) {
        super.dropInventory(world);
        if (this.items != null) {
            for (int i = 0; i < this.items.size(); i++) {
                ItemStack itemStack = this.items.getStack(i);
                if (!itemStack.isEmpty() && !EnchantmentHelper.hasAnyEnchantmentsWith(itemStack, EnchantmentEffectComponentTypes.PREVENT_EQUIPMENT_DROP)) {
                    this.dropStack(world, itemStack);
                }
            }
        }
    }

    @Override
    public void tickMovement() {
        if (this.random.nextInt(200) == 0) {
            this.wagTail();
        }

        super.tickMovement();
        if (this.getWorld() instanceof ServerWorld serverWorld && this.isAlive()) {
            if (this.random.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0F);
            }

            if (this.eatsGrass()) {
                if (!this.isEatingGrass()
                        && !this.hasPassengers()
                        && this.random.nextInt(300) == 0
                        && serverWorld.getBlockState(this.getBlockPos().down()).isOf(Blocks.GRASS_BLOCK)) {
                    this.setEatingGrass(true);
                }

                if (this.isEatingGrass() && ++this.eatingGrassTicks > 50) {
                    this.eatingGrassTicks = 0;
                    this.setEatingGrass(false);
                }
            }

            this.walkToParent(serverWorld);
        }
    }

    protected void walkToParent(ServerWorld world) {
        if (this.isBred() && this.isBaby() && !this.isEatingGrass()) {
            LivingEntity livingEntity = world.getClosestEntity(
                    AbstractMotoEntity.class, PARENT_HORSE_PREDICATE, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().expand(16.0)
            );
            if (livingEntity != null && this.squaredDistanceTo(livingEntity) > 4.0) {
                this.navigation.findPathTo(livingEntity, 0);
            }
        }
    }

    public boolean eatsGrass() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.eatingTicks > 0 && ++this.eatingTicks > 30) {
            this.eatingTicks = 0;
            this.setHorseFlag(EATING_FLAG, false);
        }

        if (this.canActVoluntarily() && this.angryTicks > 0 && ++this.angryTicks > 20) {
            this.angryTicks = 0;
            this.setAngry(false);
        }

        if (this.tailWagTicks > 0 && ++this.tailWagTicks > 8) {
            this.tailWagTicks = 0;
        }

        if (this.field_6958 > 0) {
            this.field_6958++;
            if (this.field_6958 > 300) {
                this.field_6958 = 0;
            }
        }

        this.lastEatingGrassAnimationProgress = this.eatingGrassAnimationProgress;
        if (this.isEatingGrass()) {
            this.eatingGrassAnimationProgress = this.eatingGrassAnimationProgress + ((1.0F - this.eatingGrassAnimationProgress) * 0.4F + 0.05F);
            if (this.eatingGrassAnimationProgress > 1.0F) {
                this.eatingGrassAnimationProgress = 1.0F;
            }
        } else {
            this.eatingGrassAnimationProgress = this.eatingGrassAnimationProgress + ((0.0F - this.eatingGrassAnimationProgress) * 0.4F - 0.05F);
            if (this.eatingGrassAnimationProgress < 0.0F) {
                this.eatingGrassAnimationProgress = 0.0F;
            }
        }

        this.lastAngryAnimationProgress = this.angryAnimationProgress;
        if (this.isAngry()) {
            this.eatingGrassAnimationProgress = 0.0F;
            this.lastEatingGrassAnimationProgress = this.eatingGrassAnimationProgress;
            this.angryAnimationProgress = this.angryAnimationProgress + ((1.0F - this.angryAnimationProgress) * 0.4F + 0.05F);
            if (this.angryAnimationProgress > 1.0F) {
                this.angryAnimationProgress = 1.0F;
            }
        } else {
            this.jumping = false;
            this.angryAnimationProgress = this.angryAnimationProgress
                    + ((0.8F * this.angryAnimationProgress * this.angryAnimationProgress * this.angryAnimationProgress - this.angryAnimationProgress) * 0.6F - 0.05F);
            if (this.angryAnimationProgress < 0.0F) {
                this.angryAnimationProgress = 0.0F;
            }
        }

        this.lastEatingAnimationProgress = this.eatingAnimationProgress;
        if (this.getHorseFlag(EATING_FLAG)) {
            this.eatingAnimationProgress = this.eatingAnimationProgress + ((1.0F - this.eatingAnimationProgress) * 0.7F + 0.05F);
            if (this.eatingAnimationProgress > 1.0F) {
                this.eatingAnimationProgress = 1.0F;
            }
        } else {
            this.eatingAnimationProgress = this.eatingAnimationProgress + ((0.0F - this.eatingAnimationProgress) * 0.7F - 0.05F);
            if (this.eatingAnimationProgress < 0.0F) {
                this.eatingAnimationProgress = 0.0F;
            }
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (this.hasPassengers() || this.isBaby()) {
            return super.interactMob(player, hand);
        } else if (this.isTame() && player.shouldCancelInteraction()) {
            this.openInventory(player);
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = player.getStackInHand(hand);
            if (!itemStack.isEmpty()) {
                ActionResult actionResult = itemStack.useOnEntity(player, this, hand);
                if (actionResult.isAccepted()) {
                    return actionResult;
                }

                if (this.canEquip(itemStack, EquipmentSlot.BODY) && !this.isWearingBodyArmor()) {
                    this.equipHorseArmor(player, itemStack);
                    return ActionResult.SUCCESS;
                }
            }

            this.putPlayerOnBack(player);
            return ActionResult.SUCCESS;
        }
    }

    private void setEating() {
        if (!this.getWorld().isClient) {
            this.eatingTicks = 1;
            this.setHorseFlag(EATING_FLAG, true);
        }
    }

    public void setEatingGrass(boolean eatingGrass) {
        this.setHorseFlag(EATING_GRASS_FLAG, eatingGrass);
    }

    public void setAngry(boolean angry) {
        if (angry) {
            this.setEatingGrass(false);
        }

        this.setHorseFlag(ANGRY_FLAG, angry);
    }

    @Nullable
    public SoundEvent getAmbientStandSound() {
        return this.getAmbientSound();
    }

    public void updateAnger() {
        if (this.shouldAmbientStand() && this.canActVoluntarily()) {
            this.angryTicks = 1;
            this.setAngry(true);
        }
    }

    public void playAngrySound() {
        if (!this.isAngry()) {
            this.updateAnger();
            this.playSound(this.getAngrySound());
        }
    }

    public boolean bondWithPlayer(PlayerEntity player) {
        this.setOwner(player);
        this.setTame(true);
        if (player instanceof ServerPlayerEntity) {
            Criteria.TAME_ANIMAL.trigger((ServerPlayerEntity)player, this);
        }

        this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        return true;
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);
        Vec2f vec2f = this.getControlledRotation(controllingPlayer);
        this.setRotation(vec2f.y, vec2f.x);
        this.lastYaw = this.bodyYaw = this.headYaw = this.getYaw();
        if (this.isLogicalSideForUpdatingMovement()) {
            if (movementInput.z <= 0.0) {
                this.soundTicks = 0;
            }

            if (this.isOnGround()) {
                this.setInAir(false);
                if (this.jumpStrength > 0.0F && !this.isInAir()) {
                    this.jump(this.jumpStrength, movementInput);
                }

                this.jumpStrength = 0.0F;
            }
        }
    }

    protected Vec2f getControlledRotation(LivingEntity controllingPassenger) {
        return new Vec2f(controllingPassenger.getPitch() * 0.5F, controllingPassenger.getYaw());
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
        if (this.isOnGround() && this.jumpStrength == 0.0F && this.isAngry() && !this.jumping) {
            return Vec3d.ZERO;
        } else {
            float f = controllingPlayer.sidewaysSpeed * 0.5F;
            float g = controllingPlayer.forwardSpeed;
            if (g <= 0.0F) {
                g *= 0.25F;
            }

            return new Vec3d(f, 0.0, g);
        }
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        return (float)this.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
    }

    protected void jump(float strength, Vec3d movementInput) {
        double d = this.getJumpVelocity(strength);
        Vec3d vec3d = this.getVelocity();
        this.setVelocity(vec3d.x, d, vec3d.z);
        this.setInAir(true);
        this.velocityDirty = true;
        if (movementInput.z > 0.0) {
            float f = MathHelper.sin(this.getYaw() * (float) (Math.PI / 180.0));
            float g = MathHelper.cos(this.getYaw() * (float) (Math.PI / 180.0));
            this.setVelocity(this.getVelocity().add(-0.4F * f * strength, 0.0, 0.4F * g * strength));
        }
    }

    protected void playJumpSound() {
        this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("EatingHaystack", this.isEatingGrass());
        nbt.putBoolean("Bred", this.isBred());
        nbt.putInt("Temper", this.getTemper());
        nbt.putBoolean("Tame", this.isTame());
        if (this.ownerReference != null) {
            this.ownerReference.writeNbt(nbt, "Owner");
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setEatingGrass(nbt.getBoolean("EatingHaystack", false));
        this.setBred(nbt.getBoolean("Bred", false));
        this.setTemper(nbt.getInt("Temper", 0));
        this.setTame(nbt.getBoolean("Tame", false));
        this.ownerReference = LazyEntityReference.fromNbtOrPlayerName(nbt, "Owner", this.getWorld());
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        return false;
    }

    protected boolean canBreed() {
        return !this.hasPassengers() && !this.hasVehicle() && this.isTame() && !this.isBaby() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    protected void setChildAttributes(PassiveEntity other, AbstractMotoEntity child) {
        this.setChildAttribute(other, child, EntityAttributes.MAX_HEALTH, MIN_HEALTH_BONUS, MAX_HEALTH_BONUS);
        this.setChildAttribute(other, child, EntityAttributes.JUMP_STRENGTH, MIN_JUMP_STRENGTH_BONUS, MAX_JUMP_STRENGTH_BONUS);
        this.setChildAttribute(other, child, EntityAttributes.MOVEMENT_SPEED, MIN_MOVEMENT_SPEED_BONUS, MAX_MOVEMENT_SPEED_BONUS);
    }

    private void setChildAttribute(PassiveEntity other, AbstractMotoEntity child, RegistryEntry<EntityAttribute> attribute, double min, double max) {
        double d = calculateAttributeBaseValue(this.getAttributeBaseValue(attribute), other.getAttributeBaseValue(attribute), min, max, this.random);
        child.getAttributeInstance(attribute).setBaseValue(d);
    }

    static double calculateAttributeBaseValue(double parentBase, double otherParentBase, double min, double max, Random random) {
        if (max <= min) {
            throw new IllegalArgumentException("Incorrect range for an attribute");
        } else {
            parentBase = MathHelper.clamp(parentBase, min, max);
            otherParentBase = MathHelper.clamp(otherParentBase, min, max);
            double d = 0.15 * (max - min);
            double e = Math.abs(parentBase - otherParentBase) + d * 2.0;
            double f = (parentBase + otherParentBase) / 2.0;
            double g = (random.nextDouble() + random.nextDouble() + random.nextDouble()) / 3.0 - 0.5;
            double h = f + e * g;
            if (h > max) {
                double i = h - max;
                return max - i;
            } else if (h < min) {
                double i = min - h;
                return min + i;
            } else {
                return h;
            }
        }
    }

    public float getEatingGrassAnimationProgress(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastEatingGrassAnimationProgress, this.eatingGrassAnimationProgress);
    }

    public float getAngryAnimationProgress(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastAngryAnimationProgress, this.angryAnimationProgress);
    }

    public float getEatingAnimationProgress(float tickProgress) {
        return MathHelper.lerp(tickProgress, this.lastEatingAnimationProgress, this.eatingAnimationProgress);
    }

    @Override
    public void setJumpStrength(int strength) {
        if (this.hasSaddleEquipped()) {
            if (strength < 0) {
                strength = 0;
            } else {
                this.jumping = true;
                this.updateAnger();
            }

            if (strength >= 90) {
                this.jumpStrength = 1.0F;
            } else {
                this.jumpStrength = 0.4F + 0.4F * strength / 90.0F;
            }
        }
    }

    @Override
    public boolean canJump() {
        return this.hasSaddleEquipped();
    }

    @Override
    public void startJumping(int height) {
        this.jumping = true;
        this.updateAnger();
        this.playJumpSound();
    }

    @Override
    public void stopJumping() {
    }

    protected void spawnPlayerReactionParticles(boolean positive) {
        ParticleEffect particleEffect = positive ? ParticleTypes.HEART : ParticleTypes.SMOKE;

        for (int i = 0; i < 7; i++) {
            double d = this.random.nextGaussian() * 0.02;
            double e = this.random.nextGaussian() * 0.02;
            double f = this.random.nextGaussian() * 0.02;
            this.getWorld().addParticleClient(particleEffect, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), d, e, f);
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES) {
            this.spawnPlayerReactionParticles(true);
        } else if (status == EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES) {
            this.spawnPlayerReactionParticles(false);
        } else {
            super.handleStatus(status);
        }
    }

    @Override
    protected void updatePassengerPosition(Entity passenger, Entity.PositionUpdater positionUpdater) {
        super.updatePassengerPosition(passenger, positionUpdater);
        if (passenger instanceof LivingEntity) {
            ((LivingEntity)passenger).bodyYaw = this.bodyYaw;
        }
    }

    protected static float getChildHealthBonus(IntUnaryOperator randomIntGetter) {
        return 15.0F + randomIntGetter.applyAsInt(8) + randomIntGetter.applyAsInt(9);
    }

    protected static double getChildJumpStrengthBonus(DoubleSupplier randomDoubleGetter) {
        return 0.4F + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2 + randomDoubleGetter.getAsDouble() * 0.2;
    }

    protected static double getChildMovementSpeedBonus(DoubleSupplier randomDoubleGetter) {
        return (0.45F + randomDoubleGetter.getAsDouble() * 0.3 + randomDoubleGetter.getAsDouble() * 0.3 + randomDoubleGetter.getAsDouble() * 0.3) * 0.25;
    }

    @Override
    public boolean isClimbing() {
        return false;
    }

    @Override
    public StackReference getStackReference(int mappedIndex) {
        int i = mappedIndex - 500;
        return i >= 0 && i < this.items.size() ? StackReference.of(this.items, i) : super.getStackReference(mappedIndex);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return (LivingEntity)(this.hasSaddleEquipped() && this.getFirstPassenger() instanceof PlayerEntity playerEntity
                ? playerEntity
                : super.getControllingPassenger());
    }

    @Nullable
    private Vec3d locateSafeDismountingPos(Vec3d offset, LivingEntity passenger) {
        double d = this.getX() + offset.x;
        double e = this.getBoundingBox().minY;
        double f = this.getZ() + offset.z;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (EntityPose entityPose : passenger.getPoses()) {
            mutable.set(d, e, f);
            double g = this.getBoundingBox().maxY + 0.75;

            do {
                double h = this.getWorld().getDismountHeight(mutable);
                if (mutable.getY() + h > g) {
                    break;
                }

                if (Dismounting.canDismountInBlock(h)) {
                    Box box = passenger.getBoundingBox(entityPose);
                    Vec3d vec3d = new Vec3d(d, mutable.getY() + h, f);
                    if (Dismounting.canPlaceEntityAt(this.getWorld(), passenger, box.offset(vec3d))) {
                        passenger.setPose(entityPose);
                        return vec3d;
                    }
                }

                mutable.move(Direction.UP);
            } while (!(mutable.getY() < g));
        }

        return null;
    }

    @Override
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        Vec3d vec3d = getPassengerDismountOffset(this.getWidth(), passenger.getWidth(), this.getYaw() + (passenger.getMainArm() == Arm.RIGHT ? 90.0F : -90.0F));
        Vec3d vec3d2 = this.locateSafeDismountingPos(vec3d, passenger);
        if (vec3d2 != null) {
            return vec3d2;
        } else {
            Vec3d vec3d3 = getPassengerDismountOffset(this.getWidth(), passenger.getWidth(), this.getYaw() + (passenger.getMainArm() == Arm.LEFT ? 90.0F : -90.0F));
            Vec3d vec3d4 = this.locateSafeDismountingPos(vec3d3, passenger);
            return vec3d4 != null ? vec3d4 : this.getPos();
        }
    }

    protected void initAttributes(Random random) {
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        if (entityData == null) {
            entityData = new PassiveEntity.PassiveData(0.2F);
        }

        this.initAttributes(world.getRandom());
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public boolean areInventoriesDifferent(Inventory inventory) {
        return this.items != inventory;
    }

    public int getMinAmbientStandDelay() {
        return this.getMinAmbientSoundDelay();
    }

    @Override
    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return super.getPassengerAttachmentPos(passenger, dimensions, scaleFactor);
    }

    public int getInventoryColumns() {
        return 0;
    }
}

