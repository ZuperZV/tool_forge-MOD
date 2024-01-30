package net.ZuperZV.Tool_Forge.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ToolForgeRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;


    public ToolForgeRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id, int craftTime) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0)) &&
                inputItems.get(1).test(pContainer.getItem(1)) &&
                inputItems.get(2).test(pContainer.getItem(2)) &&
                inputItems.get(3).test(pContainer.getItem(3)) &&
                inputItems.get(4).test(pContainer.getItem(4)) &&
                inputItems.get(5).test(pContainer.getItem(5));
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    public int getCraftTime() {
        return craftTime;
    }


    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ToolForgeRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "tool_forge";
    }

    public static class Serializer implements RecipeSerializer<ToolForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tool_Forge.MOD_ID,"tool_forge");

        @Override
        public ToolForgeRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(6, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            int craftTime = json.get("craftTime").getAsInt();
            return new ToolForgeRecipe(inputs, output, id, craftTime);
        }

        @Override
        public ToolForgeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int craftTime = buf.readInt();
            ItemStack output = buf.readItem();
            return new ToolForgeRecipe(inputs, output, id, craftTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ToolForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeInt(recipe.craftTime);
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
