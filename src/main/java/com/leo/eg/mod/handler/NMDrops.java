package com.leo.eg.mod.handler;

import java.util.Random;

import com.leo.eg.mod.init.NewModBlocks;
import com.leo.eg.mod.init.NewModItems;
import com.leo.eg.mod.items.NEWMODAXE;
import com.leo.eg.mod.items.NEWMODPICK;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NMDrops {
	@SubscribeEvent
	public void addBlockDrop(HarvestDropsEvent event) {
		if (event.state.getBlock() == NewModBlocks.nadaniumOre) {
			Random rand = new Random();
			ItemStack holding = event.harvester.inventory.getStackInSlot(event.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODPICK) {
				event.drops.clear();
				event.drops.add(new ItemStack(NewModItems.nadaniumIngot, rand.nextInt(9)));
			}
		}
	}

	@SubscribeEvent
	public void addBlockDrop1(HarvestDropsEvent e) {
		if (e.state.getBlock() == Blocks.log) {
			Random rand = new Random();
			ItemStack holding = e.harvester.inventory.getStackInSlot(e.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODAXE) {
				
				e.drops.add(new ItemStack(NewModItems.good_item, rand.nextInt(5)));
			}
		}
	}

	@SubscribeEvent
	public void addBlockDrop2(HarvestDropsEvent e) {
		if (e.state.getBlock() == NewModBlocks.anadiumOre) {
			Random rand = new Random();
			ItemStack holding = e.harvester.inventory.getStackInSlot(e.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODPICK) {
				e.drops.clear();
				e.drops.add(new ItemStack(NewModItems.anadiumIngot, rand.nextInt(5)));
			}
		}
	}

	@SubscribeEvent
	public void addBlockDrop3(HarvestDropsEvent e) {
		if (e.state.getBlock() == NewModBlocks.filanidelOre) {
			Random rand = new Random();
			ItemStack holding = e.harvester.inventory.getStackInSlot(e.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODPICK) {
				e.drops.clear();
				e.drops.add(new ItemStack(NewModItems.filanidelIngot, rand.nextInt(5)));
				
			}
		}
	}

	@SubscribeEvent
	public void addBlockDrop4(HarvestDropsEvent e) {
		if (e.state.getBlock() == NewModBlocks.piladOre) {
			Random rand = new Random();
			ItemStack holding = e.harvester.inventory.getStackInSlot(e.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODPICK) {
				e.drops.clear();
				e.drops.add(new ItemStack(NewModItems.piladIngot, rand.nextInt(5)));
				
			}
		}
	}

	@SubscribeEvent
	public void addBlockDrop5(HarvestDropsEvent e) {
		if (e.state.getBlock() == NewModBlocks.portoOre) {
			Random rand = new Random();
			ItemStack holding = e.harvester.inventory.getStackInSlot(e.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof NEWMODPICK) {
				e.drops.clear();
				e.drops.add(new ItemStack(NewModItems.portoIngot, rand.nextInt(5)));
				
			}
		}
	}

}
