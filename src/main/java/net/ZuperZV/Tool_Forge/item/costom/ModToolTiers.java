package net.ZuperZV.Tool_Forge.item.costom;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.ZuperZV.Tool_Forge.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier GILDED_NETERITE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2031, 9.0F, 4.0F, 18,
                    ModTags.Blocks.NEEDS_GILDED_NETHERITE_TOOL, () -> Ingredient.of(ModItems.GILDED_NETHERITE_INGOT.get())),
            new ResourceLocation(Tool_Forge.MOD_ID, "gilded_netherite_ingot"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier GILDED_DIAMOND = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1551, 8.0F, 3.0F, 16,
                    ModTags.Blocks.NEEDS_GILDED_DIAMOND_TOOL, () -> Ingredient.of(ModItems.GILDED_DIAMOND.get())),
            new ResourceLocation(Tool_Forge.MOD_ID, "gilded_diamond_ingot"), List.of(Tiers.DIAMOND), List.of());


}