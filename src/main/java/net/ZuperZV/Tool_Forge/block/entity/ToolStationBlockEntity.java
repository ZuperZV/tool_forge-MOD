package net.ZuperZV.Tool_Forge.block.entity;

import net.ZuperZV.Tool_Forge.block.custom.ToolStationBlock;
import net.ZuperZV.Tool_Forge.recipe.ToolStationRecipe;
import net.ZuperZV.Tool_Forge.screen.ToolStationMenu;
import net.ZuperZV.Tool_Forge.util.InventoryDirectionEntry;
import net.ZuperZV.Tool_Forge.util.InventoryDirectionWrapper;
import net.ZuperZV.Tool_Forge.util.WrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ToolStationBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(5) {


        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1, 2, 3 -> true;
                case 4 -> false;
                default -> super.isItemValid(slot, stack);

            };
        }
    };



    private static final int FLUID_INPUT_SLOT = 0;
    private static final int INPUT_SLOT = 1;
    private static final int UPGRADE_ITEM_SLOT = 2;
    private static final int UPGRADE_SLOT = 3;
    private static final int OUTPUT_SLOT = 4;


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, OUTPUT_SLOT, false),
                    new InventoryDirectionEntry(Direction.NORTH, FLUID_INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, UPGRADE_ITEM_SLOT, true),
                    new InventoryDirectionEntry(Direction.EAST, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.WEST, UPGRADE_SLOT, true),
                    new InventoryDirectionEntry(Direction.UP, FLUID_INPUT_SLOT, true)).directionsMap;




    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;
    private final int DEFAULT_MAX_PROGRESS = 79;

    private FluidStack neededFluidStack = FluidStack.EMPTY;

    public final FluidTank FLUID_TANK = createFluidTank();

    public FluidTank createFluidTank() {
        return new FluidTank(6000) {
            @Override
            protected void onContentsChanged() {
                setChanged();
                if(!level.isClientSide()) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isFluidValid(FluidStack stack) {
                return true;
            }
        };
    }




    public ItemStack getRenderStack() {
        ItemStack stack = itemHandler.getStackInSlot(OUTPUT_SLOT);

        if (stack.isEmpty()) {
            stack = itemHandler.getStackInSlot(UPGRADE_ITEM_SLOT);
        }

        return stack;
    }




    public ToolStationBlockEntity(BlockPos pPos, BlockState pBlockState, @Nullable FluidTank fluidTank) {
        super(ModBlockEntities.TOOL_STATION_BE.get(), pPos, pBlockState);
        this.fluidTank = fluidTank;
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> ToolStationBlockEntity.this.progress;
                    case 1 -> ToolStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 2 ->ToolStationBlockEntity.this.progress = pValue;
                    case 0 ->ToolStationBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }


    FluidStack fluid = FLUID_TANK.getFluid();

    public FluidStack getFluid() {
        return FLUID_TANK.getFluid();
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Tool Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ToolStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(ToolStationBlock.FACING);

                if(side == Direction.DOWN ||side == Direction.UP) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("tool_station.progress", progress);
        pTag.putInt("tool_station.max_progress", maxProgress);
        neededFluidStack.writeToNBT(pTag);

        pTag = FLUID_TANK.writeToNBT(pTag);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("tool_station.progress");
        maxProgress = pTag.getInt("tool_station.max_progress");
        neededFluidStack = FluidStack.loadFluidStackFromNBT(pTag);
        FLUID_TANK.readFromNBT(pTag);

    }

    @Nullable
    public final FluidTank getFluidTank() {
        return fluidTank;
    }

    @Nullable
    private final FluidTank fluidTank;


    //called when a player uses the block entity, before menu is may open.


    /*
    @Override
    public InteractionResult onBlockEntityUsed(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // TODO: Not a fan of the MachineFluidTank having actiions like this.
        //       I want to review the tank in its entirety after alpha release.
        return ((MachineFluidTank) getFluidTankNN()).onClickedWithPotentialFluidItem(player, hand);
    }
     */


    protected final FluidTank getFluidTankNN() {
        return Objects.requireNonNull(fluidTank);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        fillUpOnFluid();

        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            increaseCraftingProcess();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                extractFluid();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void extractFluid() {
        this.FLUID_TANK.drain(neededFluidStack.getAmount(), IFluidHandler.FluidAction.EXECUTE);
    }

    private void fillUpOnFluid() {
        if(hasFluidSourceInSlot(FLUID_INPUT_SLOT)) {
            transferItemFluidToTank(FLUID_INPUT_SLOT);
        }
    }

    private void transferItemFluidToTank(int fluidInputSlot) {
        this.itemHandler.getStackInSlot(fluidInputSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(iFluidHandlerItem -> {
            int drainAmount = Math.min(this.FLUID_TANK.getSpace(), 1000);

            FluidStack stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
            stack = iFluidHandlerItem.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
            fillTankWithFluid(stack, iFluidHandlerItem.getContainer());
        });
    }

    private void fillTankWithFluid(FluidStack stack, ItemStack container) {
        this.FLUID_TANK.fill(new FluidStack(stack.getFluid(), stack.getAmount()), IFluidHandler.FluidAction.EXECUTE);

        this.itemHandler.extractItem(FLUID_INPUT_SLOT, 1, false);
        this.itemHandler.insertItem(FLUID_INPUT_SLOT, container, false);
    }

    private boolean hasFluidSourceInSlot(int fluidInputSlot) {
        return this.itemHandler.getStackInSlot(fluidInputSlot).getCount() > 0 &&
                this.itemHandler.getStackInSlot(fluidInputSlot).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }

    private void craftItem() {
        Optional<ToolStationRecipe> recipe = getCurrentRecipe();
        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        ItemStack originalItem = this.itemHandler.getStackInSlot(UPGRADE_ITEM_SLOT);
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.extractItem(UPGRADE_ITEM_SLOT, 1, false);
        this.itemHandler.extractItem(UPGRADE_SLOT, 1, false);

        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(originalItem);

        ItemStack newItem = new ItemStack(resultItem.getItem(), resultItem.getCount());
        newItem.setTag(originalItem.getOrCreateTag().copy());

        EnchantmentHelper.setEnchantments(enchantments, newItem);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, newItem);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<ToolStationRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        maxProgress = recipe.get().getCraftTime();
        neededFluidStack = recipe.get().getFluidStack();


        ItemStack resultItem = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(resultItem.getCount())
                && canInsertItemIntoOutputSlot(resultItem.getItem())
                && hasEnoughFluidToCraft();
    }



    private boolean hasEnoughFluidToCraft() {
        return this.FLUID_TANK.getFluidAmount() >= neededFluidStack.getAmount();
    }

    private Optional<ToolStationRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(ToolStationRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }



    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }



    public FluidStack getFluidStack() {
        return FLUID_TANK.getFluid();
    }
}
