package com.leo.eg.mod.init;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.Reference;
import com.leo.eg.mod.items.ItemCoordnateCache;
import com.leo.eg.mod.items.ItemModArm;
import com.leo.eg.mod.items.ItemModArmor;
import com.leo.eg.mod.items.MultiToolPickAxe;
import com.leo.eg.mod.items.MultiToolPickSword;
import com.leo.eg.mod.items.NEWMODAXE;
import com.leo.eg.mod.items.NEWMODHOE;
import com.leo.eg.mod.items.NEWMODPICK;
import com.leo.eg.mod.items.NEWMODSPADE;
import com.leo.eg.mod.items.NEWMODSWORD;
import com.leo.eg.mod.items.Straw;
import com.leo.eg.mod.items.food.NMFood;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NewModItems {
	// tools
	public static ToolMaterial TOOLNEWMOD = EnumHelper.addToolMaterial("TOOLNEWMOD", 10, 5000000, 150.0F, 150.0F, 30);
	public static Item toolnewmodpick;
	public static Item toolnewmodaxe;
	public static Item toolnewmodspade;
	public static Item toolnewmodsword;
	public static Item toolnewmodhoe;
	
	public static ToolMaterial multi = EnumHelper.addToolMaterial("multi", 50, 100000000, 500.0F, 300.0F, 50);
	public static Item multiTool1;
	public static Item multiTool2;

	// Items
	public static Item good_item;
	public static Item good_food_item;
	public static Item best_food_item;
	public static Item nadaniumIngot;
	public static Item diamondApple; 
	public static Item diamondsmallNugget;
	public static Item diamondIngot;
	public static Item filanidelIngot;
	public static Item anadiumIngot;
	public static Item piladIngot;
	public static Item portoIngot;
	public static Item coordItem;
	public static Item straw;
	public static Potion newModPotion;

	// Armor
	public static ArmorMaterial sth = EnumHelper.addArmorMaterial("sth", Reference.MOD_ID + ":" + "armor", 5000000,
			new int[] {10, 20, 10, 15}, 30);
	public static Item newmodboots;
	public static Item newmodpants;
	public static Item newmodchestplate;
	public static Item newmodhelmet;
	
	
	public static ArmorMaterial pilad = EnumHelper.addArmorMaterial("pilad", Reference.MOD_ID + ":" + "arm", 10000, new int[] {5, 10, 5, 7}, 10);
	public static Item piladhelmet;
	public static Item piladshirt;
	public static Item piladpants;
	public static Item piladboots;
	
	//fuel
	public static Item carboncoal;
	private static Item packetitem;

	public static void init() {
		good_item = new Item().setUnlocalizedName("good_item").setCreativeTab(NewMod.tabNewMod);
		good_food_item = new ItemFood(10, 0.5F, false).setUnlocalizedName("good_food_item")
				.setCreativeTab(NewMod.tabNewMod);
		best_food_item = new ItemFood(20, 1.0F, true).setUnlocalizedName("best_food_item")
				.setCreativeTab(NewMod.tabNewMod);
		GameRegistry.registerItem(multiTool1 = new MultiToolPickSword("multiTool1", multi), "multiTool1");
		GameRegistry.registerItem(multiTool2 = new MultiToolPickAxe("multiTool2", multi), "multiTool2");
		GameRegistry.registerItem(toolnewmodpick = new NEWMODPICK("toolnewmodpick", TOOLNEWMOD), "toolnewmodpick");
		GameRegistry.registerItem(toolnewmodaxe = new NEWMODAXE("toolnewmodaxe", TOOLNEWMOD), "toolnewmodaxe");
		GameRegistry.registerItem(toolnewmodhoe = new NEWMODHOE("toolnewmodhoe", TOOLNEWMOD), "toolnewmodhoe");
		GameRegistry.registerItem(toolnewmodspade = new NEWMODSPADE("toolnewmodspade", TOOLNEWMOD), "toolnewmodspade");
		GameRegistry.registerItem(toolnewmodsword = new NEWMODSWORD("toolnewmodsword", TOOLNEWMOD), "toolnewmodsword");
		GameRegistry.registerItem(newmodboots = new ItemModArmor("newmodboots", sth, 1, 3), "newmodboots");
		GameRegistry.registerItem(newmodpants = new ItemModArmor("newmodpants", sth, 2, 2), "newmodpants");
		GameRegistry.registerItem(newmodchestplate = new ItemModArmor("newmodchestplate", sth, 1, 1), "newmodchestplate");
		GameRegistry.registerItem(newmodhelmet = new ItemModArmor("newmodhelmet", sth, 1, 0), "newmodhelmet");
		nadaniumIngot = new Item().setUnlocalizedName("nadaniumIngot").setCreativeTab(NewMod.tabNewMod);
		carboncoal = new Item().setUnlocalizedName("carboncoal").setCreativeTab(NewMod.tabNewMod);
		GameRegistry.registerItem(diamondApple = new NMFood("diamondApple", 8, 20, false),  "diamondApple");
		diamondsmallNugget = new Item().setUnlocalizedName("diamondsmallNugget").setCreativeTab(NewMod.tabNewMod);
		diamondIngot = new Item().setUnlocalizedName("diamondIngot").setCreativeTab(NewMod.tabNewMod);
		filanidelIngot = new Item().setUnlocalizedName("filanidelIngot").setCreativeTab(NewMod.tabNewMod);
		anadiumIngot = new Item().setUnlocalizedName("anadiumIngot").setCreativeTab(NewMod.tabNewMod);
		piladIngot = new Item().setUnlocalizedName("piladIngot").setCreativeTab(NewMod.tabNewMod);
		portoIngot = new Item().setUnlocalizedName("portoIngot").setCreativeTab(NewMod.tabNewMod);
		GameRegistry.registerItem(piladhelmet = new ItemModArm("piladhelmet", pilad, 1,0 ), "piladhelmet");
		GameRegistry.registerItem(piladshirt = new ItemModArm("piladshirt", pilad, 1,1 ), "piladshirt");
		GameRegistry.registerItem(piladpants = new ItemModArm("piladpants", pilad, 2,2 ), "piladpants");
		GameRegistry.registerItem(piladboots = new ItemModArm("piladboots", pilad, 1,3 ), "piladboots");
		GameRegistry.registerItem(coordItem = new ItemCoordnateCache("coordItem"), "coordItem");
		GameRegistry.registerItem(straw = new Straw("straw"), "straw");
		
		
		
	}

	public static void register() {
		
		GameRegistry.registerItem(good_item, good_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(best_food_item, best_food_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(nadaniumIngot, nadaniumIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(carboncoal, carboncoal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(good_food_item, good_food_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamondsmallNugget, diamondsmallNugget.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamondIngot, diamondIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(filanidelIngot, filanidelIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(anadiumIngot, anadiumIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(piladIngot, piladIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(portoIngot, portoIngot.getUnlocalizedName().substring(5));
		
	}

	public static void registerRenders() {
		registerRender(good_item);
		registerRender(good_food_item);
		registerRender(best_food_item);
		registerRender(toolnewmodpick);
		registerRender(toolnewmodhoe);
		registerRender(toolnewmodaxe);
		registerRender(toolnewmodspade);
		registerRender(toolnewmodsword);
		registerRender(newmodhelmet);
		registerRender(newmodchestplate);
		registerRender(newmodpants);
		registerRender(newmodboots);
		registerRender(nadaniumIngot);
		registerRender(carboncoal);
		registerRender(diamondApple);
		registerRender(diamondsmallNugget);
		registerRender(diamondIngot);
		registerRender(filanidelIngot);
		registerRender(anadiumIngot);
		registerRender(piladIngot);
		registerRender(portoIngot);
		registerRender(piladboots);
		registerRender(piladshirt);
		registerRender(piladpants);
		registerRender(piladhelmet);
		registerRender(coordItem);
		registerRender(straw);
		registerRender(multiTool1);
		registerRender(multiTool2);
		
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
