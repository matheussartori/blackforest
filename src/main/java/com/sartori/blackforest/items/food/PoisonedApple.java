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
                        .hunger(6)
                        .saturation(1.5F)
                        .effect(() -> new EffectInstance(Effects.POISON, 200, 0), 0.7F)
                        .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 0), 0.35F)
                        .setAlwaysEdible()
                        .build())
        );
    }
}
