package net.ZuperZV.Tool_Forge.block.entity;

import net.ZuperZV.Tool_Forge.item.ModItems;
import net.ZuperZV.Tool_Forge.recipe.DeepslateFurnaceRecipe;
import net.ZuperZV.Tool_Forge.screen.DeepslateFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class DeepslateFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private Map<Item, Integer> BURN_DURATION_MAP =
            Map.of(ModItems.ECTOPLASM.get(), 200,
                    ModItems.SOUL_SHARD.get(), 400);
    public DeepslateFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.DEPPSLATE_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, DeepslateFurnaceRecipe.Type.INSTANCE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.tool_forge.deepslate_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new DeepslateFurnaceMenu(pContainerId, pInventory, this, dataAccess);
    }

    @Override
    protected int getBurnDuration(ItemStack pFuel) {
        return BURN_DURATION_MAP.getOrDefault(pFuel.getItem(), 0);
    }
}
