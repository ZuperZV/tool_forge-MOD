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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public class GoldenExtracerRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final FluidStack fluidStack;


    public GoldenExtracerRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id, int craftTime, FluidStack fluidStack) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.fluidStack = fluidStack;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(1));
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

    public FluidStack getFluidStack() {
        return fluidStack;
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

    public static class Type implements RecipeType<GoldenExtracerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "golden_extracer";
    }

    public static class Serializer implements RecipeSerializer<GoldenExtracerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Tool_Forge.MOD_ID,"golden_extracer");

        @Override
        public GoldenExtracerRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            FluidStack fluidStack = new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(json.get("fluidType").getAsString())),
                    json.get("fluidAmount").getAsInt());

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            int craftTime = json.get("craftTime").getAsInt();
            return new GoldenExtracerRecipe(inputs, output, id, craftTime, fluidStack);
        }

        @Override
        public GoldenExtracerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            FluidStack fluidStack = buf.readFluidStack();

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int craftTime = buf.readInt();
            ItemStack output = buf.readItem();
            return new GoldenExtracerRecipe(inputs, output, id, craftTime, fluidStack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, GoldenExtracerRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            buf.writeFluidStack(recipe.fluidStack);

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeInt(recipe.craftTime);
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
