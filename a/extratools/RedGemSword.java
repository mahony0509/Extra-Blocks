package a.extratools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class RedGemSword extends ItemSword {

	public RedGemSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		if(itemID == mod_test.redgemsword.itemID) {
			this.itemIcon = iconRegister.registerIcon("extratools:redgemsword");
		}
	}
}
