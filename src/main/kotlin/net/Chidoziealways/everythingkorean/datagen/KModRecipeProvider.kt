package net.Chidoziealways.everythingkorean.datagen

import net.Chidoziealways.everythingcore.datagen.axe
import net.Chidoziealways.everythingcore.datagen.boots
import net.Chidoziealways.everythingcore.datagen.chestplate
import net.Chidoziealways.everythingcore.datagen.helmet
import net.Chidoziealways.everythingcore.datagen.hoe
import net.Chidoziealways.everythingcore.datagen.leggings
import net.Chidoziealways.everythingcore.datagen.pickaxe
import net.Chidoziealways.everythingcore.datagen.saveShapedRecipe
import net.Chidoziealways.everythingcore.datagen.saveShapelessRecipe
import net.Chidoziealways.everythingcore.datagen.shovel
import net.Chidoziealways.everythingcore.datagen.sword
import net.Chidoziealways.everythingkorean.KOREAN_MOD_ID
import net.Chidoziealways.everythingkorean.block.KModBlocks
import net.Chidoziealways.everythingkorean.item.KModItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.AbstractCookingRecipe
import net.minecraft.world.item.crafting.BlastingRecipe
import net.minecraft.world.item.crafting.CookingBookCategory
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.crafting.SmeltingRecipe
import net.minecraft.world.item.crafting.SmokingRecipe
import net.minecraft.world.level.ItemLike
import java.util.concurrent.CompletableFuture

open class KModRecipeProvider(lookup: HolderLookup.Provider, recipeOutput: RecipeOutput) :
    RecipeProvider(lookup, recipeOutput) {
    class Runner(output: PackOutput, providerCompletableFuture: CompletableFuture<HolderLookup.Provider>) :
        RecipeProvider.Runner(output, providerCompletableFuture) {
        override fun createRecipeProvider(pRegistries: HolderLookup.Provider, pOutput: RecipeOutput): RecipeProvider {
            return KModRecipeProvider(pRegistries, pOutput)
        }

        override fun getName(): String {
            return "Recipes"
        }
    }

    override fun buildRecipes() {
        saveShapedRecipe(
            shaped(RecipeCategory.REDSTONE, KModBlocks.SERPENTINE_BLOCK)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', KModItems.SERPENTINE),
            KModItems.SERPENTINE
        )

        saveShapelessRecipe(
            shapeless(RecipeCategory.MISC, KModItems.SERPENTINE, 9)
                .requires(KModBlocks.SERPENTINE_BLOCK),
            KModBlocks.SERPENTINE_BLOCK.asItem()
        )

        sword(KModItems.SERPENTINE, KModItems.SERPENTINE_SWORD)

        saveShapedRecipe(
            shaped(RecipeCategory.COMBAT, KModItems.JANG_BI_CHANG)
                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', Items.IRON_INGOT)
                .define('B', ItemTags.PLANKS)
                .define('C', Items.STICK),
            Items.IRON_INGOT
        )

        saveShapelessRecipe(
            shapeless(RecipeCategory.FOOD, KModItems.KIMCHI)
                .requires(Items.BOWL)
                .requires(Items.CARROT)
                .requires(Items.WHEAT)
                .requires(Items.COOKED_COD),
            Items.BOWL
        )

        saveShapelessRecipe(
            shapeless(RecipeCategory.FOOD, KModItems.TTEOKBOKKI)
                .requires(Items.PAPER)
                .requires(Items.EGG)
                .requires(Items.WHEAT)
                .requires(Items.COOKED_PORKCHOP),
            Items.PAPER
        )

        pickaxe(KModItems.SERPENTINE, KModItems.SERPENTINE_PICKAXE)

        axe(KModItems.SERPENTINE, KModItems.SERPENTINE_AXE)

        shovel(KModItems.SERPENTINE, KModItems.SERPENTINE_SHOVEL)

        hoe(KModItems.SERPENTINE, KModItems.SERPENTINE_HOE)

        helmet(KModItems.SERPENTINE, KModItems.SERPENTINE_HELMET)

        chestplate(KModItems.SERPENTINE, KModItems.SERPENTINE_CHESTPLATE)

        leggings(KModItems.SERPENTINE, KModItems.SERPENTINE_LEGGINGS)

        boots(KModItems.SERPENTINE, KModItems.SERPENTINE_BOOTS)

        saveShapedRecipe(
            shaped(RecipeCategory.COMBAT, KModItems.SERPENTINE_WOLF_ARMOR)
                .pattern("X  ")
                .pattern("XXX")
                .pattern("X X")
                .define('X', KModItems.SERPENTINE),
            KModItems.SERPENTINE
        )

        saveShapedRecipe(
            shaped(RecipeCategory.FOOD, KModItems.RAMYEON)
                .pattern(" K ")
                .pattern(" A ")
                .pattern(" BW")
                .define('B', Items.BOWL)
                .define('A', Items.WHEAT)
                .define('K', Items.KELP)
                .define('W', Items.POTION),
            Items.BOWL
        )
    }

    protected fun smelting(
        recipeOutput: RecipeOutput, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike,
        pExperience: Float, pCookingTIme: Int, pGroup: String
    ) {
        cooking<SmeltingRecipe>(
            recipeOutput,
            RecipeSerializer.SMELTING_RECIPE,
            { p_250200_: String, p_251114_: CookingBookCategory, p_250340_: Ingredient, p_250306_: ItemStack, p_249577_: Float, p_250030_: Int ->
                SmeltingRecipe(
                    p_250200_,
                    p_251114_,
                    p_250340_,
                    p_250306_,
                    p_249577_,
                    p_250030_
                )
            },
            pIngredients,
            pCategory,
            pResult,
            pExperience,
            pCookingTIme,
            pGroup,
            "_from_smelting"
        )
    }

    protected fun smoking(
        recipeOutput: RecipeOutput, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike,
        pExperience: Float, pCookingTIme: Int, pGroup: String
    ) {
        cooking<SmokingRecipe>(
            recipeOutput,
            RecipeSerializer.SMOKING_RECIPE,
            { p_249312_: String, p_251017_: CookingBookCategory, p_252345_: Ingredient, p_250002_: ItemStack, p_250535_: Float, p_251222_: Int ->
                SmokingRecipe(
                    p_249312_,
                    p_251017_,
                    p_252345_,
                    p_250002_,
                    p_250535_,
                    p_251222_
                )
            },
            pIngredients,
            pCategory,
            pResult,
            pExperience,
            pCookingTIme,
            pGroup,
            "_from_smelting"
        )
    }

    protected fun oreBlasting(
        recipeOutput: RecipeOutput, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike,
        pExperience: Float, pCookingTime: Int, pGroup: String
    ) {
        cooking<BlastingRecipe>(
            recipeOutput,
            RecipeSerializer.BLASTING_RECIPE,
            { p_251053_: String, p_249936_: CookingBookCategory, p_251550_: Ingredient, p_251027_: ItemStack, p_250843_: Float, p_249841_: Int ->
                BlastingRecipe(
                    p_251053_,
                    p_249936_,
                    p_251550_,
                    p_251027_,
                    p_250843_,
                    p_249841_
                )
            },
            pIngredients,
            pCategory,
            pResult,
            pExperience,
            pCookingTime,
            pGroup,
            "_from_blasting"
        )
    }

    protected fun <T : AbstractCookingRecipe> cooking(
        recipeOutput: RecipeOutput,
        pCookingSerializer: RecipeSerializer<T>,
        factory: AbstractCookingRecipe.Factory<T>,
        pIngredients: MutableList<ItemLike>,
        pCategory: RecipeCategory,
        pResult: ItemLike,
        pExperience: Float,
        pCookingTime: Int,
        pGroup: String,
        pRecipeName: String
    ) {
        for (itemlike in pIngredients) {
            SimpleCookingRecipeBuilder.generic<T>(
                Ingredient.of(itemlike),
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pCookingSerializer,
                factory
            ).group(pGroup).unlockedBy(
                getHasName(itemlike), has(itemlike)
            )
                .save(
                    recipeOutput,
                    KOREAN_MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike)
                )
        }
    }
}