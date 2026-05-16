package net.Chidoziealways.everythingkorean.block

import net.Chidoziealways.everythingkorean.Everythingkorean.logInfo
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES

object KModBlocks {
    val BLOCKS = DeferredRegister.createBlocks(KOREAN_MOD_ID)

    val SERPENTINE_BLOCK by registerBlock("serpentine_block") {
        Block(
            BlockBehaviour.Properties.of()
                .setId(
                    ResourceKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_block")
                    )
                )
                .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
        )
    }

    val SERPENTINE_ORE by registerBlock("serpentine_ore") {
        DropExperienceBlock(
            UniformInt.of(5, 10), BlockBehaviour.Properties.of().setId(
                ResourceKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_ore")
                )
            )
                .strength(4f).requiresCorrectToolForDrops()
        )
    }

    val SERPENTINE_DEEPSLATE_ORE by registerBlock("serpentine_deepslate_ore") {
        DropExperienceBlock(
            UniformInt.of(5, 10), BlockBehaviour.Properties.of().setId(
                ResourceKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_deepslate_ore")
                )
            )
        )
    }

    val KOREAN_FLAG by registerBlock("korean_flag") {
        Block(BlockBehaviour.Properties.of()
            .setId(
                ResourceKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "korean_flag")
                )
            )
            .noOcclusion()
        )
    }

    private fun <T : Block?> registerBlock(name: String, block: Function0<T>): DeferredBlock<T> {
        val toReturn = BLOCKS.register(name, block)
        logInfo("Attempting to register block: $name")
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun <T : Block?> registerBlockItem(name: String, block: DeferredBlock<T>) {
        logInfo("Registering BlockItem for: $name")
        KModItems.ITEMS.register(name) { ->
            BlockItem(
                block.get(), Item.Properties()
                    .useBlockDescriptionPrefix()
                    .setId(
                        ResourceKey.create(
                            Registries.ITEM,
                            ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, name)
                        )
                    )
            )
        }
    }

    fun register(eventBus: IEventBus) {
        BLOCKS.register(eventBus)
    }
}
