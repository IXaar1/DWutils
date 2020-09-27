package com.ixaar.dwutils.dwcommands;

import com.ixaar.dwutils.DWConfig;
import com.ixaar.dwutils.Utils;
import net.minecraft.command.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class CommandCustomTeleport extends CommandBase {

    @Override
    public String getName() {
        return "tpz";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/tpz [nickname] <x> <y> <z> [cost]";
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 5) throw new WrongUsageException(this.getUsage(sender));

        Entity entity = getEntity(server, sender, args[0]);
        Item item = Item.getByNameOrId(DWConfig.item);

        if (entity == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[]{args[0]});
        }

        int cost = Integer.parseInt(args[4]);


        boolean itemFound = false;
        int itemCount = 0;


        for (int i = 0; i < 36; i++) {
            if (((EntityPlayer) entity).inventory.getStackInSlot(i).getItem() == item) {
                itemFound = true;
                itemCount = itemCount + ((EntityPlayer) entity).inventory.getStackInSlot(i).getCount();

            }
        }


        if (!itemFound || cost > itemCount) {
            ((EntityPlayer) entity).sendMessage(new TextComponentString(Utils.getLang().localize("commands.customteleport.fail")));
        } else if (entity.world != null) {
            while (cost > 0) {
                int slot = ((EntityPlayer) entity).inventory.findSlotMatchingUnusedItem(new ItemStack(item));
                int temp = ((EntityPlayer) entity).inventory.getStackInSlot(slot).getCount();
                ((EntityPlayer) entity).inventory.getStackInSlot(slot).setCount(((EntityPlayer) entity).inventory.getStackInSlot(slot).getCount() - cost);
                cost = cost - temp;
            }
            CommandBase.CoordinateArg x = parseCoordinate(entity.posX, args[1], true);
            CommandBase.CoordinateArg y = parseCoordinate(entity.posY, args[2], true);
            CommandBase.CoordinateArg z = parseCoordinate(entity.posZ, args[3], true);
            CommandBase.CoordinateArg yaw = parseCoordinate((double) entity.rotationYaw, "0", false);
            CommandBase.CoordinateArg pitch = parseCoordinate((double) entity.rotationPitch, "0", false);


            teleportEntityToCoordinates(entity, x, y, z, yaw, pitch);
            notifyCommandListener(sender, this, "commands.tp.success.coordinates", new Object[]{entity.getName(), x.getResult(), y.getResult(), z.getResult()});
        }

    }

    private static void teleportEntityToCoordinates(Entity teleportingEntity, CommandBase.CoordinateArg argX, CommandBase.CoordinateArg argY, CommandBase.CoordinateArg argZ, CommandBase.CoordinateArg argYaw, CommandBase.CoordinateArg argPitch) {
        if (teleportingEntity instanceof EntityPlayerMP) {
            Set<SPacketPlayerPosLook.EnumFlags> set = EnumSet.<SPacketPlayerPosLook.EnumFlags>noneOf(SPacketPlayerPosLook.EnumFlags.class);

            if (argX.isRelative()) {
                set.add(SPacketPlayerPosLook.EnumFlags.X);
            }

            if (argY.isRelative()) {
                set.add(SPacketPlayerPosLook.EnumFlags.Y);
            }

            if (argZ.isRelative()) {
                set.add(SPacketPlayerPosLook.EnumFlags.Z);
            }

            if (argPitch.isRelative()) {
                set.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }

            if (argYaw.isRelative()) {
                set.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }

            float f = (float) argYaw.getAmount();

            if (!argYaw.isRelative()) {
                f = MathHelper.wrapDegrees(f);
            }

            float f1 = (float) argPitch.getAmount();

            if (!argPitch.isRelative()) {
                f1 = MathHelper.wrapDegrees(f1);
            }

            teleportingEntity.dismountRidingEntity();
            ((EntityPlayerMP) teleportingEntity).connection.setPlayerLocation(argX.getAmount(), argY.getAmount(), argZ.getAmount(), f, f1, set);
            teleportingEntity.setRotationYawHead(f);
        } else {
            float f2 = (float) MathHelper.wrapDegrees(argYaw.getResult());
            float f3 = (float) MathHelper.wrapDegrees(argPitch.getResult());
            f3 = MathHelper.clamp(f3, -90.0F, 90.0F);
            teleportingEntity.setLocationAndAngles(argX.getResult(), argY.getResult(), argZ.getResult(), f2, f3);
            teleportingEntity.setRotationYawHead(f2);
        }

        if (!(teleportingEntity instanceof EntityLivingBase) || !((EntityLivingBase) teleportingEntity).isElytraFlying()) {
            teleportingEntity.motionY = 0.0D;
            teleportingEntity.onGround = true;
        }
    }
}
