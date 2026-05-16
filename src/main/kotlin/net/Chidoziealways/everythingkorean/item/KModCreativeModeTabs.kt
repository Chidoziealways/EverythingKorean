package net.Chidoziealways.everythingkorean.item

import net.Chidoziealways.everythingkorean.Everythingkorean.logInfo
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister

object KModCreativeModeTabs {
    val CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KOREAN_MOD_ID)

    val KOREAN_ITEMS = CREATIVE_MODE_TABS.register(
        "korean_items")
    { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.SERPENTINE) }
            .title(Component.translatable("creativetab.everythingkorean.korean_items"))
            .displayItems { _, output ->
                output.accept(KModItems.SERPENTINE)
            }.build()
    }

    val KOREAN_BLOCKS = CREATIVE_MODE_TABS.register(
        "korean_blocks"
    ) { ->
        CreativeModeTab.builder().icon { ItemStack(KModBlocks.SERPENTINE_BLOCK) }
            .withTabsBefore(KOREAN_ITEMS.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_blocks"))
            .displayItems { _, output ->
                output.accept(KModBlocks.SERPENTINE_BLOCK)
                output.accept(KModBlocks.SERPENTINE_ORE)
                output.accept(KModBlocks.SERPENTINE_DEEPSLATE_ORE)
                output.accept(KModBlocks.KOREAN_FLAG)
            }.build()
    }

    val KOREAN_FOODS = CREATIVE_MODE_TABS.register(
        "korean_foods"
    ) { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.RAMYEON) }
            .withTabsBefore(KOREAN_BLOCKS.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_foods"))
            .displayItems { _, output ->
                output.accept(KModItems.RAMYEON)
                output.accept(KModItems.KIMCHI)
                output.accept(KModItems.TTEOKBOKKI)
            }.build()
    }

    val KOREAN_WEAPONS = CREATIVE_MODE_TABS.register(
        "korean_weapons"
    ) { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.SERPENTINE_SWORD) }
            .withTabsBefore(KOREAN_FOODS.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_weapons"))
            .displayItems { _, output ->
                output.accept(KModItems.SERPENTINE_SWORD)
                output.accept(KModItems.JANG_BI_CHANG)
            }.build()
    }

    val KOREAN_TOOLS = CREATIVE_MODE_TABS.register(
        "korean_tools"
    ) { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.SERPENTINE_PICKAXE) }
            .withTabsBefore(KOREAN_WEAPONS.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_tools"))
            .displayItems { _, output ->
                output.accept(KModItems.SERPENTINE_PICKAXE)
                output.accept(KModItems.SERPENTINE_AXE)
                output.accept(KModItems.SERPENTINE_SHOVEL)
                output.accept(KModItems.SERPENTINE_HOE)
            }.build()
    }

    val KOREAN_ARMOR = CREATIVE_MODE_TABS.register(
        "korean_armor"
    ) { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.SERPENTINE_HELMET) }
            .withTabsBefore(KOREAN_TOOLS.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_armor"))
            .displayItems { _, output ->
                output.accept(KModItems.SERPENTINE_HELMET)
                output.accept(KModItems.SERPENTINE_CHESTPLATE)
                output.accept(KModItems.SERPENTINE_LEGGINGS)
                output.accept(KModItems.SERPENTINE_BOOTS)
                output.accept(KModItems.SERPENTINE_HORSE_ARMOR)
                output.accept(KModItems.SERPENTINE_WOLF_ARMOR)
            }.build()
    }

    val KOREAN_ARMOR_TRIMS = CREATIVE_MODE_TABS.register("korean_armor_trims") { ->
        CreativeModeTab.builder().icon { ItemStack(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE) }
            .withTabsBefore(KOREAN_ARMOR.id)
            .title(Component.translatable("creativetab.everythingkorean.korean_armor_trims"))
            .displayItems { _, output ->
                output.accept(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE)
            }.build()
    }

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(eventBus)
        logInfo("REGISTERING EVERY SINGLE CREATIVEMODETAB IN MODCREATIVEMODETABS")
    }
}