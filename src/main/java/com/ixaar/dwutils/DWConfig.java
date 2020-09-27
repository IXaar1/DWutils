package com.ixaar.dwutils;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = "dwutils", name = "Dragonworld Utils")
public class DWConfig {


    public static final PrisonPosition prison_position = new PrisonPosition(0, 0, 0, 0);
    @Config.RangeInt(min = 0, max = 20)
    @Config.Comment("Food pay for Regen Stone")
    public static int FoodPay = 8;
    @Config.Comment("Item that will be used as coin")
    public static String item = "dwutils:silver_coin";

    public static final class PrisonPosition {
        @Config.Comment("The dimention ID")
        public int dim;
        @Config.Comment("The x coordinate")
        public double x;
        @Config.Comment("The y coordinate")
        public double y;
        @Config.Comment("The z coordinate")
        public double z;

        public PrisonPosition(final int dim, final double x, final double y, final double z) {
            this.dim = dim;
            this.x = x;
            this.y = y;
            this.z = y;
        }
    }

    @Mod.EventBusSubscriber(modid = "dwutils")
    private static class EHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent e) {
            if (e.getModID().equals("dwutils")) {
                ConfigManager.sync("dwutils", Config.Type.INSTANCE);
            }
        }
    }
}
