package a.extratools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class RedGemShovel extends ItemSpade {

	public RedGemShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		if(itemID == mod_test.redgemshovel.itemID) {
			this.itemIcon = iconRegister.registerIcon("extratools:redgemshovel");
		}
	}
}
