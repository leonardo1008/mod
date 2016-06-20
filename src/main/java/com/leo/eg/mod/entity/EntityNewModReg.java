package com.leo.eg.mod.entity;

import com.leo.eg.mod.NewMod;
import com.leo.eg.mod.biome.BiomeRegistry;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityNewModReg {
	
	public static void RegisterEntity(){
		EntityNMreg();
	}
	public static void EntityNMreg(){
		createEntity(NMTireLessMob.class, "Tireless_Mob", 0x228BE0, 0xD01AD6);
		createAnotherEntity(NMSmallvillagerCow.class, "Small_Villagers_Cow", 0x85E827, 0xF2AD35);
	}
	
	public static void createEntity(Class Entityclass, String name, int solidColor, int spotColor){
		
		
		EntityRegistry.registerModEntity(Entityclass, name, 3000, NewMod.instance, 32, 3, true);
		EntityRegistry.addSpawn(Entityclass, 10, 4, 15, EnumCreatureType.CREATURE, BiomeGenBase.jungle);
		
		
		
		EntityRegistry.registerEgg(NMTireLessMob.class, 0x228BE0, 0xD01AD6);
		
	}
	
	public static void createAnotherEntity(Class entity, String name, int color1, int color2){
		EntityRegistry.registerModEntity(entity, name, 3001, NewMod.instance, 12, 5, true);
		EntityRegistry.addSpawn(entity, 10, 4, 15, EnumCreatureType.MONSTER, BiomeGenBase.extremeHills);
		EntityRegistry.registerEgg(NMSmallvillagerCow.class, 0x85E827, 0xF2AD35);
	}
	
	
	
	
}
