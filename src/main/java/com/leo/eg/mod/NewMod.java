package com.leo.eg.mod;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.leo.eg.mod.biome.BiomeRegistry;
import com.leo.eg.mod.biome.MiningWorldType;
import com.leo.eg.mod.blocks.SpecialRender;
import com.leo.eg.mod.dimension.MiningDimension;
import com.leo.eg.mod.enchantments.EnchantmentJumpBoost;
import com.leo.eg.mod.entity.EntityNewModReg;
import com.leo.eg.mod.entity.NMTLMob;
import com.leo.eg.mod.entity.NMTireLessMob;
import com.leo.eg.mod.entity.RenderMob;
import com.leo.eg.mod.event.OnCraft1_1;
import com.leo.eg.mod.event.OnCraft1_2;
import com.leo.eg.mod.event.OnCraftEvent;
import com.leo.eg.mod.event.OnMineEvent;
import com.leo.eg.mod.event.SkcEvent;
import com.leo.eg.mod.handler.NMDrops;
import com.leo.eg.mod.handler.NewModFuelHandler;
import com.leo.eg.mod.init.NewModBlocks;
import com.leo.eg.mod.init.NewModItems;
import com.leo.eg.mod.init.TeleportTileEntities;
import com.leo.eg.mod.items.potion.ModPotion;
import com.leo.eg.mod.proxy.CommonProxy;
import com.leo.eg.mod.world.WorldGen;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class NewMod {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_ID)
    public static NewMod instance;
	
	public static final NewModTab tabNewMod = new NewModTab("tabNewMod");
	
	public static Achievement achievementcraftPowder = 
		      new Achievement("achievement.achievementcraftPowder", "achievementcraftPowder", 
		      2, 2, Items.redstone, (NewMod.achievementlogin));
	public static Achievement achievementcraftblock = 
		      new Achievement("achievement.achievementcraftblock", "achievementcraftblock", 
		      5, 4, Blocks.crafting_table, (NewMod.achievementcraftPowder)).setSpecial();
	public static Achievement achievementlogin = 
		      new Achievement("achievement.achievementlogin", "achievementlogin", 
		      0, 0, Blocks.acacia_door, (Achievement)null).setSpecial();
	public static Achievement achievementcraftop = 
		      new Achievement("achievement.achievementcraftop", "achievementcraftop", 
		      3, -2, Items.nether_star, (NewMod.achievementcraftblock)).setSpecial();
	public static Achievement achievementcraftapple = 
		      new Achievement("achievement.achievementcraftapple", "achievementcraftapple", 
		      5, 0, Items.apple, (Achievement)null).setSpecial();
	public static Enchantment jumpBoost = new EnchantmentJumpBoost(100,new ResourceLocation("jumpBoost"), 5);
	public static Potion newModPotion;

	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NewModItems.init();
		EntityNewModReg.EntityNMreg();
		
		NewModItems.register();
		NewModBlocks.init();
		NewModBlocks.register(); 
		TeleportTileEntities.register();
		BiomeRegistry.MainRegistry();
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
		f.setAccessible(true);
		try {
		if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
		Field modfield = Field.class.getDeclaredField("modifiers");
		modfield.setAccessible(true);
		modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

		potionTypes = (Potion[])f.get(null);
		final Potion[] newPotionTypes = new Potion[256];
		System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
		f.set(null, newPotionTypes);
		}
		}
		catch (Exception e) {
		System.err.println("Severe error, please report this to the mod author:");
		System.err.println(e);
		}
		}


		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		MinecraftForge.EVENT_BUS.register(new OnMineEvent());
		MinecraftForge.EVENT_BUS.register(new OnCraftEvent());
		MinecraftForge.EVENT_BUS.register(new OnCraft1_1());
		MinecraftForge.EVENT_BUS.register(new OnCraft1_2());
		ItemStack pilladboots = new ItemStack(NewModItems.piladboots);
		pilladboots.addEnchantment(jumpBoost, 3);
		ItemStack multi1 = new ItemStack(NewModItems.multiTool1);
		multi1.addEnchantment(Enchantment.efficiency, 7);
		multi1.addEnchantment(Enchantment.baneOfArthropods, 7);
		multi1.addEnchantment(Enchantment.fireAspect, 7);
		multi1.addEnchantment(Enchantment.looting, 7);
		multi1.addEnchantment(Enchantment.sharpness, 7);
		multi1.addEnchantment(Enchantment.fortune, 7);
		ItemStack multi2 = new ItemStack(NewModItems.multiTool2);
		multi1.addEnchantment(Enchantment.efficiency, 7);
		multi2.addEnchantment(Enchantment.knockback, 5);
		multi1.addEnchantment(Enchantment.looting, 7);
		multi1.addEnchantment(Enchantment.sharpness, 7);
		multi1.addEnchantment(Enchantment.fortune, 7);
		pilladboots.addEnchantment(Enchantment.featherFalling, 10);
		ItemStack pilladshirt = new ItemStack(NewModItems.piladshirt);
		pilladshirt.addEnchantment(Enchantment.protection, 5);
		pilladshirt.addEnchantment(Enchantment.thorns, 5);
		ItemStack pilladhat = new ItemStack(NewModItems.piladhelmet);
		pilladhat.addEnchantment(Enchantment.protection, 5);
		pilladhat.addEnchantment(Enchantment.aquaAffinity, 5);
		ItemStack pilladpants = new ItemStack(NewModItems.piladpants);
		pilladpants.addEnchantment(Enchantment.protection, 5);
		newModPotion = new ModPotion(100, new ResourceLocation(Reference.MOD_ID + ":newModPotion"), true, 0x42425E).setIconIndex(0, 0).setPotionName("newmodpotion.customPotion");
		GameRegistry.addRecipe(new ItemStack(NewModItems.toolnewmodsword), new Object[]{" 1 "," 1 "," 2 ",'1',NewModItems.nadaniumIngot,'2',Items.stick});
		GameRegistry.addRecipe(new ItemStack(NewModItems.toolnewmodspade), new Object[]{" 1 "," 2 "," 2 ",'1',NewModItems.nadaniumIngot,'2',Items.stick});
		GameRegistry.addRecipe(new ItemStack(NewModItems.toolnewmodpick), new Object[]{"111"," 2 "," 2 ",'1',NewModItems.nadaniumIngot,'2',Items.stick});
		GameRegistry.addRecipe(new ItemStack(NewModItems.toolnewmodhoe), new Object[]{"11 "," 2 "," 2 ",'1',NewModItems.nadaniumIngot,'2',Items.stick});
		GameRegistry.addRecipe(new ItemStack(NewModItems.toolnewmodaxe), new Object[]{"11 ","12 "," 2 ",'1',NewModItems.nadaniumIngot,'2',Items.stick});
		GameRegistry.addSmelting(NewModBlocks.good_block, new ItemStack(NewModItems.good_item, 2), 5.0F);
		GameRegistry.addRecipe((multi1), new Object[]{"NNN", "DND", "NNN", 'N', NewModItems.nadaniumIngot, 'D', NewModItems.diamondIngot});
		GameRegistry.addRecipe((multi2), new Object[]{"DNN", "DDN", "NNN", 'N', NewModItems.nadaniumIngot, 'D', NewModItems.diamondIngot});
		GameRegistry.addRecipe(new ItemStack(NewModItems.good_food_item), new Object[]{"A",'A', NewModItems.good_item});
		GameRegistry.addSmelting(new ItemStack(NewModItems.good_food_item), new ItemStack(NewModItems.best_food_item), 5.0F);
		GameRegistry.addRecipe(new ItemStack(NewModItems.good_item), new Object[]{"OOO","OBO","ONO", 'O', Blocks.obsidian, 'B', Blocks.beacon,'N', Items.nether_star});
		GameRegistry.addRecipe(new ItemStack(NewModBlocks.nadaniumOre), new Object[]{"JJJ", "JHJ", "JHJ", 'J', NewModItems.good_item, 'H',  NewModItems.best_food_item});
		GameRegistry.addSmelting(new ItemStack(NewModBlocks.nadaniumOre), new ItemStack(NewModItems.nadaniumIngot, 5), 10.0F);
		GameRegistry.addRecipe(new ItemStack(NewModItems.newmodboots), new Object[]{"J J", "J J", 'J',NewModItems.nadaniumIngot});
		GameRegistry.addRecipe(new ItemStack(NewModItems.newmodpants), new Object[]{"JJJ", "J J", "J J", 'J',NewModItems.nadaniumIngot});
		GameRegistry.addRecipe(new ItemStack(NewModItems.newmodchestplate), new Object[]{"J J", "JJJ","JJJ", 'J',NewModItems.nadaniumIngot});
		GameRegistry.addRecipe(new ItemStack(NewModItems.newmodhelmet), new Object[]{"JJJ", "J J", 'J',NewModItems.nadaniumIngot});
		GameRegistry.addRecipe((pilladboots), new Object[]{"J J", "J J", 'J',NewModItems.piladIngot});
		GameRegistry.addRecipe((pilladpants), new Object[]{"JJJ", "J J", "J J", 'J',NewModItems.piladIngot});
		GameRegistry.addRecipe((pilladshirt), new Object[]{"J J", "JJJ","JJJ", 'J',NewModItems.piladIngot});
		GameRegistry.addRecipe((pilladhat), new Object[]{"JJJ", "J J", 'J',NewModItems.piladIngot});
		GameRegistry.registerFuelHandler(new NewModFuelHandler());
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new NMDrops());
		MinecraftForge.EVENT_BUS.register(new SkcEvent());
		achievementcraftPowder.registerStat();
		achievementcraftblock.registerStat();
		achievementcraftop.registerStat();
		achievementcraftapple.registerStat();
		achievementlogin.registerStat();
		MiningDimension.init();
		GameRegistry.addShapedRecipe(new ItemStack(NewModItems.coordItem), new Object[]{"313","121","313", '1', Items.ender_eye, '2', Items.ender_pearl, '3', Items.ghast_tear});
		GameRegistry.addRecipe(new ItemStack(NewModBlocks.tpblock), new Object[]{"414","141","414",'4', NewModBlocks.quantumMomentum,'1', NewModItems.portoIngot});
		GameRegistry.addRecipe(new ItemStack(NewModBlocks.fuelPlants), new Object[]{" D ", "DSD", " D ",  'D', Blocks.dirt, 'S', NewModItems.good_food_item});
		GameRegistry.addRecipe(new ItemStack(NewModItems.diamondsmallNugget, 9), new Object[]{"F", 'F', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(NewModItems.diamondIngot), new Object[]{"VVV", "VVV", 'V', NewModItems.diamondsmallNugget});
		GameRegistry.addRecipe(new ItemStack(NewModItems.diamondApple), new Object[]{"MMM", "MKM", "MMM", 'M', NewModItems.diamondIngot, 'K', Items.apple});
		GameRegistry.addSmelting(new ItemStack(NewModBlocks.anadiumOre), new ItemStack(NewModItems.anadiumIngot, 5), 15.0F);
		GameRegistry.addSmelting(new ItemStack(NewModBlocks.piladOre), new ItemStack(NewModItems.piladIngot, 5), 15.0F);
		GameRegistry.addSmelting(new ItemStack(NewModBlocks.portoOre), new ItemStack(NewModItems.portoIngot, 5), 15.0F);
		GameRegistry.addSmelting(new ItemStack(NewModBlocks.filanidelOre), new ItemStack(NewModItems.filanidelIngot, 5), 15.0F);
		AchievementPage.registerAchievementPage(
			      new AchievementPage("New Mod Achievements", 
			            new Achievement[] {achievementlogin, achievementcraftPowder, achievementcraftblock, achievementcraftop, achievementcraftapple }));

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		WorldType MINING = new MiningWorldType(5, "mining");
	}
}
