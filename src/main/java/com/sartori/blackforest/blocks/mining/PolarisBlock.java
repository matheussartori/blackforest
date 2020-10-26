package com.sartori.blackforest.blocks.mining;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PolarisBlock extends Block {
    public PolarisBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.5f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2) // 0 = wood, 1 = stone / gold, 2 = iron, 3 = diamond
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
