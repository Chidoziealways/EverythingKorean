package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.IntrinsicHolderTagsProvider
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture
import java.util.function.Function

class KModBlockTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>
) : IntrinsicHolderTagsProvider<Block>(
    output,
    Registries.BLOCK,
    lookupProvider,
    Function { block -> block.builtInRegistryHolder().key() },
    KOREAN_MOD_ID
) {
    override fun addTags(p0: HolderLookup.Provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(KModBlocks.SERPENTINE_DEEPSLATE_ORE)
            .add(KModBlocks.SERPENTINE_ORE)
            .add(KModBlocks.SERPENTINE_BLOCK)

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(KModBlocks.SERPENTINE_ORE)
            .add(KModBlocks.SERPENTINE_DEEPSLATE_ORE)
            .add(KModBlocks.SERPENTINE_BLOCK)
    }
}