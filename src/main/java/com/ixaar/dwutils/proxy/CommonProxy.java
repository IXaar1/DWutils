package com.ixaar.dwutils.proxy;

import com.ixaar.dwutils.DragonworldUtils;
import com.ixaar.dwutils.dwcommands.CommandCustomTeleport;
import com.ixaar.dwutils.dwcommands.CommandPrison;
import com.ixaar.dwutils.dwtools.DWShieldEvent;
import com.ixaar.dwutils.dwtools.MessageCustomReachAttack;
import com.ixaar.dwutils.dwtools.SwordEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(new SwordEventHandler());
        MinecraftForge.EVENT_BUS.register(new SwordEventHandler());


        FMLCommonHandler.instance().bus().register(new DWShieldEvent());
        MinecraftForge.EVENT_BUS.register(new DWShieldEvent());

        DragonworldUtils.network = NetworkRegistry.INSTANCE.newSimpleChannel("DWPACKET");

        int packetId = 0;

        DragonworldUtils.network.registerMessage(MessageCustomReachAttack.Handler.class,
                MessageCustomReachAttack.class, packetId++, Side.SERVER);
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void serverStarting(FMLServerStartingEvent e) {
        e.registerServerCommand(new CommandPrison());
        e.registerServerCommand(new CommandCustomTeleport());
    }

    public Object getPlayerEntityFromContext(MessageContext ctx) {
        return ctx.getServerHandler().player;
    }
}
