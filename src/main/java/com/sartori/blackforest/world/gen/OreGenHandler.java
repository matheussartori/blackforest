package com.sartori.blackforest.world.gen;

import com.sartori.blackforest.BlackForest;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.world.biome.Biome.Category.*;

@Mod.EventBusSubscriber(modid = BlackForest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGenHandler {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            switch (biome.getCategory()) {
                // NETHER GENERATION
                case NETHER:
                    break;
                // THE END GENERATION
                case THEEND:
                    break;
                // WORLD GENERATION
                default:
            }

        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {

    }
}
