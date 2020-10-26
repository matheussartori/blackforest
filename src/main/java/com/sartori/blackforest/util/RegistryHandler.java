package com.sartori.blackforest.util;

import com.sartori.blackforest.BlackForest;
import com.sartori.blackforest.blocks.BlockItemBase;
import com.sartori.blackforest.blocks.mining.PolarisBlock;
import com.sartori.blackforest.items.ItemBase;
import com.sartori.blackforest.tools.BlackForestItemTier;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlackForest.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BlackForest.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // ITEMS
    public static final RegistryObject<Item> POLARIS = ITEMS.register("polaris", ItemBase::new);

    // BLOCKS
    public static final RegistryObject<Block> POLARIS_BLOCK = BLOCKS.register("polaris_block", PolarisBlock::new);

    // BLOCK ITEMS
    public static final RegistryObject<Item> POLARIS_BLOCK_ITEM = ITEMS.register("polaris_block", () -> new BlockItemBase(POLARIS_BLOCK.get()));

    // TOOLS
    public static final RegistryObject<SwordItem> POLARIS_SWORD = ITEMS.register("polaris_sword", () ->
            new SwordItem(BlackForestItemTier.POLARIS, 2, -2.4F, new Item.Properties().group(BlackForest.TAB)));

    public static final RegistryObject<PickaxeItem> POLARIS_PICKAXE = ITEMS.register("polaris_pickaxe", () ->
            new PickaxeItem(BlackForestItemTier.POLARIS, 0, -2.8F, new Item.Properties().group(BlackForest.TAB)));

    public static final RegistryObject<ShovelItem> POLARIS_SHOVEL = ITEMS.register("polaris_shovel", () ->
            new ShovelItem(BlackForestItemTier.POLARIS, 0.5F, -3.0F, new Item.Properties().group(BlackForest.TAB)));

    public static final RegistryObject<AxeItem> POLARIS_AXE = ITEMS.register("polaris_axe", () ->
            new AxeItem(BlackForestItemTier.POLARIS, 4F, -3.0F, new Item.Properties().group(BlackForest.TAB)));

    public static final RegistryObject<HoeItem> POLARIS_HOE = ITEMS.register("polaris_hoe", () ->
            new HoeItem(BlackForestItemTier.POLARIS, -4, 0.0F, new Item.Properties().group(BlackForest.TAB)));
}
