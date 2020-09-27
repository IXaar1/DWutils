package com.ixaar.dwutils.dwcommands;

import com.google.common.collect.Lists;
import com.ixaar.dwutils.DWConfig;
import com.ixaar.dwutils.Utils;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.Collections;
import java.util.List;

public class CommandPrison extends CommandBase {

    private final List<String> aliases = Lists.newArrayList("p", "prison");

    @Override
    public String getName() {
        return "p";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/prison <name>";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return args.length >= 1 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {


        if (args.length != 1) throw new WrongUsageException(this.getUsage(sender));

        EntityPlayer player = server.getPlayerList().getPlayerByUsername(args[0]);

        if (player == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[]{args[0]});
        }


        CustomTeleporter.teleportTo(player, DWConfig.prison_position.dim, DWConfig.prison_position.x, DWConfig.prison_position.y, DWConfig.prison_position.z);


        TextComponentTranslation CommandSuccessMessage = new TextComponentTranslation(DWConfig.prison_localisation.command_prison_success_1 + " " + player.getName() + " " + DWConfig.prison_localisation.command_prison_success_2);
        CommandSuccessMessage.getStyle().setColor(TextFormatting.GREEN);
        server.getPlayerList().getPlayerByUsername(sender.getName()).sendMessage(CommandSuccessMessage);
        player.sendMessage(new TextComponentString(DWConfig.prison_localisation.command_prison_notify_player));

    }


}
