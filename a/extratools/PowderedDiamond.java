package a.extratools;

import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class PowderedDiamond extends Item {
		public PowderedDiamond(int par1) {
			super(par1);
			setCreativeTab(CreativeTabs.tabMaterials);
		}
		
		@Override
		public void registerIcons(IconRegister iconRegister) {
			if(itemID == mod_test.powdereddiamond.itemID) {
				this.itemIcon = iconRegister.registerIcon("extratools:pdiamond");
			}
		}
}
