package com.ixaar.dwutils;

import com.ixaar.dwutils.dwitems.DWItemGeneric;
import com.ixaar.dwutils.dwitems.DWRegenStone;
import com.ixaar.dwutils.dwtools.DWPike;
import com.ixaar.dwutils.dwtools.DWShield;
import com.ixaar.dwutils.dwtools.DWSword;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@GameRegistry.ObjectHolder("dwutils")
@Mod.EventBusSubscriber
public class ModRegister {

    @GameRegistry.ObjectHolder("iron_sword_1")
    public static final Item IRON_SWORD_1 = null;
    @GameRegistry.ObjectHolder("iron_sword_2")
    public static final Item IRON_SWORD_2 = null;
    @GameRegistry.ObjectHolder("iron_sword_3")
    public static final Item IRON_SWORD_3 = null;
    @GameRegistry.ObjectHolder("iron_sword_4")
    public static final Item IRON_SWORD_4 = null;

    @GameRegistry.ObjectHolder("f_iron_pike_7")
    public static final Item f_IRON_PIKE_7 = null;
    @GameRegistry.ObjectHolder("f_iron_pike_8")
    public static final Item f_IRON_PIKE_8 = null;
    @GameRegistry.ObjectHolder("f_iron_pike_9")
    public static final Item f_IRON_PIKE_9 = null;
    @GameRegistry.ObjectHolder("f_iron_pike_10")
    public static final Item f_IRON_PIKE_10 = null;

    @GameRegistry.ObjectHolder("o_iron_pike_7")
    public static final Item o_IRON_PIKE_7 = null;
    @GameRegistry.ObjectHolder("o_iron_pike_8")
    public static final Item o_IRON_PIKE_8 = null;
    @GameRegistry.ObjectHolder("o_iron_pike_9")
    public static final Item o_IRON_PIKE_9 = null;
    @GameRegistry.ObjectHolder("o_iron_pike_10")
    public static final Item o_IRON_PIKE_10 = null;

    @GameRegistry.ObjectHolder("regen_stone")
    public static final Item REGEN_STONE = null;

    @GameRegistry.ObjectHolder("two_handed_iron_sword")
    public static final Item TWO_HANDED_IRON_SWORD = null;
    @GameRegistry.ObjectHolder("two_handed_diamond_sword")
    public static final Item TWO_HANDED_DIAMOND_SWORD = null;

    @GameRegistry.ObjectHolder("shield_100")
    public static final Item SHIELD_100 = null;
    @GameRegistry.ObjectHolder("shield_250")
    public static final Item SHIELD_250 = null;
    @GameRegistry.ObjectHolder("shield_500")
    public static final Item SHIELD_500 = null;
    @GameRegistry.ObjectHolder("shield_750")
    public static final Item SHIELD_750 = null;
    @GameRegistry.ObjectHolder("shield_1000")
    public static final Item SHIELD_1000 = null;

    @GameRegistry.ObjectHolder("copper_coin")
    public static final Item COPPER_COIN = null;
    @GameRegistry.ObjectHolder("silver_coin")
    public static final Item SILVER_COIN = null;
    @GameRegistry.ObjectHolder("gold_coin")
    public static final Item GOLD_COIN = null;


    public static Item.ToolMaterial mat_iron_dur1 = EnumHelper.addToolMaterial("dwutils:mat_dur1", 2, 1, 6.0F, 2.0F, 12);
    public static Item.ToolMaterial mat_iron_dur2 = EnumHelper.addToolMaterial("dwutils:mat_dur2", 2, 2, 6.0F, 2.0F, 12);
    public static Item.ToolMaterial mat_iron_dur3 = EnumHelper.addToolMaterial("dwutils:mat_dur3", 2, 3, 6.0F, 2.0F, 12);
    public static Item.ToolMaterial mat_iron_dur4 = EnumHelper.addToolMaterial("dwutils:mat_dur4", 2, 4, 6.0F, 2.0F, 12);

    public static Item.ToolMaterial mat_iron_dur250 = EnumHelper.addToolMaterial("dwutils:mat_dur250", 2, 250, 6.0F, 2.0F, 12);
    public static Item.ToolMaterial mat_diamond_dur1561 = EnumHelper.addToolMaterial("dwutils:mat_dur1561", 3, 1561, 8.0F, 3.0F, 9);


    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().register(new DWSword("iron_sword_1", mat_iron_dur1, false));
        e.getRegistry().register(new DWSword("iron_sword_2", mat_iron_dur2, false));
        e.getRegistry().register(new DWSword("iron_sword_3", mat_iron_dur3, false));
        e.getRegistry().register(new DWSword("iron_sword_4", mat_iron_dur4, false));

        e.getRegistry().register(new DWPike("f_iron_pike_7", mat_iron_dur4, 7.0F));
        e.getRegistry().register(new DWPike("f_iron_pike_8", mat_iron_dur4, 8.0F));
        e.getRegistry().register(new DWPike("f_iron_pike_9", mat_iron_dur4, 9.0F));
        e.getRegistry().register(new DWPike("f_iron_pike_10", mat_iron_dur4, 10.0F));

        e.getRegistry().register(new DWPike("o_iron_pike_7", mat_iron_dur1, 7.0F));
        e.getRegistry().register(new DWPike("o_iron_pike_8", mat_iron_dur1, 8.0F));
        e.getRegistry().register(new DWPike("o_iron_pike_9", mat_iron_dur1, 9.0F));
        e.getRegistry().register(new DWPike("o_iron_pike_10", mat_iron_dur1, 10.0F));

        e.getRegistry().register(new DWRegenStone("regen_stone"));

        e.getRegistry().register(new DWSword("two_handed_iron_sword", mat_iron_dur250, true));
        e.getRegistry().register(new DWSword("two_handed_diamond_sword", mat_diamond_dur1561, true));

        e.getRegistry().register(new DWShield("shield_100", 100));
        e.getRegistry().register(new DWShield("shield_250", 250));
        e.getRegistry().register(new DWShield("shield_500", 500));
        e.getRegistry().register(new DWShield("shield_750", 750));
        e.getRegistry().register(new DWShield("shield_1000", 1000));

        e.getRegistry().register(new DWItemGeneric("copper_coin", true, EnumRarity.UNCOMMON));
        e.getRegistry().register(new DWItemGeneric("silver_coin", true, EnumRarity.RARE));
        e.getRegistry().register(new DWItemGeneric("gold_coin", true, EnumRarity.EPIC));


    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {

        registryModel(IRON_SWORD_1);
        registryModel(IRON_SWORD_2);
        registryModel(IRON_SWORD_3);
        registryModel(IRON_SWORD_4);

        registryModel(f_IRON_PIKE_7);
        registryModel(f_IRON_PIKE_8);
        registryModel(f_IRON_PIKE_9);
        registryModel(f_IRON_PIKE_10);

        registryModel(o_IRON_PIKE_7);
        registryModel(o_IRON_PIKE_8);
        registryModel(o_IRON_PIKE_9);
        registryModel(o_IRON_PIKE_10);

        registryModel(REGEN_STONE);

        registryModel(TWO_HANDED_IRON_SWORD);
        registryModel(TWO_HANDED_DIAMOND_SWORD);

        registryModel(SHIELD_100);
        registryModel(SHIELD_250);
        registryModel(SHIELD_500);
        registryModel(SHIELD_750);
        registryModel(SHIELD_1000);

        registryModel(COPPER_COIN);
        registryModel(SILVER_COIN);
        registryModel(GOLD_COIN);

    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
    }


}
