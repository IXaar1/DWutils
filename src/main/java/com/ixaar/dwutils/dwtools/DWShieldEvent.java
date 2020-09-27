package com.ixaar.dwutils.dwtools;

import com.ixaar.dwutils.ModRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DWShieldEvent {

    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent event) {
        Entity entity = event != null ? event.getEntity() : null;
        float damage = event.getAmount();
        int damageInt = (int) damage;
        if (entity != null && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack activeItem = player.getActiveItemStack();

            if (player.isActiveItemStackBlocking() == true && ((activeItem).getItem() == new ItemStack(ModRegister.SHIELD_100, (int) (1)).getItem())) {

                activeItem.damageItem(damageInt, player);
            }
            if (player.isActiveItemStackBlocking() == true && ((activeItem).getItem() == new ItemStack(ModRegister.SHIELD_250, (int) (1)).getItem())) {

                activeItem.damageItem(damageInt, player);
            }
            if (player.isActiveItemStackBlocking() == true && ((activeItem).getItem() == new ItemStack(ModRegister.SHIELD_500, (int) (1)).getItem())) {

                activeItem.damageItem(damageInt, player);
            }
            if (player.isActiveItemStackBlocking() == true && ((activeItem).getItem() == new ItemStack(ModRegister.SHIELD_750, (int) (1)).getItem())) {

                activeItem.damageItem(damageInt, player);
            }
            if (player.isActiveItemStackBlocking() == true && ((activeItem).getItem() == new ItemStack(ModRegister.SHIELD_1000, (int) (1)).getItem())) {

                activeItem.damageItem(damageInt, player);
            }
        }
    }

}
