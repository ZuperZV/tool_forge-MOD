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
import net.ZuperZV.Tool_Forge.recipe.DeepslateFurnaceRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
public class DeepslateFurnaceRecipeCategory implements IRecipeCategory<DeepslateFurnaceRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tool_Forge.MOD_ID, "deeplsate_furnace");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID,
            "textures/gui/deepslate_furnace_jei.png");

    public static final RecipeType<DeepslateFurnaceRecipe> FURNACE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, DeepslateFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public DeepslateFurnaceRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 63);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DEEPSLATE_FURNACE.get()));
    }

    @Override
    public RecipeType<DeepslateFurnaceRecipe> getRecipeType() {
        return FURNACE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tool_forge.deepslate_furnace");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DeepslateFurnaceRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 6).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 24).addItemStack(recipe.getResultItem(null));
    }
}
