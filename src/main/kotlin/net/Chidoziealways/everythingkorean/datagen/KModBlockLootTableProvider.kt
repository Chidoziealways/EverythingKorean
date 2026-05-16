package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import java.util.Objects

class KModBlockLootTableProvider(registries: HolderLookup.Provider): BlockLootSubProvider(
    mutableSetOf<Item>(),
    FeatureFlags.REGISTRY.allFlags(),
    registries
) {
    override fun generate() {
        dropSelf(KModBlocks.SERPENTINE_BLOCK)
        dropSelf(KModBlocks.KOREAN_FLAG)
        this.add(
            KModBlocks.SERPENTINE_ORE
        ) { block ->
            createOreDrop(
                KModBlocks.SERPENTINE_ORE,
                KModItems.SERPENTINE
            )
        }

        this.add(
            KModBlocks.SERPENTINE_DEEPSLATE_ORE
        ) { block ->
            createMultipleOreDrops(
                KModBlocks.SERPENTINE_DEEPSLATE_ORE,
                KModItems.SERPENTINE,
                9f,
                20f
            )
        }
    }

    override fun getKnownBlocks(): Iterable<Block> {
        // Only return your mod's blocks
        return BuiltInRegistries.BLOCK.stream()
            .filter { block: Block -> Objects.equals(BuiltInRegistries.BLOCK.getKey(block).namespace, KOREAN_MOD_ID) }
            .toList()
    }

    protected fun createMultipleOreDrops(
        pBlock: Block,
        item: Item,
        minDrops: Float,
        maxDrops: Float
    ): LootTable.Builder {
        val registrylookup: HolderLookup.RegistryLookup<Enchantment?> =
            this.registries.lookupOrThrow<Enchantment?>(Registries.ENCHANTMENT)
        return this.createSilkTouchDispatchTable(
            pBlock, this.applyExplosionDecay(
                pBlock, LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(net.minecraft.world.item.enchantment.Enchantments.FORTUNE)))
            )
        )
    }
}