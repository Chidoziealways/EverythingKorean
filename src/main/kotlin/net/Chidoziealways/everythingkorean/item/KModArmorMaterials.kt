package net.Chidoziealways.everythingkorean.item

import net.Chidoziealways.everythingkorean.util.KModTags
import net.minecraft.Util
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.equipment.ArmorMaterial
import net.minecraft.world.item.equipment.ArmorType
import java.util.EnumMap

object KModArmorMaterials {
    val SERPENTINE: ArmorMaterial = ArmorMaterial(
        3500,
        Util.make(
            EnumMap(ArmorType::class.java))
        { attribute ->
            attribute[ArmorType.BOOTS] = 3
            attribute[ArmorType.LEGGINGS] = 5
            attribute[ArmorType.CHESTPLATE] = 10
            attribute[ArmorType.HELMET] = 7
            attribute[ArmorType.BODY] = 10
        }, 15, SoundEvents.ARMOR_EQUIP_DIAMOND,
        10f, 0.1f, KModTags.Items.REPAIRS_SERPENTINE_ARMOR, KModEquipmentAssets.SERPENTINE
    )
}