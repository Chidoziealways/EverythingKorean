package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class EnglishLanguageProvider(output: PackOutput): LanguageProvider(output, KOREAN_MOD_ID, "en_us") {
    override fun addTranslations() {
        // BLOCKS
        add(KModBlocks.SERPENTINE_BLOCK, "Block of Serpentine")
        add(KModBlocks.SERPENTINE_ORE, "Serpentine Ore")
        add(KModBlocks.SERPENTINE_DEEPSLATE_ORE, "Serpentine Deepslate Ore")
        add(KModBlocks.KOREAN_FLAG, "Korean Flag")

        // CREATIVE MODE TABS
        add("creativetab.everythingkorean.korean_items", "Korean Items")
        add("creativetab.everythingkorean.korean_blocks", "Korean Blocks")
        add("creativetab.everythingkorean.korean_foods", "Korean Foods")
        add("creativetab.everythingkorean.korean_weapons", "Korean Weapons")
        add("creativetab.everythingkorean.korean_tools", "Korean Tools")
        add("creativetab.everythingkorean.korean_armor", "Korean Armor")
        add("creativetab.everythingkorean.korean_armor_trims", "Korean Armor Trims")

        // ITEMS
        add(KModItems.SERPENTINE, "Serpentine")
        add(KModItems.SERPENTINE_SWORD, "Serpentine Sword")
        add(KModItems.JANG_BI_CHANG, "Long Spear")
        add(KModItems.SERPENTINE_PICKAXE, "Serpentine Pickaxe")
        add(KModItems.SERPENTINE_AXE, "Serpentine Axe")
        add(KModItems.SERPENTINE_SHOVEL, "Serpentine Shovel")
        add(KModItems.SERPENTINE_HOE, "Serpentine Hoe")
        add(KModItems.SERPENTINE_HELMET, "Serpentine Helmet")
        add(KModItems.SERPENTINE_CHESTPLATE, "Serpentine Chestplate")
        add(KModItems.SERPENTINE_LEGGINGS, "Serpentine Leggings")
        add(KModItems.SERPENTINE_BOOTS, "Serpentine Boots")
        add(KModItems.SERPENTINE_HORSE_ARMOR, "Serpentine Horse Armor")
        add(KModItems.SERPENTINE_WOLF_ARMOR, "Serpentine Wolf Armor")
        add(KModItems.RAMYEON, "Ramyeon")
        add(KModItems.KIMCHI, "Kimchi")
        add(KModItems.TTEOKBOKKI, "Tteokbokki")
        add(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, "Hanja Smithing Template")
    }
}