package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class KTraditionalChineseLanguageProvider(output: PackOutput): LanguageProvider(output, KOREAN_MOD_ID, "zh_tw") {
    override fun addTranslations() {
        // BLOCKS
        add(KModBlocks.SERPENTINE_BLOCK, "蛇紋石方塊")
        add(KModBlocks.SERPENTINE_ORE, "蛇紋石礦石")
        add(KModBlocks.SERPENTINE_DEEPSLATE_ORE, "深層蛇紋石礦石")
        add(KModBlocks.KOREAN_FLAG, "韓國國旗")

        // CREATIVE MODE TABS
        add("creativetab.everythingkorean.korean_items", "韓國物品")
        add("creativetab.everythingkorean.korean_blocks", "韓國方塊")
        add("creativetab.everythingkorean.korean_foods", "韓國食物")
        add("creativetab.everythingkorean.korean_weapons", "韓國武器")
        add("creativetab.everythingkorean.korean_tools", "韓國工具")
        add("creativetab.everythingkorean.korean_armor", "韓國盔甲")
        add("creativetab.everythingkorean.korean_armor_trims", "韓國盔甲飾邊")

        // ITEMS
        add(KModItems.SERPENTINE, "蛇紋石")
        add(KModItems.SERPENTINE_SWORD, "蛇紋石劍")
        add(KModItems.JANG_BI_CHANG, "長柄槍")
        add(KModItems.SERPENTINE_PICKAXE, "蛇紋石鎬")
        add(KModItems.SERPENTINE_AXE, "蛇纹石斧")
        add(KModItems.SERPENTINE_SHOVEL, "蛇纹石鏟")
        add(KModItems.SERPENTINE_HOE, "蛇纹石鋤")
        add(KModItems.SERPENTINE_HELMET, "蛇纹石頭盔");
        add(KModItems.SERPENTINE_CHESTPLATE, "蛇纹石胸甲");
        add(KModItems.SERPENTINE_LEGGINGS, "蛇纹石護腿");
        add(KModItems.SERPENTINE_BOOTS, "蛇纹石靴子");
        add(KModItems.SERPENTINE_HORSE_ARMOR, "蛇紋石馬鎧")
        add(KModItems.SERPENTINE_WOLF_ARMOR, "蛇紋石狼鎧")
        add(KModItems.RAMYEON, "泡麵")
        add(KModItems.KIMCHI, "泡菜")
        add(KModItems.TTEOKBOKKI, "炒年糕")
        add(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, "漢字裝甲飾邊模版")
    }
}