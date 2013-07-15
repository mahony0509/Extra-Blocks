/*
 * ExtraTools is copyright 2013 to Mahony0509
 * 
 * 1: You may not edit or distribute the code.
 * 2: You may not take ownership of the code
 * 
 */

package a.extratools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.EnumHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

@Mod(modid="mod_test", name="ExtraTools", version="0.1 R1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class mod_test 
		{
		/*
		 * Start of Modding stuff
		 */
		/*
		 * Item Declares
		 */
		public static Item powdereddiamond;
		public static Item redgems;
		public static Item redgempickaxe;
		public static Item redgemaxe;
		public static Item redgemshovel;
		public static Item redgemsword;
		public static Item redgemhoe;
		
		/*
		 * Configuration Ints
		 */
		public static int ItemIDStart = 7000;
		public static int pdiamondid;
		public static int redgemsid;
		public static int redgempickid;
		public static int redgemaxeid;
		public static int redgemhoeid;
		public static int redgemshovelid;
		public static int redgemswordid;
		
		
		// The instance of your mod that Forge uses.
        @Instance("mod_test")
        public static mod_test instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="a.extratools.ClientProxy", serverSide="a.extratools.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	/*
        	 * Configuration File
        	 */
        	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        	config.load();
        	pdiamondid = config.get(Configuration.CATEGORY_ITEM, "PowderedDiamond", ItemIDStart).getInt();
        	redgemsid = config.get(Configuration.CATEGORY_ITEM, "RedGems", ItemIDStart +1).getInt();
        	redgempickid = config.get(Configuration.CATEGORY_ITEM, "RedGemPickAxe", ItemIDStart +2).getInt();
        	redgemaxeid = config.get(Configuration.CATEGORY_ITEM, "RedGemAxe", ItemIDStart +3).getInt();
        	redgemshovelid = config.get(Configuration.CATEGORY_ITEM, "RedGemShovel", ItemIDStart +4).getInt();
        	redgemhoeid = config.get(Configuration.CATEGORY_ITEM, "RedGemHoe", ItemIDStart +5).getInt();
        	redgemswordid = config.get(Configuration.CATEGORY_ITEM, "RedGemSword", ItemIDStart +6).getInt();
        	
        	
        	config.save();
       
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
        
        		
        		/*
        		 * Powdered Diamond
        		 */
        		powdereddiamond = new PowderedDiamond(7000).setUnlocalizedName("pdiamond");
        		LanguageRegistry.addName(powdereddiamond, "Powdered Diamond");
        		
        		/*
        		 * Reinforced Diamond
        		 */
        		redgems = new RedGem(7001).setUnlocalizedName("redgem");
        		LanguageRegistry.addName(redgems, "Red Gem");
        		
        		
        		/*
        		 * Red Gem Tools
        		 */
        		EnumToolMaterial redgem = EnumHelper.addToolMaterial("Red Gem", 3, 3000, 9.0F, 4, 15);
        		redgempickaxe = new RedGemPickAxe(7002, redgem).setUnlocalizedName("rgempick");
        		redgemaxe = new RedGemAxe(7003, redgem).setUnlocalizedName("rgempick");
        		redgemshovel = new RedGemShovel(7004, redgem).setUnlocalizedName("rgempick");
        		redgemhoe = new RedGemHoe(7005, redgem).setUnlocalizedName("rgempick");
        		redgemsword = new RedGemSword(7006, redgem).setUnlocalizedName("rgempick");
        		
        		
        		/*
        		 * Crafting and smelting recipes
        		 */
        		ItemStack redstonestack = new ItemStack(Item.redstone, 1);
        		ItemStack diamondstack = new ItemStack(Item.diamond, 1);
        		GameRegistry.addShapelessRecipe(new ItemStack(mod_test.powdereddiamond, 1),
        		                redstonestack, diamondstack);	
        		
        		ItemStack blazestack = new ItemStack(Item.blazePowder, 1);
        		ItemStack pdiamond = new ItemStack(powdereddiamond, 1);
        		GameRegistry.addRecipe(new ItemStack(redgems, 1), "xyx", "yyy", "xyx", 'x', blazestack , 'y', pdiamond);
        		
        		/*
        		 * Red Gem Tools crafting
        		 */
        		ItemStack sticks = new ItemStack(Item.stick, 1);
        		ItemStack redgemone = new ItemStack(redgems, 1);
        		GameRegistry.addRecipe(new ItemStack(redgemaxe, 1), "xx ", "xy ", " y ", 'y', sticks, 'x', redgemone);
        		GameRegistry.addRecipe(new ItemStack(redgempickaxe, 1), "xxx", " y ", " y ", 'y', sticks, 'x', redgemone);
        		GameRegistry.addRecipe(new ItemStack(redgemshovel, 1), " x ", " y ", " y ", 'y', sticks, 'x', redgemone);
        		GameRegistry.addRecipe(new ItemStack(redgemsword, 1), " x ", " x ", " y ", 'y', sticks, 'x', redgemone);
        		GameRegistry.addRecipe(new ItemStack(redgemhoe, 1), " xx", " y ", " y ", 'y', sticks, 'x', redgemone);
        		
        		
        		LanguageRegistry.addName(redgemhoe, "Red Gem Hoe");
        		LanguageRegistry.addName(redgempickaxe, "Red Gem Pickaxe");
        		LanguageRegistry.addName(redgemaxe, "Red Gem Axe");
        		LanguageRegistry.addName(redgemshovel, "Red Gem Shovel");
        		LanguageRegistry.addName(redgemsword, "Red Gem Sword");
        		
        		}
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}