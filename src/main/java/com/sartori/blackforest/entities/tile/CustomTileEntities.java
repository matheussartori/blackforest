package com.sartori.blackforest.entities.tile;

import com.sartori.blackforest.BlackForest;
import com.sartori.blackforest.entities.tile.machines.TileEntityCleanseTable;
import com.sartori.blackforest.registry.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, BlackForest.MOD_ID);

    public static final RegistryObject<TileEntityType<?>> CLEANSE_TABLE_TILE_ENTITY = TILE_ENTITIES.register("cleanse_table_tile_entity", () -> TileEntityType.Builder.create(TileEntityCleanseTable::new, RegistryHandler.CLEANSE_TABLE.get()).build(null));
}
