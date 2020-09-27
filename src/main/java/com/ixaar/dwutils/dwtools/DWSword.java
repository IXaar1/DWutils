package com.ixaar.dwutils.dwtools;

import com.ixaar.dwutils.DragonworldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;


public class DWSword extends ItemSword {

    private Boolean th;

    public DWSword(String name, ToolMaterial material, Boolean twohanded) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DragonworldUtils.CTAB);
        this.th = twohanded;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (th) {
            if (!player.getHeldItem(EnumHand.OFF_HAND).isEmpty()) {
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 5, 255));
                player.sendMessage(new TextComponentString("U can't use two-handed weapon while handing items in the off-hand"));
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
