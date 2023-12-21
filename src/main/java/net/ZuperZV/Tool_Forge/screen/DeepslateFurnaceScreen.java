package net.ZuperZV.Tool_Forge.screen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.recipe.DeepslateFurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DeepslateFurnaceScreen extends AbstractFurnaceScreen<DeepslateFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Tool_Forge.MOD_ID, "textures/gui/Deepslate_furnace.png");

    public DeepslateFurnaceScreen(DeepslateFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, new DeepslateFurnaceRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE);
    }
}
