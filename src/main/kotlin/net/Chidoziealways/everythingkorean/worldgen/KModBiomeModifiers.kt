package net.Chidoziealways.everythingkorean.worldgen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.levelgen.GenerationStep
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.NeoForgeRegistries

object KModBiomeModifiers {
    val ADD_SERPENTINE_ORE: ResourceKey<BiomeModifier> = registerKey("add_serpentine_ore")

    fun bootstrap(context: BootstrapContext<BiomeModifier>) {
        val placedFeature = context.lookup(Registries.PLACED_FEATURE)
        val biomes = context.lookup(Registries.BIOME)

        context.register(
            ADD_SERPENTINE_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                    biomes.getOrThrow(Biomes.WINDSWEPT_HILLS),
                    biomes.getOrThrow(Biomes.WINDSWEPT_GRAVELLY_HILLS),
                    biomes.getOrThrow(Biomes.JAGGED_PEAKS),
                    biomes.getOrThrow(Biomes.STONY_PEAKS),
                    biomes.getOrThrow(Biomes.MEADOW),
                    biomes.getOrThrow(Biomes.SNOWY_SLOPES)
                ),
                HolderSet.direct(placedFeature.getOrThrow(KModPlacedFeatures.SERPENTINE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
    }

    private fun registerKey(name: String): ResourceKey<BiomeModifier> {
        return ResourceKey.create<BiomeModifier>(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
        )
    }
}