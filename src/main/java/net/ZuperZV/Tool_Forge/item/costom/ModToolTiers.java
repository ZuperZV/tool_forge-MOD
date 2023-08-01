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
            new ForgeTier(5, 2000, 11f, 4f, 17,
                    ModTags.Blocks.NEEDS_GILDED_NETHERITE_TOOL, () -> Ingredient.of(ModItems.GILDED_NETHERITE_INGOT.get())),
            new ResourceLocation(Tool_Forge.MOD_ID, "gilded_netherite_ingot"), List.of(Tiers.NETHERITE), List.of());
}
