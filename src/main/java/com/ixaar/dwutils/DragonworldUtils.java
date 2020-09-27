package com.ixaar.dwutils;

import com.ixaar.dwutils.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = "dwutils", version = "0.8.1-hotfix2")
public class DragonworldUtils {

    public static final CreativeTabs CTAB = new CreativeTabs("dwtab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModRegister.IRON_SWORD_1);
        }
    };
    @SidedProxy(clientSide = "com.ixaar.dwutils.proxy.ClientProxy", serverSide = "com.ixaar.dwutils.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
        proxy.serverStarting(e);
    }

}
