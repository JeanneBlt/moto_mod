package com.pyloufass.motomod.status;

import com.pyloufass.motomod.MotoMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatus {
    public static final RegistryEntry<StatusEffect> COLORFULL = registerStatusEffect("colorfull",
            new ColorfullStatus(StatusEffectCategory.NEUTRAL, 0xe6e6fa));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MotoMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MotoMod.LOGGER.info("Registering Mod Effects for " + MotoMod.MOD_ID);
    }
}
