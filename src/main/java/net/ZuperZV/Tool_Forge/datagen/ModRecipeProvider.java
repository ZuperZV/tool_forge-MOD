
package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GILDED_ORES = List.of(ModItems.RAW_GILDED_GOLD.get(),
            Blocks.GILDED_BLACKSTONE);

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
                .define('C', Items.GILDED_BLACKSTONE)
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE)
                .pattern("CAC")
                .pattern("CBC")
                .pattern("CCC")
                .define('A', ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Items.GILDED_BLACKSTONE)
                .define('C', ModItems.GILDED_GOLD.get())
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get()).build()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .pattern("CAC")
                .pattern("CBC")
                .pattern("CCC")
                .define('A', ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get())
                .define('B', Items.GILDED_BLACKSTONE)
                .define('C', ModItems.GILDED_GOLD.get())
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE)
                .pattern(" C ")
                .pattern("BAB")
                .pattern(" C ")
                .define('A', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('B', ModItems.GILDED_GOLD.get())
                .define('C', Items.BLACKSTONE)
                .unlockedBy("has_netherite_upgrade_smithing_template", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).build()))
                .save(pWriter);




        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.BISMUTH.get(), RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get());
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.LILLIUM.get(), RecipeCategory.MISC, ModBlocks.LILLIUM_BLOCK.get());

        oreSmelting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.25f, 200, "GILDED_GOLD_NUGGET");
        oreBlasting(pWriter, GILDED_ORES, RecipeCategory.MISC, ModItems.GILDED_GOLD_NUGGET.get(), 0.50f, 100, "GILDED_GOLD_NUGGET");

        oreSmelting(pWriter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.30f, 300, "BISMUTH");
        oreBlasting(pWriter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.30f, 150, "BISMUTH");

        oreSmelting(pWriter, LILLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LILLIUM.get(), 0.55f, 350, "LILLIUM");
        oreBlasting(pWriter, LILLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LILLIUM.get(), 0.55f, 250, "LILLIUM");




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
    }

}