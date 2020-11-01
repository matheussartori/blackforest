package com.sartori.blackforest.registry;

import com.sartori.blackforest.BlackForest;
import com.sartori.blackforest.blocks.BlockItemBase;
import com.sartori.blackforest.blocks.functional.CleanseTable;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlackForest.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BlackForest.MOD_ID);

    public static final RegistryObject<Block> CLEANSE_TABLE = BLOCKS.register("cleanse_table", CleanseTable::new);
    public static final RegistryObject<Item> CLEANSE_TABLE_ITEM = ITEMS.register("cleanse_table", () -> new BlockItemBase(CLEANSE_TABLE.get()));

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
