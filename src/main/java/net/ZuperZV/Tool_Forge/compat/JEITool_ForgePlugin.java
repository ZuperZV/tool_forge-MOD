package net.ZuperZV.Tool_Forge.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.recipe.DeepslateFurnaceRecipe;
import net.ZuperZV.Tool_Forge.recipe.ToolStationRecipe;
import net.ZuperZV.Tool_Forge.screen.DeepslateFurnaceScreen;
import net.ZuperZV.Tool_Forge.screen.ToolStationScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
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

        registration.addRecipeCategories(new DeepslateFurnaceRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ToolStationRecipe> tool_stationRecipes = recipeManager.getAllRecipesFor(ToolStationRecipe.Type.INSTANCE);
        registration.addRecipes(ToolStationRecipeCategory.TOOL_STATION_TYPE, tool_stationRecipes);

        List<DeepslateFurnaceRecipe> kaupenFurnaceRecipes = recipeManager.getAllRecipesFor(DeepslateFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(DeepslateFurnaceRecipeCategory.FURNACE_RECIPE_RECIPE_TYPE, kaupenFurnaceRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ToolStationScreen.class, 112, 38, 7, 26,
                ToolStationRecipeCategory.TOOL_STATION_TYPE);

        registration.addRecipeClickArea(DeepslateFurnaceScreen.class, 81, 38, 22, 14,
                DeepslateFurnaceRecipeCategory.FURNACE_RECIPE_RECIPE_TYPE);
    }
}
