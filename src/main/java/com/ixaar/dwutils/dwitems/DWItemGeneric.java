package com.ixaar.dwutils.dwitems;

import com.ixaar.dwutils.DragonworldUtils;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DWItemGeneric extends Item {

    private boolean effect;
    private EnumRarity rarity;

    public DWItemGeneric(String name, boolean effect, EnumRarity rarity) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(DragonworldUtils.CTAB);
        this.setMaxStackSize(64);
        this.effect = effect;
        this.rarity = rarity;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return rarity;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return effect;
    }
}
