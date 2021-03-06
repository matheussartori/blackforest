package com.sartori.blackforest.blocks.machines;

import com.sartori.blackforest.entities.tile.machines.TileEntityCleanseTable;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class CleanseTable extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 14, 1, 1, 15, 15),
            Block.makeCuboidShape(14, 0, 1, 15, 2, 2),
            Block.makeCuboidShape(1, 0, 1, 2, 2, 2),
            Block.makeCuboidShape(1, 0, 14, 2, 2, 15),
            Block.makeCuboidShape(14, 0, 14, 15, 2, 15),
            Block.makeCuboidShape(0, 14, 0, 1, 16, 1),
            Block.makeCuboidShape(0, 14, 15, 1, 16, 16),
            Block.makeCuboidShape(15, 14, 15, 16, 16, 16),
            Block.makeCuboidShape(15, 14, 0, 16, 16, 1),
            Block.makeCuboidShape(15, 14, 1, 16, 15, 15),
            Block.makeCuboidShape(1, 14, 0, 15, 15, 1),
            Block.makeCuboidShape(1, 14, 15, 15, 15, 16),
            Block.makeCuboidShape(0, 2, 0, 16, 14, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2, 14, 1, 16, 15, 2),
            Block.makeCuboidShape(15, 0, 15, 16, 2, 16),
            Block.makeCuboidShape(15, 0, 2, 16, 2, 3),
            Block.makeCuboidShape(2, 0, 2, 3, 2, 3),
            Block.makeCuboidShape(2, 0, 15, 3, 2, 16),
            Block.makeCuboidShape(16, 14, 1, 17, 16, 2),
            Block.makeCuboidShape(1, 14, 1, 2, 16, 2),
            Block.makeCuboidShape(1, 14, 16, 2, 16, 17),
            Block.makeCuboidShape(16, 14, 16, 17, 16, 17),
            Block.makeCuboidShape(2, 14, 16, 16, 15, 17),
            Block.makeCuboidShape(16, 14, 2, 17, 15, 16),
            Block.makeCuboidShape(1, 14, 2, 2, 15, 16),
            Block.makeCuboidShape(1, 2, 1, 17, 14, 17)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(15, 14, 3, 16, 15, 17),
            Block.makeCuboidShape(1, 0, 16, 2, 2, 17),
            Block.makeCuboidShape(14, 0, 16, 15, 2, 17),
            Block.makeCuboidShape(14, 0, 3, 15, 2, 4),
            Block.makeCuboidShape(1, 0, 3, 2, 2, 4),
            Block.makeCuboidShape(15, 14, 17, 16, 16, 18),
            Block.makeCuboidShape(15, 14, 2, 16, 16, 3),
            Block.makeCuboidShape(0, 14, 2, 1, 16, 3),
            Block.makeCuboidShape(0, 14, 17, 1, 16, 18),
            Block.makeCuboidShape(0, 14, 3, 1, 15, 17),
            Block.makeCuboidShape(1, 14, 17, 15, 15, 18),
            Block.makeCuboidShape(1, 14, 2, 15, 15, 3),
            Block.makeCuboidShape(0, 2, 2, 16, 14, 18)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 14, 16, 14, 15, 17),
            Block.makeCuboidShape(0, 0, 2, 1, 2, 3),
            Block.makeCuboidShape(0, 0, 15, 1, 2, 16),
            Block.makeCuboidShape(13, 0, 15, 14, 2, 16),
            Block.makeCuboidShape(13, 0, 2, 14, 2, 3),
            Block.makeCuboidShape(-1, 14, 16, 0, 16, 17),
            Block.makeCuboidShape(14, 14, 16, 15, 16, 17),
            Block.makeCuboidShape(14, 14, 1, 15, 16, 2),
            Block.makeCuboidShape(-1, 14, 1, 0, 16, 2),
            Block.makeCuboidShape(0, 14, 1, 14, 15, 2),
            Block.makeCuboidShape(-1, 14, 2, 0, 15, 16),
            Block.makeCuboidShape(14, 14, 2, 15, 15, 16),
            Block.makeCuboidShape(-1, 2, 1, 15, 14, 17)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CleanseTable() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE));
    }

    /**
     * Called throughout the code as a replacement for block instanceof BlockContainer
     * Moving this to the Block base class allows for mods that wish to extend vanilla
     * blocks, and also want to have a tile entity on that block, may.
     * <p>
     * Return true from this function to specify this block has a tile entity.
     *
     * @param state State of the current block
     * @return True if block has a tile entity, false otherwise
     */
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityCleanseTable();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (worldIn.getTileEntity(pos) instanceof TileEntityCleanseTable) {
            TileEntityCleanseTable ce = (TileEntityCleanseTable) worldIn.getTileEntity(pos);
            player.sendStatusMessage(new StringTextComponent("Counter : " + ce.getCounter()), true);
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
