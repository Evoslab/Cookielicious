package com.evoslab.cookielicious.core.datagen;

import com.evoslab.cookielicious.core.Cookielicious;
import com.evoslab.cookielicious.core.CookieliciousConfig;
import com.evoslab.cookielicious.core.other.CookieliciousCompat;
import com.evoslab.cookielicious.core.registry.CookieliciousBlocks;
import com.evoslab.cookielicious.core.registry.CookieliciousItems;
import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.core.Blueprint;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CRecipeProvider extends RecipeProvider {
    private static final ConfigValueCondition enableVanillaCookies = configCondition(CookieliciousConfig.COMMON.enableVanillaCookies, "vanilla_cookie", false);
    private static final ConfigValueCondition enableStrawberryCookies = configCondition(CookieliciousConfig.COMMON.enableStrawberryCookies, "strawberry_cookie", false);
    private static final ConfigValueCondition enableChocolateCookies = configCondition(CookieliciousConfig.COMMON.enableChocolateCookies, "chocolate_cookie", false);
    private static final ConfigValueCondition enableMintCookies = configCondition(CookieliciousConfig.COMMON.enableMintCookies, "mint_cookie", false);
    private static final ConfigValueCondition enableBananaCookies = configCondition(CookieliciousConfig.COMMON.enableBananaCookies, "banana_cookie", false);
    private static final ConfigValueCondition enableAdzukiCookies = configCondition(CookieliciousConfig.COMMON.enableAdzukiCookies, "adzuki_cookie", false);
    private static final ConfigValueCondition enableVanillaCookieTiles = configCondition(CookieliciousConfig.COMMON.enableVanillaCookieTiles, "vanilla_cookie_tiles", false);
    private static final ConfigValueCondition enableStrawberryCookieTiles = configCondition(CookieliciousConfig.COMMON.enableStrawberryCookieTiles, "strawberry_cookie_tiles", false);
    private static final ConfigValueCondition enableChocolateCookieTiles = configCondition(CookieliciousConfig.COMMON.enableChocolateCookieTiles, "chocolate_cookie_tiles", false);
    private static final ConfigValueCondition enableHoneyCookieTiles = configCondition(CookieliciousConfig.COMMON.enableHoneyCookieTiles, "honey_cookie_tiles", false);
    private static final ConfigValueCondition enableSweetBerryCookieTiles = configCondition(CookieliciousConfig.COMMON.enableSweetBerryCookieTiles, "sweet_berry_cookie_tiles", false);
    private static final ConfigValueCondition enableMintCookieTiles = configCondition(CookieliciousConfig.COMMON.enableMintCookieTiles, "mint_cookie_tiles", false);
    private static final ConfigValueCondition enableBananaCookieTiles = configCondition(CookieliciousConfig.COMMON.enableBananaCookieTiles, "banana_cookie_tiles", false);
    private static final ConfigValueCondition enableAdzukiCookieTiles = configCondition(CookieliciousConfig.COMMON.enableAdzukiCookieTiles, "adzuki_cookie_tiles", false);
    private static final ConfigValueCondition enableCookieTiles = configCondition(CookieliciousConfig.COMMON.enableCookieTiles, "cookie_tiles", false);
    private static final ConfigValueCondition enableCherryCookieTiles = configCondition(CookieliciousConfig.COMMON.enableCherryCookieTiles, "cherry_cookie_tiles", false);
    private static final ConfigValueCondition enableMulberryCookieTiles = configCondition(CookieliciousConfig.COMMON.enableMulberryCookieTiles, "mulberry_cookie_tiles", false);
    private static final ConfigValueCondition enableMapleCookieTiles = configCondition(CookieliciousConfig.COMMON.enableMapleCookieTiles, "maple_cookie_tiles", false);

    public CRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        addCookieRecipe(enableVanillaCookies, CookieliciousItems.VANILLA_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "dried_vanilla_pods"), consumer);
        addCookieRecipe(enableStrawberryCookies, CookieliciousItems.STRAWBERRY_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "strawberries"), consumer);
        addCookieRecipe(enableChocolateCookies, CookieliciousItems.CHOCOLATE_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "chocolate_bar"), consumer);
        addCookieRecipe(enableMintCookies, CookieliciousItems.MINT_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "mint_leaves"), consumer);
        addCookieRecipe(enableBananaCookies, CookieliciousItems.BANANA_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "banana"), consumer);
        addCookieRecipe(enableAdzukiCookies, CookieliciousItems.ADZUKI_COOKIE, () -> getItem(CookieliciousCompat.NEAPOLITAN, "roasted_adzuki_beans"), consumer);

        addCookieTileRecipes(enableVanillaCookieTiles, CookieliciousItems.VANILLA_COOKIE, CookieliciousBlocks.VANILLA_COOKIE_TILES, CookieliciousBlocks.VANILLA_COOKIE_TILE_STAIRS, CookieliciousBlocks.VANILLA_COOKIE_TILE_SLAB, CookieliciousBlocks.VANILLA_COOKIE_TILE_WALL, CookieliciousBlocks.VANILLA_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableCookieTiles, () -> Items.COOKIE, CookieliciousBlocks.COOKIE_TILES, CookieliciousBlocks.COOKIE_TILE_STAIRS, CookieliciousBlocks.COOKIE_TILE_SLAB, CookieliciousBlocks.COOKIE_TILE_WALL, CookieliciousBlocks.COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableStrawberryCookieTiles, CookieliciousItems.STRAWBERRY_COOKIE, CookieliciousBlocks.STRAWBERRY_COOKIE_TILES, CookieliciousBlocks.STRAWBERRY_COOKIE_TILE_STAIRS, CookieliciousBlocks.STRAWBERRY_COOKIE_TILE_SLAB, CookieliciousBlocks.STRAWBERRY_COOKIE_TILE_WALL, CookieliciousBlocks.STRAWBERRY_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableChocolateCookieTiles, CookieliciousItems.CHOCOLATE_COOKIE, CookieliciousBlocks.CHOCOLATE_COOKIE_TILES, CookieliciousBlocks.CHOCOLATE_COOKIE_TILE_STAIRS, CookieliciousBlocks.CHOCOLATE_COOKIE_TILE_SLAB, CookieliciousBlocks.CHOCOLATE_COOKIE_TILE_WALL, CookieliciousBlocks.CHOCOLATE_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addModLoadedCookieTileRecipes(enableHoneyCookieTiles, CookieliciousCompat.FARMERS_DELIGHT, () -> getItem(CookieliciousCompat.FARMERS_DELIGHT, "honey_cookie"), CookieliciousBlocks.HONEY_COOKIE_TILES, CookieliciousBlocks.HONEY_COOKIE_TILE_STAIRS, CookieliciousBlocks.HONEY_COOKIE_TILE_SLAB, CookieliciousBlocks.HONEY_COOKIE_TILE_WALL, CookieliciousBlocks.HONEY_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addModLoadedCookieTileRecipes(enableSweetBerryCookieTiles, CookieliciousCompat.FARMERS_DELIGHT, () -> getItem(CookieliciousCompat.FARMERS_DELIGHT, "sweet_berry_cookie"), CookieliciousBlocks.SWEET_BERRY_COOKIE_TILES, CookieliciousBlocks.SWEET_BERRY_COOKIE_TILE_STAIRS, CookieliciousBlocks.SWEET_BERRY_COOKIE_TILE_SLAB, CookieliciousBlocks.SWEET_BERRY_COOKIE_TILE_WALL, CookieliciousBlocks.SWEET_BERRY_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableBananaCookieTiles, CookieliciousItems.BANANA_COOKIE, CookieliciousBlocks.BANANA_COOKIE_TILES, CookieliciousBlocks.BANANA_COOKIE_TILE_STAIRS, CookieliciousBlocks.BANANA_COOKIE_TILE_SLAB, CookieliciousBlocks.BANANA_COOKIE_TILE_WALL, CookieliciousBlocks.BANANA_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableMintCookieTiles, CookieliciousItems.MINT_COOKIE, CookieliciousBlocks.MINT_COOKIE_TILES, CookieliciousBlocks.MINT_COOKIE_TILE_STAIRS, CookieliciousBlocks.MINT_COOKIE_TILE_SLAB, CookieliciousBlocks.MINT_COOKIE_TILE_WALL, CookieliciousBlocks.MINT_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addCookieTileRecipes(enableAdzukiCookieTiles, CookieliciousItems.ADZUKI_COOKIE, CookieliciousBlocks.ADZUKI_COOKIE_TILES, CookieliciousBlocks.ADZUKI_COOKIE_TILE_STAIRS, CookieliciousBlocks.ADZUKI_COOKIE_TILE_SLAB, CookieliciousBlocks.ADZUKI_COOKIE_TILE_WALL, CookieliciousBlocks.ADZUKI_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addModLoadedCookieTileRecipes(enableCherryCookieTiles, CookieliciousCompat.ABNORMALS_DELIGHT, () -> getItem(CookieliciousCompat.ABNORMALS_DELIGHT, "cherry_cookie"), CookieliciousBlocks.CHERRY_COOKIE_TILES, CookieliciousBlocks.CHERRY_COOKIE_TILE_STAIRS, CookieliciousBlocks.CHERRY_COOKIE_TILE_SLAB, CookieliciousBlocks.CHERRY_COOKIE_TILE_WALL, CookieliciousBlocks.CHERRY_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addModLoadedCookieTileRecipes(enableMulberryCookieTiles, CookieliciousCompat.ABNORMALS_DELIGHT, () -> getItem(CookieliciousCompat.ABNORMALS_DELIGHT, "mulberry_cookie"), CookieliciousBlocks.MULBERRY_COOKIE_TILES, CookieliciousBlocks.MULBERRY_COOKIE_TILE_STAIRS, CookieliciousBlocks.MULBERRY_COOKIE_TILE_SLAB, CookieliciousBlocks.MULBERRY_COOKIE_TILE_WALL, CookieliciousBlocks.MULBERRY_COOKIE_TILE_VERTICAL_SLAB, consumer);
        addModLoadedCookieTileRecipes(enableMapleCookieTiles, CookieliciousCompat.ABNORMALS_DELIGHT, () -> getItem(CookieliciousCompat.ABNORMALS_DELIGHT, "maple_cookie"), CookieliciousBlocks.MAPLE_COOKIE_TILES, CookieliciousBlocks.MAPLE_COOKIE_TILE_STAIRS, CookieliciousBlocks.MAPLE_COOKIE_TILE_SLAB, CookieliciousBlocks.MAPLE_COOKIE_TILE_WALL, CookieliciousBlocks.MAPLE_COOKIE_TILE_VERTICAL_SLAB, consumer);

    }

    private static void addCookieRecipe(ICondition condition, Supplier<? extends ItemLike> result, Supplier<? extends ItemLike> input, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(condition, ShapedRecipeBuilder.shaped(result.get(), 8)
                .define('W', Items.WHEAT)
                .define('R', input.get())
                .pattern("WRW").unlockedBy(getHasName(input.get()), has(input.get())), consumer, "crafting");
    }

    private static void addCookieTileRecipes(ICondition condition, Supplier<? extends ItemLike> cookie, Supplier<? extends ItemLike> tilesBlock, Supplier<? extends ItemLike> stair, Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> wall, Supplier<? extends ItemLike> vertical_slab, Consumer<FinishedRecipe> consumer) {

        //Tiles
        conditionalRecipe(condition, ShapedRecipeBuilder.shaped(tilesBlock.get(), 4)
                .define('#', cookie.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(cookie.get()), has(cookie.get())), consumer, "crafting");
        //Stairs
        conditionalRecipe(condition, ShapedRecipeBuilder.shaped(stair.get(), 4)
                .define('#', tilesBlock.get()).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalRecipe(condition, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), stair.get())
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Slab
        conditionalRecipe(condition, ShapedRecipeBuilder.shaped(slab.get(), 6)
                .define('#', tilesBlock.get()).pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalRecipe(condition, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), slab.get(), 2)
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Wall
        conditionalRecipe(condition, ShapedRecipeBuilder.shaped(wall.get(), 6)
                .define('#', tilesBlock.get()).pattern("###").pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalRecipe(condition, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), wall.get())
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Vertical Slabs
        verticalSlabs(condition, tilesBlock, slab, vertical_slab, consumer);

    }

    private static void addModLoadedCookieTileRecipes(ICondition condition, String modId, Supplier<? extends ItemLike> cookie, Supplier<? extends ItemLike> tilesBlock, Supplier<? extends ItemLike> stair, Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> wall, Supplier<? extends ItemLike> vertical_slab, Consumer<FinishedRecipe> consumer) {

        //Tiles
        conditionalModLoadedRecipe(condition, modId, ShapedRecipeBuilder.shaped(tilesBlock.get(), 4)
                .define('#', cookie.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(cookie.get()), has(cookie.get())), consumer, "crafting");
        //Stairs
        conditionalModLoadedRecipe(condition, modId, ShapedRecipeBuilder.shaped(stair.get(), 4)
                .define('#', tilesBlock.get()).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalModLoadedRecipe(condition, modId, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), stair.get())
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Slab
        conditionalModLoadedRecipe(condition, modId, ShapedRecipeBuilder.shaped(slab.get(), 6)
                .define('#', tilesBlock.get()).pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalModLoadedRecipe(condition, modId, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), slab.get(), 2)
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Wall
        conditionalModLoadedRecipe(condition, modId, ShapedRecipeBuilder.shaped(wall.get(), 6)
                .define('#', tilesBlock.get()).pattern("###").pattern("###")
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "crafting");

        conditionalModLoadedRecipe(condition, modId, SingleItemRecipeBuilder.stonecutting(Ingredient.of(tilesBlock.get()), wall.get())
                .unlockedBy(getHasName(tilesBlock.get()), has(tilesBlock.get())), consumer, "stonecutting");
        //Vertical Slabs
        verticalSlabs(condition, tilesBlock, slab, vertical_slab, consumer);

    }

    public static QuarkFlagRecipeCondition quarkFlag(String flag) {
        return new QuarkFlagRecipeCondition(new ResourceLocation("blueprint", "quark_flag"), flag);
    }

    public static void verticalSlabs(ICondition condition,Supplier<? extends ItemLike> tile, Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> verticalSlab, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(quarkFlag("vertical_slabs")).addCondition(condition)
                .addRecipe(consumer1 -> ShapedRecipeBuilder.shaped(verticalSlab.get(), 3).define('#', slab.get()).pattern("#").pattern("#").pattern("#")
                        .unlockedBy(getHasName(slab.get()), has(slab.get())).save(consumer1, Cookielicious.modPrefix(getItemName(verticalSlab.get()))))
                .build(consumer, Cookielicious.modPrefix("crafting/" + getItemName(verticalSlab.get())));

        ConditionalRecipe.builder()
                .addCondition(quarkFlag("vertical_slabs")).addCondition(condition)
                .addRecipe(consumer1 -> ShapelessRecipeBuilder.shapeless(slab.get()).requires(verticalSlab.get())
                        .unlockedBy(getHasName(verticalSlab.get()), has(verticalSlab.get())).save(consumer1, Cookielicious.modPrefix(getItemName(verticalSlab.get()) + "_revert")))
                .build(consumer, Cookielicious.modPrefix("crafting/" + getItemName(verticalSlab.get()) + "_revert"));

        ConditionalRecipe.builder()
                .addCondition(quarkFlag("vertical_slabs")).addCondition(condition)
                .addRecipe(consumer1 -> SingleItemRecipeBuilder.stonecutting(Ingredient.of(tile.get()), verticalSlab.get(), 2)
                        .unlockedBy(getHasName(slab.get()), has(slab.get())).save(consumer1, Cookielicious.modPrefix(getItemName(verticalSlab.get()))))
                .build(consumer, Cookielicious.modPrefix("stonecutting/" + getItemName(verticalSlab.get())));
    }

    public static void conditionalModLoadedRecipe(ICondition condition, String modId, RecipeBuilder recipe, Consumer<FinishedRecipe> consumer, String customPath) {
        ConditionalRecipe.builder()
                .addCondition(condition).addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> recipe.save(consumer1, Cookielicious.modPrefix(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath())))
                .generateAdvancement(new ResourceLocation(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()))
                .build(consumer, Cookielicious.modPrefix(customPath + "/" + RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()));
    }

    public static void conditionalRecipe(ICondition condition, RecipeBuilder recipe, Consumer<FinishedRecipe> consumer, String customPath) {
        ConditionalRecipe.builder()
                .addCondition(condition)
                .addRecipe(consumer1 -> recipe.save(consumer1, Cookielicious.modPrefix(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath())))
                .generateAdvancement(new ResourceLocation(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()))
                .build(consumer, Cookielicious.modPrefix(customPath + "/" + RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()));
    }

    private static ConfigValueCondition configCondition(ForgeConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
        return new ConfigValueCondition(Cookielicious.modPrefix("config"), value, key, Maps.newHashMap(), inverted);
    }

    public static Item getItem(String modId, String id) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, id));
    }
}
