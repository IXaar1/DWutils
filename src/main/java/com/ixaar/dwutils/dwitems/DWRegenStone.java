package com.ixaar.dwutils.dwitems;

import com.ixaar.dwutils.DWConfig;
import com.ixaar.dwutils.DragonworldUtils;
import com.ixaar.dwutils.Utils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DWRegenStone extends Item {

    public DWRegenStone(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(DragonworldUtils.CTAB);
        this.setMaxStackSize(1);
        this.setMaxDamage(10);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        if (!world.isRemote) {

            if (player.getHealth() < player.getMaxHealth()) {

                int foodPay = DWConfig.FoodPay; //food pay for use
                if (player.getFoodStats().getFoodLevel() > 0 && player.getFoodStats().getFoodLevel() >= foodPay) {
                    player.heal(8.0F);
                    player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() - foodPay);
                } else {

                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, 400, 5));
                    player.getFoodStats().setFoodLevel(0);

                }

                player.getHeldItem(hand).damageItem(1, player);

                player.getCooldownTracker().setCooldown(this, 200);
            }

        }

        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TextFormatting.GREEN + Utils.getLang().localize("regen_stone.tooltip.1"));
        tooltip.add(TextFormatting.RED + Utils.getLang().localize("regen_stone.tooltip.2") + DWConfig.FoodPay);
    }
}
