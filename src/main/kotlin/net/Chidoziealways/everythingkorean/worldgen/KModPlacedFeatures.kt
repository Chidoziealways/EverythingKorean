package net.Chidoziealways.everythingkorean.worldgen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import java.util.List

object KModPlacedFeatures {
    val SERPENTINE_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("serpentine_ore_placed")

    fun bootstrap(context: BootstrapContext<PlacedFeature>) {
        val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

        register(
            context, SERPENTINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(KModConfiguredFeatures.SERPENTINE_ORE_KEY),
            KModOrePlacement.commonOrePlacement(6,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))
            )
        )
    }

    fun registerKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create<PlacedFeature>(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
        )
    }

    private fun register(
        context: BootstrapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: MutableList<PlacementModifier?>
    ) {
        context.register(key, PlacedFeature(configuration, List.copyOf<PlacementModifier>(modifiers)))
    }
}