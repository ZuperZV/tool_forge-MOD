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
import net.ZuperZV.Tool_Forge.recipe.ToolForgeRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ToolForgeRecipeCategory implements IRecipeCategory<ToolForgeRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tool_Forge.MOD_ID, "tool_forge");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID,
            "textures/gui/tool_forge_gui_inv.png");

    public static final RecipeType<ToolForgeRecipe> TOOL_FORGE_TYPE =
            new RecipeType<>(UID, ToolForgeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ToolForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 154, 57);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TOOL_FORGE.get()));
    }


    @Override
    public RecipeType<ToolForgeRecipe> getRecipeType() {
        return TOOL_FORGE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Tool Forge");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ToolForgeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 2).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 41, 2).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 59, 2).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 23, 38).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 41, 38).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 59, 38).addIngredients(recipe.getIngredients().get(5));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 122, 35).addItemStack(recipe.getResultItem(null));

    }
}