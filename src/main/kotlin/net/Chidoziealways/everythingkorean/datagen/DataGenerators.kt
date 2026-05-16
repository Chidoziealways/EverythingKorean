package net.Chidoziealways.everythingkorean.datagen

//import net.Chidoziealways.everythingjapanese.datagen.JModDatapackEntries
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.Util
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistryAccess
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.data.registries.RegistryPatchGenerator
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.data.event.GatherDataEvent
import thedarkcolour.kotlinforforge.common.KotlinMod
import java.util.concurrent.CompletableFuture

@KotlinMod.KotlinEventBusSubscriber(modId = KOREAN_MOD_ID)
object DataGenerators {
    @SubscribeEvent
    fun gatherClientData(event: GatherDataEvent.Client) {
        val generator = event.generator
        val packOutput = generator.packOutput

        val lookupFuture = RegistryPatchGenerator.createLookup(
            event.lookupProvider,
            KModDatapackEntries.BUILDER//JModDatapackEntries.BUILDER
        ).thenCompose { patched1 ->
            RegistryPatchGenerator.createLookup(
                CompletableFuture.completedFuture(patched1.full()),
                KModDatapackEntries.BUILDER
            )
        }

        val lookupProvider: CompletableFuture<HolderLookup.Provider> =
            lookupFuture.thenApply { it.full() }


        event.createProvider(::KModBlockTagProvider)
        event.createProvider(::KModModelProvider)
        event.createProvider(::KModDatapackEntries)
        event.createProvider(::KModItemTagProvider)
        event.createProvider(::KModDataMapProvider)
        generator.addProvider(
            true,
            KModRecipeProvider.Runner(packOutput, lookupProvider)
        )
        event.createProvider(::KSimplifiedChineseLanguageProvider)
        event.createProvider(::KTraditionalChineseLanguageProvider)
        event.createProvider(::KoreanLanguageProvider)
        event.createProvider(::JapaneseLanguageProvider)
        event.createProvider(::EnglishLanguageProvider)

        generator.addProvider(
            true,
            LootTableProvider(
                packOutput,
                mutableSetOf(),
                listOf(
                    LootTableProvider.SubProviderEntry({ registries ->
                        KModBlockLootTableProvider(registries)
                    }, LootContextParamSets.BLOCK)
                ),
                lookupProvider
            )
        )
    }
}

//fun combinedLookup(): HolderLookup.Provider {
//    val registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)
//    val builder = RegistrySetBuilder()
//
//    // Add both mods’ registries
//    JModDatapackEntries.BUILDER.entries.forEach { stub ->
//        builder.add(stub.key(), stub.bootstrap())
//    }
//    KModDatapackEntries.BUILDER.entries.forEach { (key, bootstrap) -> builder.add(key, bootstrap) }
//
//    return builder.build(registryAccess)
//}