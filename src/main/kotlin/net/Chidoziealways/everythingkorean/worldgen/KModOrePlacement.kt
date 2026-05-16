package net.Chidoziealways.everythingkorean.worldgen

import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter

object KModOrePlacement {
    fun orePlacement(
    pCountPlacement: PlacementModifier,
    pHeightRange: PlacementModifier
): MutableList<PlacementModifier?> {
    return listOf<PlacementModifier?>(
        pCountPlacement,
        InSquarePlacement.spread(),
        pHeightRange,
        BiomeFilter.biome()
    ) as MutableList<PlacementModifier?>
}

    fun commonOrePlacement(pCount: Int, pHeightRange: PlacementModifier): MutableList<PlacementModifier?> {
        return orePlacement(CountPlacement.of(pCount), pHeightRange)
    }

    fun rareOrePlacement(pChance: Int, pHeightRange: PlacementModifier): MutableList<PlacementModifier?> {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange)
    }
}