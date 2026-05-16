package net.Chidoziealways.everythingkorean.item

import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.equipment.EquipmentAsset
import net.minecraft.world.item.equipment.EquipmentAssets

interface KModEquipmentAssets {
    companion object {
        fun createId(pName: String): ResourceKey<EquipmentAsset> {
            return ResourceKey.create(
                EquipmentAssets.ROOT_ID,
                ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, pName)
            )
        }

        val SERPENTINE = createId("serpentine")
    }
}