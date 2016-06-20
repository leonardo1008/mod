package com.leo.eg.mod.init;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.Reference;
import com.leo.eg.mod.blocks.BlockTest;
import com.leo.eg.mod.blocks.CobbleKiller;
import com.leo.eg.mod.blocks.Coke;
import com.leo.eg.mod.blocks.GiantCoke;
import com.leo.eg.mod.blocks.HugeCoke;
import com.leo.eg.mod.blocks.ItemCobbleKiller;
import com.leo.eg.mod.blocks.ModBlockOre;
import com.leo.eg.mod.blocks.MultiOre;
import com.leo.eg.mod.blocks.TpBlock;
import com.leo.eg.mod.blocks.crops.NMO;
import com.leo.eg.mod.dimension.MiningPortal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NewModBlocks {

	public static Block good_block;
	public static Block nadaniumOre;
	public static Block fuelPlants;
	public static Block piladOre;
	public static Block filanidelOre;
	public static Block portoOre;
	public static Block anadiumOre;
	public static Block tpblock;
	public static Block quantumMomentum;
	public static Block coke;
	public static Block bigcoke;
	public static Block giantcoke;
	public static MiningPortal mining_portal;
	public static Block multiOre;
	public static Block color_cobble;
	

	public static void init() {
		GameRegistry.registerBlock(color_cobble = new CobbleKiller("color_cobble", Material.rock), ItemCobbleKiller.class, "color_cobble");
		good_block = new BlockTest(Material.anvil).setUnlocalizedName("good_block").setCreativeTab(NewMod.tabNewMod);
		GameRegistry.registerBlock( nadaniumOre = new ModBlockOre("nadaniumOre", Material.rock), "nadaniumOre");
		GameRegistry.registerBlock(fuelPlants = new NMO("fuelPlants"), "fuelPlants");
		GameRegistry.registerBlock(multiOre = new MultiOre("multiOre", Material.rock), "multiOre");
		GameRegistry.registerBlock(piladOre = new ModBlockOre("piladOre", Material.rock), "piladOre");
		GameRegistry.registerBlock(filanidelOre = new ModBlockOre("filanidelOre", Material.rock), "filanidelOre");
		GameRegistry.registerBlock(portoOre = new ModBlockOre("portoOre", Material.rock), "portoOre");
		GameRegistry.registerBlock(anadiumOre = new ModBlockOre("anadiumOre", Material.rock), "anadiumOre");
		GameRegistry.registerBlock(tpblock = new TpBlock("tpblock", Material.iron), "tpblock");	
		quantumMomentum = new BlockTest(Material.anvil).setUnlocalizedName("quantumMomentum").setCreativeTab(NewMod.tabNewMod);
		GameRegistry.registerBlock(coke = new Coke("coke", Material.carpet), "coke");
		GameRegistry.registerBlock(bigcoke = new HugeCoke("bigcoke", Material.carpet), "bigcoke");
		GameRegistry.registerBlock(giantcoke = new GiantCoke("giantcoke", Material.carpet), "giantcoke");
		
		}

	public static void register() {
		GameRegistry.registerBlock(good_block, good_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(quantumMomentum, quantumMomentum.getUnlocalizedName().substring(5));
	
	}
	public static void registerRenders(){
		registerRender(good_block);
		registerRender(nadaniumOre);
		registerRender(fuelPlants);
		registerRender(portoOre);
		registerRender(anadiumOre);
		registerRender(filanidelOre);
		registerRender(piladOre);
		registerRender(tpblock);
		registerRender(quantumMomentum);
		registerRender(coke);
		registerRender(bigcoke);
		registerRender(giantcoke);
		registerRender(multiOre);
		
		
		
		
	}
	
	public static void RegRender(){
		reg(NewModBlocks.color_cobble, 0, "color_cobble.white");
		reg(NewModBlocks.color_cobble, 1, "color_cobble.dark");
	}
	
	public static void reg(Block block, int meta, String name) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
	}
public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}


}