package com.ixaar.dwutils.dwtools;

import com.ixaar.dwutils.DragonworldUtils;
import net.minecraft.item.ItemSword;

public class DWPike extends ItemSword implements IExtendedReach {

    private Float reach;

    public DWPike(String name, ToolMaterial material, Float Reach) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(DragonworldUtils.CTAB);
        this.reach = Reach;

    }

    @Override
    public float getReach() {
        return reach;
    }

}
