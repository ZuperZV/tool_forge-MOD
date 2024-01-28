
package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GILDED_ORES = List.of(ModItems.RAW_GILDED_GOLD.get(),
            Blocks.GILDED_BLACKSTONE);

    private static final List<ItemLike> SOUL_STONE = List.of(ModBlocks.SOUL_STONE.get());

    private static final List<ItemLike> BISMUTH_SMELTABLES = List.of(ModBlocks.BISMUTH_ORE.get(),
            ModBlocks.BISMUTH_ENDSTONE_ORE.get(),ModBlocks.DEPPSLATE_BISMUTH_ORE.get());
    private static final List<ItemLike> LILLIUM_SMELTABLES = List.of(ModBlocks.LILLIUM_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //armor
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_GOLD.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.GILDED_GOLD_NUGGET.get())
                .unlockedBy("has_gilded_gold_nugget", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_GOLD_NUGGET.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.GILDED_GOLD_NUGGET.get(), 9)
                .requires(ModItems.GILDED_GOLD.get())
                .unlockedBy("has_gilded_gold", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_GOLD.get()).build()))
                .save(pWriter);

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_NETHERITE_INGOT.get())
                    .pattern("AAA")
                    .pattern("ABC")
                    .pattern("BC ")
                    .define('A', ModItems.GILDED_GOLD.get())
                    .define('B', Items.NETHERITE_INGOT)
                    .define('C', Items.GOLD_INGOT)
                    .unlockedBy("has_gilded_netherite_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                            of(ModItems.GILDED_GOLD_NUGGET.get()).build()))
                    .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_diamond_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TOOL_STATION.get())
                .pattern("DAD")
                .pattern("PLP")
                .pattern("P P")
                .define('A', Items.CRAFTING_TABLE)
                .define('P', Items.POLISHED_DEEPSLATE)
                .define('D', Items.DEEPSLATE_BRICKS)
                .define('L', Blocks.GLASS)
                .unlockedBy("has_crafting_table", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRAFTING_TABLE).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "tool_station_recipe"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("CAC")
                .pattern("CBC")
                .pattern("CCC")
                .define('A', ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Items.GILDED_BLACKSTONE)
                .define('C', ModItems.GILDED_GOLD.get())
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_netherite_smithing_template"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("CAC")
                .pattern("CBC")
                .pattern("CCC")
                .define('A', ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Items.GILDED_BLACKSTONE)
                .define('C', ModItems.GILDED_GOLD.get())
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_diamond_smithing_template"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_STONE_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.SOUL_STONE.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBEL_SOUL_STONE_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.COBEL_SOUL_STONE.get())
                .unlockedBy("has_cobel_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_big_bricks_stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS.get(), 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks_stairs"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_STONE_SLAB.get(), 6)
                .pattern("AAA")
                .define('A', ModBlocks.SOUL_STONE.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBEL_SOUL_STONE_SLAB.get(), 6)
                .pattern("AAA")
                .define('A', ModBlocks.COBEL_SOUL_STONE.get())
                .unlockedBy("has_cobel_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get(), 6)
                .pattern("AAA")
                .define('A', ModBlocks.SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_big_bricks_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB.get(), 6)
                .pattern("AAA")
                .define('A', ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHIESLED_SOUL_STONE.get())
                .pattern("A")
                .pattern("A")
                .define('A', ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get())
                .unlockedBy("has_soul_stone_big_bricks_slab", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_GOLD_NUGGET.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "chiesled_soul_stone"));


        oreSmelting(pWriter, SOUL_STONE, RecipeCategory.MISC, ModBlocks.COBEL_SOUL_STONE.get(), 0.50f, 170, "SOUL_STONE");

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.BISMUTH.get(), RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.LILLIUM.get(), RecipeCategory.MISC, ModBlocks.LILLIUM_BLOCK.get());

        oreSmelting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.25f, 200, "GILDED_GOLD_NUGGET");
        oreBlasting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.50f, 100, "GILDED_GOLD_NUGGET");

        oreSmelting(pWriter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.30f, 300, "BISMUTH");
        oreBlasting(pWriter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.30f, 150, "BISMUTH");

        oreSmelting(pWriter, LILLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LILLIUM.get(), 0.55f, 350, "LILLIUM");
        oreBlasting(pWriter, LILLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LILLIUM.get(), 0.55f, 250, "LILLIUM");

        stonecutting(Ingredient.of(Blocks.GILDED_BLACKSTONE)
                ,RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GILDED_GOLD.get())
                .unlockedBy(getHasName(Blocks.GILDED_BLACKSTONE), has(Blocks.GILDED_BLACKSTONE))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "raw_gilded_gold_from_stone_cutting"));



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ZOMBIE_HEAD)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("ACA")
                .define('A', Items.ROTTEN_FLESH)
                .define('B', Items.SKELETON_SKULL)
                .define('C', Items.BONE)
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.SKELETON_SKULL).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.SOUL_STONE_BRICKS.get(), 4)
                .requires(ModBlocks.SOUL_STONE.get())
                .requires(ModBlocks.SOUL_STONE.get())
                .requires(ModBlocks.SOUL_STONE.get())
                .requires(ModBlocks.SOUL_STONE.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.SOUL_STONE_BIG_BRICKS.get(), 4)
                .requires(ModBlocks.SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.SOUL_STONE_BRICKS.get())
                .unlockedBy("has_soul_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE_BRICKS.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_big_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.COBEL_SOUL_STONE_BRICKS.get(), 4)
                .requires(ModBlocks.COBEL_SOUL_STONE.get())
                .requires(ModBlocks.COBEL_SOUL_STONE.get())
                .requires(ModBlocks.COBEL_SOUL_STONE.get())
                .requires(ModBlocks.COBEL_SOUL_STONE.get())
                .unlockedBy("has_soul_stone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get(), 4)
                .requires(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .requires(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .unlockedBy("has_soul_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.SOUL_STONE_BRICKS.get()).build()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks"));

        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_bricks_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_bricks_big_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_bricks_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHIESLED_SOUL_STONE.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "chiseled_soul_stone_stone_cutting"));


        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_slab_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_slab_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_big_bricks_slab_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks_slab_stone_cutting"));


        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_STAIRS.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_stone_stairs_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_STAIRS.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_stone_stairs_cutting"));

        stonecutting(Ingredient.of(ModBlocks.SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS.get())
                .unlockedBy(getHasName(ModBlocks.SOUL_STONE.get()), has(ModBlocks.SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_big_bricks_stairs_stone_cutting"));

        stonecutting(Ingredient.of(ModBlocks.COBEL_SOUL_STONE.get())
                ,RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS.get())
                .unlockedBy(getHasName(ModBlocks.COBEL_SOUL_STONE.get()), has(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(pWriter, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone_big_bricks_stairs_stone_cutting"));


        //SmithingTransformRecipeBuilder.smithing(template, item to upgrade, upgradeitem, category, result)
    }
    public static SingleItemRecipeBuilder stonecutting(Ingredient pIngredient, RecipeCategory pCategory, ItemLike pResult) {
        return new SingleItemRecipeBuilder(pCategory, RecipeSerializer.STONECUTTER, pIngredient, pResult, 1);
    }

}