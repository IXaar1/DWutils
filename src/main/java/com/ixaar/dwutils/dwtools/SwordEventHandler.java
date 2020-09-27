package com.ixaar.dwutils.dwtools;

import com.ixaar.dwutils.DragonworldUtils;
import com.ixaar.dwutils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SwordEventHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(MouseEvent e) {
        if (e.getButton() == 0 && e.isButtonstate()) {
            Minecraft mc = Minecraft.getMinecraft();
            if (mc.player.inventory.getCurrentItem() != null && !mc.player.inventory.getCurrentItem().isEmpty()) {
                Item i = mc.player.inventory.getCurrentItem().getItem();
                if (i instanceof IExtendedReach) {
                    IExtendedReach icr = (IExtendedReach) i;
                    Entity hit = Utils.getMouseOverExtended(icr.getReach()).entityHit;
                    if (hit != null && mc.objectMouseOver.entityHit == null && hit != mc.player) {
                        DragonworldUtils.network.sendToServer(new MessageCustomReachAttack(hit.getEntityId()));
                    }
                }
            }
        }

    }

}
