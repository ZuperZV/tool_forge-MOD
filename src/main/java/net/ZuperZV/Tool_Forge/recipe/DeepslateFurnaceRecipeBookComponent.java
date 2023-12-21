package net.ZuperZV.Tool_Forge.recipe;

import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.world.item.Item;

import java.util.Set;

public class DeepslateFurnaceRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
    @Override
    protected Set<Item> getFuelItems() {
        return Set.of(ModItems.ECTOPLASM.get(), ModItems.SOUL_SHARD.get());
    }
}
