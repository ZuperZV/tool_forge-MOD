
package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;

import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.datagen.custom.ToolStationRecipeBuilder;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.ZuperZV.Tool_Forge.recipe.ToolStationRecipe;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.world.item.Items.GILDED_BLACKSTONE;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GILDED_ORES = List.of(ModItems.RAW_GILDED_GOLD.get(),
            Blocks.GILDED_BLACKSTONE);
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
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
                    .save(pWriter);

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
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern(" C ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', ModItems.GILDED_GOLD.get())
                .define('C', Items.OBSIDIAN)
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).build()))
                .save(pWriter);

        oreSmelting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.25f, 200, "GILDED_GOLD_NUGGET");
        oreBlasting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.50f, 100, "GILDED_GOLD_NUGGET");

    }

}