package net.Chidoziealways.everythingkorean.item

import net.Chidoziealways.everythingkorean.Everythingkorean.logInfo
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvents
import net.minecraft.tags.DamageTypeTags
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SmithingTemplateItem
import net.minecraft.world.item.ToolMaterial
import net.minecraft.world.item.component.BlocksAttacks
import net.minecraft.world.item.component.BlocksAttacks.DamageReduction
import net.minecraft.world.item.component.BlocksAttacks.ItemDamageFunction
import net.minecraft.world.item.equipment.ArmorType
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue
import java.util.Optional

object KModItems {
    val ITEMS = DeferredRegister.createItems(KOREAN_MOD_ID)

    // GEMS
    val SERPENTINE by ITEMS.register("serpentine") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine")
                )
            )
        )
    }

    // WEAPONS
    val SERPENTINE_SWORD by ITEMS.register("serpentine_sword") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_sword")
                )
            )
                .sword(KModToolMaterials.SERPENTINE, 5f, -1.9f)
                .component(
                    DataComponents.BLOCKS_ATTACKS, BlocksAttacks(
                        0.1f,
                        1.4f,
                        listOf<DamageReduction?>(
                            DamageReduction(
                                90.0f,
                                Optional.empty(),
                                0.0f,
                                0.5f
                            )
                        ),
                        ItemDamageFunction(3.0f, 1.0f, 1.0f),
                        Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                        Optional.of(SoundEvents.SHIELD_BLOCK),
                        Optional.of(SoundEvents.SHIELD_BREAK)
                    )
                )
        )
    }

    val JANG_BI_CHANG by ITEMS.register("jang_bi_chang") { ->
        Item(
            Item.Properties()
                .setId(
                    ResourceKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "jang_bi_chang")
                    )
                )
                .sword(ToolMaterial.IRON, 8f, -2.3f)
                .component(
                    DataComponents.BLOCKS_ATTACKS, BlocksAttacks(
                        0.1f,
                        1.4f,
                        listOf<DamageReduction?>(
                            DamageReduction(
                                90.0f,
                                Optional.empty(),
                                0.0f,
                                0.5f
                            )
                        ),
                        ItemDamageFunction(3.0f, 1.0f, 1.0f),
                        Optional.of(DamageTypeTags.BYPASSES_SHIELD),
                        Optional.of(SoundEvents.SHIELD_BLOCK),
                        Optional.of(SoundEvents.SHIELD_BREAK)
                    )
                )
        )
    }

    val SERPENTINE_PICKAXE by ITEMS.register("serpentine_pickaxe") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_pickaxe")
                )
            )
                .pickaxe(KModToolMaterials.SERPENTINE, 5f, -2.5f)
        )
    }

    val SERPENTINE_AXE by ITEMS.register("serpentine_axe") { ->
        AxeItem(
            KModToolMaterials.SERPENTINE, 15f, -1.5f,
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_axe")
                )
            )
        )
    }

    val SERPENTINE_SHOVEL by ITEMS.register("serpentine_shovel") { ->
        ShovelItem(
            KModToolMaterials.SERPENTINE, 4.9f,-2.0f,
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_shovel")
                )
            )
        )
    }

    val SERPENTINE_HOE by ITEMS.register("serpentine_hoe") { ->
        HoeItem(
            KModToolMaterials.SERPENTINE, 1f,-2.0f,
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_hoe")
                )
            )
        )
    }

//    val HWANDO by ITEMS.register("hwando") { ->
//
//    }

    // ARMOR
    val SERPENTINE_HELMET by ITEMS.register("serpentine_helmet") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_helmet")
                )
            )
                .humanoidArmor(KModArmorMaterials.SERPENTINE, ArmorType.HELMET)
        )
    }

    val SERPENTINE_CHESTPLATE by ITEMS.register("serpentine_chestplate") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_chestplate")
                )
            )
                .humanoidArmor(KModArmorMaterials.SERPENTINE, ArmorType.CHESTPLATE)
        )
    }

    val SERPENTINE_LEGGINGS by ITEMS.register("serpentine_leggings") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_leggings")
                )
            )
                .humanoidArmor(KModArmorMaterials.SERPENTINE, ArmorType.LEGGINGS)
        )
    }

    val SERPENTINE_BOOTS by ITEMS.register("serpentine_boots") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_boots")
                )
            )
                .humanoidArmor(KModArmorMaterials.SERPENTINE, ArmorType.BOOTS)
        )
    }

    val SERPENTINE_HORSE_ARMOR by ITEMS.register("serpentine_horse_armor") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_horse_armor")
                )
            )
                .horseArmor(KModArmorMaterials.SERPENTINE)
        )
    }

    val SERPENTINE_WOLF_ARMOR by ITEMS.register("serpentine_wolf_armor") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "serpentine_wolf_armor")
                )
            )
                .wolfArmor(KModArmorMaterials.SERPENTINE)
        )
    }

    // FOOD
    val RAMYEON by ITEMS.register("ramyeon") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "ramyeon")
                )
            )
                .food(KModFoodProperties.RAMYEON)
                .usingConvertsTo(Items.BOWL)
        )
    }
    val KIMCHI by ITEMS.register("kimchi") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "kimchi")
                )
            )
                .food(KModFoodProperties.KIMCHI) // Define in KModFoodProperties
                .usingConvertsTo(Items.BOWL)
        )
    }

    val TTEOKBOKKI by ITEMS.register("tteokbokki") { ->
        Item(
            Item.Properties().setId(
                ResourceKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(KOREAN_MOD_ID, "tteokbokki")
                )
            )
                .food(KModFoodProperties.TTEOKBOKKI) // Define in KModFoodProperties
                .usingConvertsTo(Items.PAPER)
        )
    }

    val HANJA_ARMOR_TRIM_SMITHING_TEMPLATE by ITEMS.register("hanja_armor_trim_smithing_template") { ->
        SmithingTemplateItem.createArmorTrimTemplate(
            Item.Properties()
                .setId(
                    ResourceKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(
                            KOREAN_MOD_ID,
                            "hanja_armor_trim_smithing_template"
                        )
                    )
                )
                .rarity(Rarity.EPIC)
        )
    }

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
        logInfo("REGISTERING EVERY SINGLE ITEM IN MODITEMS")
    }
}