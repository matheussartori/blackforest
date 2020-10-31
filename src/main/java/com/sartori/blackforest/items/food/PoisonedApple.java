package com.sartori.blackforest.items.food;

import com.sartori.blackforest.BlackForest;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonedApple extends Item {
    public PoisonedApple() {
        super(new Item.Properties()
                .group(BlackForest.TAB)
                .food(new Food.Builder()
                        .hunger(7)
                        .saturation(1.5F)
                        .effect(() -> new EffectInstance(Effects.POISON, 250, 1), 0.99F)
                        .effect(() -> new EffectInstance(Effects.NAUSEA, 300, 0), 0.55F)
                        .setAlwaysEdible()
                        .build())
        );
    }
}
