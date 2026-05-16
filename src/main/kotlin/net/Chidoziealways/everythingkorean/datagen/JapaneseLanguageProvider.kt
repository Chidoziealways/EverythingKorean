package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class JapaneseLanguageProvider(output: PackOutput) : LanguageProvider(output, KOREAN_MOD_ID, "ja_jp") {
    override fun addTranslations() {
        // BLOCKS
        add(KModBlocks.SERPENTINE_BLOCK, "蛇紋石のブロック")
        add(KModBlocks.SERPENTINE_ORE, "蛇紋石鉱石")
        add(KModBlocks.SERPENTINE_DEEPSLATE_ORE, "真相蛇紋石鉱石")
        add(KModBlocks.KOREAN_FLAG, "韓国の旗")

        // CREATIVE MODE TABS
        add("creativetab.everythingkorean.korean_items", "韓国のアイテム")
        add("creativetab.everythingkorean.korean_blocks", "韓国のブロック")
        add("creativetab.everythingkorean.korean_foods", "韓国の食べ物")
        add("creativetab.everythingkorean.korean_weapons", "韓国の武器")
        add("creativetab.everythingkorean.korean_tools", "韓国の道具")
        add("creativetab.everythingkorean.korean_armor", "韓国の防具")
        add("creativetab.everythingkorean.korean_armor_trims", "韓国の防具トリム")

        // ITEMS
        add(KModItems.SERPENTINE, "蛇紋石")
        add(KModItems.SERPENTINE_SWORD, "蛇紋石の刀")
        add(KModItems.JANG_BI_CHANG, "長柄槍")
        add(KModItems.SERPENTINE_PICKAXE, "蛇紋石のつるはし")
        add(KModItems.SERPENTINE_AXE, "蛇紋石の斧")
        add(KModItems.SERPENTINE_SHOVEL, "蛇紋石のシャベル")
        add(KModItems.SERPENTINE_HOE, "蛇紋石のクワ")
        add(KModItems.SERPENTINE_HELMET, "蛇紋石のヘルメット");
        add(KModItems.SERPENTINE_CHESTPLATE, "蛇紋石のチェストプレート");
        add(KModItems.SERPENTINE_LEGGINGS, "蛇紋石のレギンス");
        add(KModItems.SERPENTINE_BOOTS, "蛇紋石のブーツ");
        add(KModItems.SERPENTINE_HORSE_ARMOR, "蛇紋石の馬鎧")
        add(KModItems.SERPENTINE_WOLF_ARMOR, "蛇紋石の狼鎧")
        add(KModItems.RAMYEON, "ラミョン")
        add(KModItems.KIMCHI, "キムチ")
        add(KModItems.TTEOKBOKKI, "トッポッキ")
        add(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, "漢字の鍛冶テンプレート")
    }
}