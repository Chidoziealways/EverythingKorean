package net.Chidoziealways.everythingkorean.datagen

//import net.Chidoziealways.everythingjapanese.trim.ModMaterialAssetGroup
//import net.Chidoziealways.everythingjapanese.trim.ModTrimMaterials
import net.Chidoziealways.everythingcore.datagen.createBlockStateDefinition
import net.Chidoziealways.everythingcore.datagen.createItemDefiniton
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.datagen.KModModelProvider.MyItemModelGenerators.Companion.TRIM_MATERIAL_MODELS
import net.Chidoziealways.everythingkorean.item.KModEquipmentAssets
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.client.color.item.Dye
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ItemModelOutput
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ItemModelUtils
import net.minecraft.client.data.models.model.ModelInstance
import net.minecraft.client.data.models.model.ModelLocationUtils
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TextureMapping
import net.minecraft.client.renderer.item.ItemModel
import net.minecraft.client.renderer.item.SelectItemModel
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.equipment.EquipmentAsset
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup
import net.minecraft.world.item.equipment.trim.TrimMaterial
import net.minecraft.world.item.equipment.trim.TrimMaterials
import java.util.concurrent.CompletableFuture
import java.util.function.BiConsumer

class KModModelProvider(output: PackOutput, val lookup: CompletableFuture<HolderLookup.Provider>) : ModelProvider(output,
    KOREAN_MOD_ID
) {
    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        blockModels.createTrivialCube(KModBlocks.SERPENTINE_BLOCK)
        blockModels.createTrivialCube(KModBlocks.SERPENTINE_ORE)
        blockModels.createTrivialCube(KModBlocks.SERPENTINE_DEEPSLATE_ORE)
        blockModels.createBlockStateDefinition(KModBlocks.KOREAN_FLAG, "korean_flag", KOREAN_MOD_ID)

        itemModels.generateFlatItem(KModItems.SERPENTINE, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(KModItems.RAMYEON, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(KModItems.KIMCHI, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(KModItems.TTEOKBOKKI, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(KModItems.SERPENTINE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.createItemDefiniton(KModItems.JANG_BI_CHANG, "jang_bi_chang", KOREAN_MOD_ID)
        itemModels.generateFlatItem(KModItems.SERPENTINE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(KModItems.SERPENTINE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(KModItems.SERPENTINE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(KModItems.SERPENTINE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM)
        itemModels.generateFlatItem(KModItems.HANJA_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM)

        itemModels.generateTrimmableItemE(
            KModItems.SERPENTINE_HELMET,
            KModEquipmentAssets.SERPENTINE,
            ItemModelGenerators.TRIM_PREFIX_HELMET,
            false
        )
        itemModels.generateTrimmableItemE(
            KModItems.SERPENTINE_CHESTPLATE,
            KModEquipmentAssets.SERPENTINE,
            ItemModelGenerators.TRIM_PREFIX_CHESTPLATE,
            false
        )
        itemModels.generateTrimmableItemE(
            KModItems.SERPENTINE_LEGGINGS,
            KModEquipmentAssets.SERPENTINE,
            ItemModelGenerators.TRIM_PREFIX_LEGGINGS,
            false
        )
        itemModels.generateTrimmableItemE(
            KModItems.SERPENTINE_BOOTS,
            KModEquipmentAssets.SERPENTINE,
            ItemModelGenerators.TRIM_PREFIX_BOOTS,
            false
        )
        itemModels.generateFlatItem(KModItems.SERPENTINE_HORSE_ARMOR, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(KModItems.SERPENTINE_WOLF_ARMOR, ModelTemplates.FLAT_ITEM)
    }

    fun ItemModelGenerators.generateTrimmableItemE(item: Item, resourceKey: ResourceKey<EquipmentAsset>, resourceLocation: ResourceLocation, p_377962_: Boolean) {
        val resourcelocation: ResourceLocation = ModelLocationUtils.getModelLocation(item)
        val resourcelocation1: ResourceLocation = TextureMapping.getItemTexture(item)
        val resourcelocation2: ResourceLocation = TextureMapping.getItemTexture(item, "_overlay")
        val list: MutableList<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>?> =
            ArrayList(
                TRIM_MATERIAL_MODELS.size
            )

        for (`itemmodelgenerators$trimmaterialdata` in TRIM_MATERIAL_MODELS) {
            val resourcelocation3 = resourcelocation.withSuffix(
                "_" + `itemmodelgenerators$trimmaterialdata`.assets!!.base().suffix() + "_trim"
            )
            val resourcelocation4 = resourceLocation.withSuffix(
                "_" + `itemmodelgenerators$trimmaterialdata`.assets.assetId(resourceKey).suffix()
            )
            val `itemmodel$unbaked`: ItemModel.Unbaked?
            if (p_377962_) {
                this.generateLayeredItem(resourcelocation3, resourcelocation1, resourcelocation2, resourcelocation4)
                `itemmodel$unbaked` = ItemModelUtils.tintedModel(resourcelocation3, Dye(-6265536))
            } else {
                this.generateLayeredItem(resourcelocation3, resourcelocation1, resourcelocation4)
                `itemmodel$unbaked` = ItemModelUtils.plainModel(resourcelocation3)
            }

            list.add(
                ItemModelUtils.`when`(
                    `itemmodelgenerators$trimmaterialdata`.materialKey,
                    `itemmodel$unbaked`
                )
            )
        }

        val `itemmodel$unbaked1`: ItemModel.Unbaked?
        if (p_377962_) {
            ModelTemplates.TWO_LAYERED_ITEM.create(
                resourcelocation,
                TextureMapping.layered(resourcelocation1, resourcelocation2),
                this.modelOutput
            )
            `itemmodel$unbaked1` = ItemModelUtils.tintedModel(resourcelocation, Dye(-6265536))
        } else {
            ModelTemplates.FLAT_ITEM.create(
                resourcelocation,
                TextureMapping.layer0(resourcelocation1),
                this.modelOutput
            )
            `itemmodel$unbaked1` = ItemModelUtils.plainModel(resourcelocation)
        }

        this.itemModelOutput.accept(
            item,
            ItemModelUtils.select(TrimMaterialProperty(), `itemmodel$unbaked1`, list)
        )
    }

    private class MyItemModelGenerators(
        pItemModelOutput: ItemModelOutput,
        pModelOutput: BiConsumer<ResourceLocation?, ModelInstance?>
    ) : ItemModelGenerators(pItemModelOutput, pModelOutput) {
        data class MyTrimMaterialData(val assets: MaterialAssetGroup?, val materialKey: ResourceKey<TrimMaterial>)

        companion object {
            val TRIM_MATERIAL_MODELS: MutableList<MyTrimMaterialData> = listOf<MyTrimMaterialData>(
                //MyTrimMaterialData(ModMaterialAssetGroup.PYRITE, ModTrimMaterials.PYRITE),
                MyTrimMaterialData(MaterialAssetGroup.QUARTZ, TrimMaterials.QUARTZ),
                MyTrimMaterialData(MaterialAssetGroup.IRON, TrimMaterials.IRON),
                MyTrimMaterialData(MaterialAssetGroup.NETHERITE, TrimMaterials.NETHERITE),
                MyTrimMaterialData(MaterialAssetGroup.REDSTONE, TrimMaterials.REDSTONE),
                MyTrimMaterialData(MaterialAssetGroup.COPPER, TrimMaterials.COPPER),
                MyTrimMaterialData(MaterialAssetGroup.GOLD, TrimMaterials.GOLD),
                MyTrimMaterialData(MaterialAssetGroup.EMERALD, TrimMaterials.EMERALD),
                MyTrimMaterialData(MaterialAssetGroup.DIAMOND, TrimMaterials.DIAMOND),
                MyTrimMaterialData(MaterialAssetGroup.LAPIS, TrimMaterials.LAPIS),
                MyTrimMaterialData(MaterialAssetGroup.AMETHYST, TrimMaterials.AMETHYST),
                MyTrimMaterialData(MaterialAssetGroup.RESIN, TrimMaterials.RESIN)
            ) as MutableList<MyTrimMaterialData>
        }
    }
}