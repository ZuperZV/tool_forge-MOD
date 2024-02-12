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
import net.ZuperZV.Tool_Forge.recipe.GoldenExporterRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GoldenExporterRecipeCategory implements IRecipeCategory<GoldenExporterRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Tool_Forge.MOD_ID, "golden_exporter");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID,
            "textures/gui/golden_extracer_jei.png");

    public static final RecipeType<GoldenExporterRecipe> GOLDEN_EXPORTER_TYPE =
            new RecipeType<>(UID, GoldenExporterRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GoldenExporterRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 58, 58);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GOLDEN_EXPORTER.get()));
    }


    @Override
    public RecipeType<GoldenExporterRecipe> getRecipeType() {
        return GOLDEN_EXPORTER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Golden Exporter");
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
    public void setRecipe(IRecipeLayoutBuilder builder, GoldenExporterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 3).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 27, 38).addItemStack(recipe.getResultItem(null));

    }
}