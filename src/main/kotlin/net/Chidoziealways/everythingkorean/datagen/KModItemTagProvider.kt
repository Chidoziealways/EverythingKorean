package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.Chidoziealways.everythingkorean.util.KModTags
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.IntrinsicHolderTagsProvider
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture
import java.util.function.Function

class KModItemTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>
) : IntrinsicHolderTagsProvider<Item>(
    output,
    Registries.ITEM,
    lookupProvider,
    Function { block -> block.builtInRegistryHolder().key() },
    KOREAN_MOD_ID
) {
    override fun addTags(p0: HolderLookup.Provider) {
        tag(KModTags.Items.SERPENTINE_TOOL_MATERIALS)
            .add(KModItems.SERPENTINE)

        tag(KModTags.Items.REPAIRS_SERPENTINE_ARMOR)
            .add(KModItems.SERPENTINE)

        tag(ItemTags.TRIMMABLE_ARMOR)
            .add(KModItems.SERPENTINE_HELMET)
            .add(KModItems.SERPENTINE_CHESTPLATE)
            .add(KModItems.SERPENTINE_LEGGINGS)
            .add(KModItems.SERPENTINE_BOOTS)
    }
}