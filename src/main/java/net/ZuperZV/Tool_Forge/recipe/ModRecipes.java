package net.ZuperZV.Tool_Forge.recipe;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Tool_Forge.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ToolStationRecipe>> TOOL_STATION_SERIALIZER =
            SERIALIZERS.register("tool_station", () -> ToolStationRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<DeepslateFurnaceRecipe>> DEEPSLATE_FURNACE_SERIALIZER =
            SERIALIZERS.register("deepslate_furnace", () -> DeepslateFurnaceRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
} 