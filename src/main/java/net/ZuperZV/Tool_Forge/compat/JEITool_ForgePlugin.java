package net.ZuperZV.Tool_Forge.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.recipe.*;
import net.ZuperZV.Tool_Forge.screen.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEITool_ForgePlugin implements IModPlugin {


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Tool_Forge.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

        registration.addRecipeCategories(new ToolStationRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new ToolForgeRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new AlloyProcessorRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new GoldenExporterRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new DeepslateFurnaceRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ToolStationRecipe> tool_stationRecipes = recipeManager.getAllRecipesFor(ToolStationRecipe.Type.INSTANCE);
        registration.addRecipes(ToolStationRecipeCategory.TOOL_STATION_TYPE, tool_stationRecipes);

        List<ToolForgeRecipe> tool_forgeRecipes = recipeManager.getAllRecipesFor(ToolForgeRecipe.Type.INSTANCE);
        registration.addRecipes(ToolForgeRecipeCategory.TOOL_FORGE_TYPE, tool_forgeRecipes);

        List<GoldenExporterRecipe> golden_expoterRecipes = recipeManager.getAllRecipesFor(GoldenExporterRecipe.Type.INSTANCE);
        registration.addRecipes(GoldenExporterRecipeCategory.GOLDEN_EXPORTER_TYPE, golden_expoterRecipes);

        List<AlloyProcessorRecipe> alloy_processorRecipes = recipeManager.getAllRecipesFor(AlloyProcessorRecipe.Type.INSTANCE);
        registration.addRecipes(AlloyProcessorRecipeCategory.ALLOY_PROCESSOR_TYPE, alloy_processorRecipes);

        List<DeepslateFurnaceRecipe> DeepslateFurnaceRecipes = recipeManager.getAllRecipesFor(DeepslateFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(DeepslateFurnaceRecipeCategory.FURNACE_RECIPE_RECIPE_TYPE, DeepslateFurnaceRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ToolStationScreen.class, 112, 38, 7, 26,
                ToolStationRecipeCategory.TOOL_STATION_TYPE);

        registration.addRecipeClickArea(ToolForgeScreen.class, 112, 38, 7, 26,
                ToolForgeRecipeCategory.TOOL_FORGE_TYPE);

        registration.addRecipeClickArea(GoldenExporterScreen.class, 112, 38, 7, 26,
                GoldenExporterRecipeCategory.GOLDEN_EXPORTER_TYPE);

        registration.addRecipeClickArea(AlloyProcessorScreen.class, 64, 31, 48, 14,
                AlloyProcessorRecipeCategory.ALLOY_PROCESSOR_TYPE);

        registration.addRecipeClickArea(DeepslateFurnaceScreen.class, 81, 38, 22, 54,
                DeepslateFurnaceRecipeCategory.FURNACE_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TOOL_STATION.get()), ToolStationRecipeCategory.TOOL_STATION_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TOOL_FORGE.get()), ToolForgeRecipeCategory.TOOL_FORGE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ALLOY_PROCESSOR.get()), AlloyProcessorRecipeCategory.ALLOY_PROCESSOR_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GOLDEN_EXPORTER.get()), GoldenExporterRecipeCategory.GOLDEN_EXPORTER_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.DEEPSLATE_FURNACE.get()), DeepslateFurnaceRecipeCategory.FURNACE_RECIPE_RECIPE_TYPE);
    }

}
