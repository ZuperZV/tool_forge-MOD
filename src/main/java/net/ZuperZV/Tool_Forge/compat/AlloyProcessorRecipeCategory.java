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
import net.ZuperZV.Tool_Forge.recipe.AlloyProcessorRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AlloyProcessorRecipeCategory implements IRecipeCategory<AlloyProcessorRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tool_Forge.MOD_ID, "alloy_processor");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID,
            "textures/gui/alloy_processor_gui_jei.png");

    public static final RecipeType<AlloyProcessorRecipe> ALLOY_PROCESSOR_TYPE =
            new RecipeType<>(UID, AlloyProcessorRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AlloyProcessorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 142, 53);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ALLOY_PROCESSOR.get()));
    }


    @Override
    public RecipeType<AlloyProcessorRecipe> getRecipeType() {
        return ALLOY_PROCESSOR_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Alloy Processor");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AlloyProcessorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 3, 6).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 5).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 6).addIngredients(recipe.getIngredients().get(2));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 99, 7).addItemStack(recipe.getResultItem(null));

    }
}