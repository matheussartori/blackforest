package com.sartori.blackforest.entities.tile.machines;

import com.sartori.blackforest.entities.tile.CustomTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCleanseTable extends TileEntity implements ITickableTileEntity {

    private int counter;

    public TileEntityCleanseTable() {
        super(CustomTileEntities.CLEANSE_TABLE_TILE_ENTITY.get());
    }

    @Override
    public void func_230337_a_(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.func_230337_a_(p_230337_1_, p_230337_2_);

        this.setCounter(p_230337_2_.getInt("counter"));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("counter", this.getCounter());

        return compound;
    }

    @Override
    public void tick() {
        setCounter(getCounter() + 1);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
