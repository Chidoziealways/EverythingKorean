package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class KSimplifiedChineseLanguageProvider(output: PackOutput): LanguageProvider(output, KOREAN_MOD_ID, "zh_cn") {
    override fun addTranslations() {
        // BLOCKS
        add(KModBlocks.SERPENTINE_BLOCK, "蛇纹石方块")
        add(KModBlocks.SERPENTINE_ORE, "蛇纹石矿石")
        add(KModBlocks.SERPENTINE_DEEPSLATE_ORE, "深层蛇纹石矿石")
        add(KModBlocks.KOREAN_FLAG, "韩国国旗")

        // CREATIVE MODE TABS
        add("creativetab.everythingkorean.korean_items", "韩国物品")
        add("creativetab.everythingkorean.korean_blocks", "韩国方块")
        add("creativetab.everythingkorean.korean_foods", "韩国食物")
        add("creativetab.everythingkorean.korean_weapons", "韩国武器")
        add("creativetab.everythingkorean.korean_tools", "韩国工具")
        add("creativetab.everythingkorean.korean_armor", "韩国盔甲")
        add("creativetab.everythingkorean.korean_armor_trims", "韩国盔甲饰边")

        // ITEMS
        add(KModItems.SERPENTINE, "蛇纹石")
        add(KModItems.SERPENTINE_SWORD, "蛇纹石剑")
        add(KModItems.JANG_BI_CHANG, "长柄枪")
        add(KModItems.SERPENTINE_PICKAXE, "蛇纹石镐")
        add(KModItems.SERPENTINE_AXE, "蛇纹石斧")
        add(KModItems.SERPENTINE_SHOVEL, "蛇纹石锹")
        add(KModItems.SERPENTINE_HOE, "蛇纹石锄")
        add(KModItems.SERPENTINE_HELMET, "蛇纹石头盔");
        add(KModItems.SERPENTINE_CHESTPLATE, "蛇纹石胸甲");
        add(KModItems.SERPENTINE_LEGGINGS, "蛇纹石护腿");
        add(KModItems.SERPENTINE_BOOTS, "蛇纹石靴子");
        add(KModItems.SERPENTINE_HORSE_ARMOR, "蛇纹石马铠")
        add(KModItems.SERPENTINE_WOLF_ARMOR, "蛇纹石狼铠")
        add(KModItems.RAMYEON, "泡面")
        add(KModItems.KIMCHI, "泡菜")
        add(KModItems.TTEOKBOKKI, "炒年糕")
        add(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, "汉字盔甲饰边模版")
    }
}