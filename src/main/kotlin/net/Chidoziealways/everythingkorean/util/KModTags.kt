package net.Chidoziealways.everythingkorean.util

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class KModTags {
    object Blocks {
        val INCORRECT_FOR_SERPENTINE_TOOL = createBlockTag("incorrect_for_serpentine_tool")

        private fun createBlockTag(name: String): TagKey<Block> {
            return TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
            )
        }
    }

    object Items {
        val SERPENTINE_TOOL_MATERIALS = createItemTag("serpentine_tool_materials")

        val REPAIRS_SERPENTINE_ARMOR = createItemTag("repairs_serpentine_armor")

        private fun createItemTag(name: String): TagKey<Item> {
            return TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
            )
        }
    }
}