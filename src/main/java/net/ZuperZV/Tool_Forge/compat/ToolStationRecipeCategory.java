package net.ZuperZV.Tool_Forge.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.recipe.ToolStationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ToolStationRecipeCategory implements IRecipeCategory<ToolStationRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tool_Forge.MOD_ID, "tool_station");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID,
            "textures/gui/tool_station_gui_inv.png");

    public static final RecipeType<ToolStationRecipe> TOOL_STATION_TYPE =
            new RecipeType<>(UID, ToolStationRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ToolStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 79);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TOOL_STATION.get()));
    }


    @Override
    public RecipeType<ToolStationRecipe> getRecipeType() {
        return TOOL_STATION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Tool Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ToolStationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 59, 13).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 7).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 101, 13).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 58).addItemStack(recipe.getResultItem(null));

    }
}