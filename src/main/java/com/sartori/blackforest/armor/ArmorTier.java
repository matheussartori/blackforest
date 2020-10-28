package com.sartori.blackforest.armor;

import com.sartori.blackforest.BlackForest;
import com.sartori.blackforest.registry.bundles.PolarisBundle;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ArmorTier implements IArmorMaterial {

    POLARIS(BlackForest.MOD_ID + ":polaris", 37, new int[] { 3, 6, 8, 3 }, 13,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.5F, () -> { return Ingredient.fromItems(PolarisBundle.POLARIS.get()); });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 14, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReduction;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ArmorTier(String name, int maxDamageFactor, int[] damageReduction, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReduction[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }
}
