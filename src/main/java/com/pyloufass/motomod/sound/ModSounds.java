package com.pyloufass.motomod.sound;

import com.pyloufass.motomod.MotoMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent FART = registerSoundEvent("fart");

    public static final BlockSoundGroup FART_SOUNDS = new BlockSoundGroup(1f, 1f,
            FART, FART, FART, FART, FART);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MotoMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        MotoMod.LOGGER.info("Registering Mod Sounds for " + MotoMod.MOD_ID);
    }
}
