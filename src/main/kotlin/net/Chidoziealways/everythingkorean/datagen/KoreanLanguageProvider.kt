package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class KoreanLanguageProvider(output: PackOutput) : LanguageProvider(output, KOREAN_MOD_ID, "ko_kr") {
    override fun addTranslations() {
        // BLOCKS
        add(KModBlocks.SERPENTINE_BLOCK, "蛇紋石의 블록")
        add(KModBlocks.SERPENTINE_ORE, "蛇紋石의 광석")
        add(KModBlocks.SERPENTINE_DEEPSLATE_ORE, "심층 蛇紋石 광석")
        add(KModBlocks.KOREAN_FLAG, "韓國의 旗")

        // CREATIVE MODE TABS
        add("creativetab.everythingkorean.korean_items", "韓國의 아이템")
        add("creativetab.everythingkorean.korean_blocks", "韓國의 블록")
        add("creativetab.everythingkorean.korean_foods", "韓國의 飮食")
        add("creativetab.everythingkorean.korean_weapons", "韓國의 武器")
        add("creativetab.everythingkorean.korean_tools", "韓國의 道具")
        add("creativetab.everythingkorean.korean_armor", "韓國의 防具")
        add("creativetab.everythingkorean.korean_armor_trims", "韓國의 防具 장식")

        // ITEMS
        add(KModItems.SERPENTINE, "蛇紋石")
        add(KModItems.SERPENTINE_SWORD, "蛇紋石의 劍")
        add(KModItems.JANG_BI_CHANG, "長柄槍")
        add(KModItems.SERPENTINE_PICKAXE, "蛇紋石의 곡괭이")
        add(KModItems.SERPENTINE_AXE, "蛇紋石의 斧")
        add(KModItems.SERPENTINE_SHOVEL, "蛇紋石의 鏟")
        add(KModItems.SERPENTINE_HOE, "蛇紋石의 괭이")
        add(KModItems.SERPENTINE_HELMET, "蛇紋石의 頭具")
        add(KModItems.SERPENTINE_CHESTPLATE, "蛇紋石의 胸甲")
        add(KModItems.SERPENTINE_LEGGINGS, "蛇紋石의 다리갑옷")
        add(KModItems.SERPENTINE_BOOTS, "蛇紋石의 부츠")
        add(KModItems.SERPENTINE_HORSE_ARMOR, "蛇紋石의 馬鎧")
        add(KModItems.SERPENTINE_WOLF_ARMOR, "蛇紋石의 狼鎧")
        add(KModItems.RAMYEON, "라면")
        add(KModItems.KIMCHI, "김치")
        add(KModItems.TTEOKBOKKI, "떡볶이")
        add(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, "漢字의 鍛冶 템플릿")
    }
}