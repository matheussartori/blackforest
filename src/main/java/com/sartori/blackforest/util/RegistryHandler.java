package com.sartori.blackforest.util;

import com.sartori.blackforest.BlackForest;
import com.sartori.blackforest.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlackForest.MOD_ID);

    public static final RegistryObject<Item> POLARIS = ITEMS.register("polaris", ItemBase::new);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
