package com.ixaar.dwutils.dwcommands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CustomTeleporter extends net.minecraft.world.Teleporter {

    private final WorldServer world;
    private double x, y, z;

    public CustomTeleporter(WorldServer world, double x, double y, double z) {
        super(world);
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void teleportTo(EntityPlayer player, int dimension, double x, double y, double z) {
        int oldDimension = player.getEntityWorld().provider.getDimension();
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);

        if (oldDimension == dimension) {
            player.setPositionAndUpdate(x, y, z);

            return;
        }


        if (worldServer == null || server == null)
            throw new IllegalArgumentException("Dimension: " + dimension + " not found");
        player.changeDimension(dimension);
        player.setPositionAndUpdate(x, y, z);


    }
}
