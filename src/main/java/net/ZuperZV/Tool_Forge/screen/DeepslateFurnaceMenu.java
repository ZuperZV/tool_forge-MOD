package net.ZuperZV.Tool_Forge.screen;

import net.ZuperZV.Tool_Forge.recipe.DeepslateFurnaceRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class DeepslateFurnaceMenu extends AbstractFurnaceMenu {
    protected DeepslateFurnaceMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf friendlybytebuf) {
        this(pContainerId, pPlayerInventory);
    }

    public DeepslateFurnaceMenu(int pContainerId, Inventory pPlayerInventory, Container container, ContainerData data) {
        super(ModMenuTypes.DEEPSLATE_FURNACE_MENU.get(), DeepslateFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, container, data);
    }

    public DeepslateFurnaceMenu(int pContainerId, Inventory pPlayerInventory) {
        super(ModMenuTypes.DEEPSLATE_FURNACE_MENU.get(), DeepslateFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory);
    }
}
