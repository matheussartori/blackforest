package com.sartori.blackforest.items;

import com.sartori.blackforest.BlackForest;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(BlackForest.TAB));
    }
}
