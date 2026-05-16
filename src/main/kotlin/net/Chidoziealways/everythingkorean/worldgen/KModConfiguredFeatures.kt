package net.Chidoziealways.everythingkorean.worldgen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest

object KModConfiguredFeatures {
    val SERPENTINE_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("serpentine_ore")

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
        val stoneReplaceables: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
        val deepslateReplaceables: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

        val serpentineOres: MutableList<OreConfiguration.TargetBlockState> =
            mutableListOf(
                OreConfiguration.target(stoneReplaceables, KModBlocks.SERPENTINE_ORE.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, KModBlocks.SERPENTINE_DEEPSLATE_ORE.defaultBlockState())
            )

        register(
            context,
            SERPENTINE_ORE_KEY,
            Feature.ORE,
            OreConfiguration(serpentineOres, 10)
        )
    }

    fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(
            net.minecraft.core.registries.Registries.CONFIGURED_FEATURE,
            net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
        )
    }

    private fun <FC : FeatureConfiguration?, F : Feature<FC?>?> register(
        context: BootstrapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>, feature: F?, configuration: FC?
    ) {
        context.register(key, ConfiguredFeature<FC?, F?>(feature, configuration))
    }
}