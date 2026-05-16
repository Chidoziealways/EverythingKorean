package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingcore.util.SharedRegistries
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.quests.KoreanQuests
import net.Chidoziealways.everythingkorean.worldgen.KModBiomeModifiers
import net.Chidoziealways.everythingkorean.worldgen.KModConfiguredFeatures
import net.Chidoziealways.everythingkorean.worldgen.KModPlacedFeatures
import net.minecraft.Util
import net.minecraft.core.Holder
import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderLookup
import net.minecraft.core.HolderSet
import net.minecraft.core.RegistryAccess
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class KModDatapackEntries(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
    DatapackBuiltinEntriesProvider(
        output,
        registries,
        BUILDER,
        mutableSetOf(KOREAN_MOD_ID)
    ) {
    companion object {
        val BUILDER: RegistrySetBuilder = RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, KModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, KModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, KModBiomeModifiers::bootstrap)
            .add(SharedRegistries.QUEST, KoreanQuests::bootstrap)

        private fun validateThatAllBiomeFeaturesHaveBiomeFilter(pProvider: HolderLookup.Provider) {
            validateThatAllBiomeFeaturesHaveBiomeFilter(
                pProvider.lookupOrThrow<PlacedFeature>(Registries.PLACED_FEATURE), pProvider.lookupOrThrow<Biome>(
                    Registries.BIOME
                )
            )
        }

        fun validateThatAllBiomeFeaturesHaveBiomeFilter(
            pFeatures: HolderGetter<PlacedFeature>,
            pBiomes: HolderLookup<Biome>
        ) {
            pBiomes.listElements().forEach { p_256326_: Holder.Reference<Biome> ->
                val resourcelocation = p_256326_.key().location()
                val list = p_256326_.value().generationSettings.features()
                list.stream().flatMap { obj: HolderSet<PlacedFeature> -> obj.stream() }
                    .forEach { p_256657_: Holder<PlacedFeature> ->
                        p_256657_.unwrap().ifLeft(
                            Consumer { p_325923_: ResourceKey<PlacedFeature> ->
                                val reference = pFeatures.getOrThrow(p_325923_)
                                if (!validatePlacedFeature(reference.value())) {
                                    Util.logAndPauseIfInIde("Placed feature " + p_325923_.location() + " in biome " + resourcelocation + " is missing BiomeFilter.biome()")
                                }
                            }).ifRight(Consumer { p_325920_: PlacedFeature ->
                            if (!validatePlacedFeature(p_325920_)) {
                                Util.logAndPauseIfInIde("Placed inline feature in biome $p_256326_ is missing BiomeFilter.biome()")
                            }
                        })
                    }
            }
        }

        private fun validatePlacedFeature(pFeature: PlacedFeature): Boolean {
            return pFeature.placement().contains(BiomeFilter.biome())
        }

        fun createLookup(): HolderLookup.Provider {
            val `registryaccess$frozen` = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)
            val `holderlookup$provider`: HolderLookup.Provider = BUILDER.build(`registryaccess$frozen`)
            validateThatAllBiomeFeaturesHaveBiomeFilter(`holderlookup$provider`)
            return `holderlookup$provider`
        }
    }
}