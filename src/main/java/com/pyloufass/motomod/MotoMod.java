package com.pyloufass.motomod;

import com.pyloufass.motomod.block.ModBlocks;
import com.pyloufass.motomod.block.entity.ModBlockEntities;
import com.pyloufass.motomod.component.ModDataComponentTypes;
import com.pyloufass.motomod.entity.ModEntities;
import com.pyloufass.motomod.entity.custom.MotoEntity;
import com.pyloufass.motomod.item.ModItems;
import com.pyloufass.motomod.status.ModStatus;
import net.fabricmc.api.ModInitializer;
import com.pyloufass.motomod.item.ModItemGroups;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MotoMod implements ModInitializer {
	public static final String MOD_ID = "motomod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModItems.registerModItems();

		ModDataComponentTypes.registerDataComponentTypes();

		ModStatus.registerEffects();

		FabricDefaultAttributeRegistry.register(ModEntities.MOTO, MotoEntity.createMotoAttributes());
	}
}