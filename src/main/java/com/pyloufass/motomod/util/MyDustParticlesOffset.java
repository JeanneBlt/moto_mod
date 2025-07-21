package com.pyloufass.motomod.util;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public record MyDustParticlesOffset(double xd, double yd, double zd) {

    public static MyDustParticlesOffset fromSide(Vec3d userRotation, Direction side) {
        return switch (side) {
            case DOWN, UP -> new MyDustParticlesOffset(userRotation.getZ(), 0.0, -userRotation.getX());
            case NORTH -> new MyDustParticlesOffset(1.0, 0.0, -0.1);
            case SOUTH -> new MyDustParticlesOffset(-1.0, 0.0, 0.1);
            case WEST -> new MyDustParticlesOffset(-0.1, 0.0, -1.0);
            case EAST -> new MyDustParticlesOffset(0.1, 0.0, 1.0);
        };
    }
}
