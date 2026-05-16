package net.Chidoziealways.everythingkorean.item

import net.minecraft.world.food.FoodProperties

object KModFoodProperties {
    val RAMYEON: FoodProperties = FoodProperties.Builder().nutrition(3).saturationModifier(2f).build()

    val KIMCHI = FoodProperties.Builder()
        .nutrition(6)      // hunger points restored
        .saturationModifier(0.6f)
        .build()

    val TTEOKBOKKI = FoodProperties.Builder()
        .nutrition(8)
        .saturationModifier(0.8f)
        .build()
}