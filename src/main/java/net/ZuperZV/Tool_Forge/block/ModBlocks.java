package net.ZuperZV.Tool_Forge.block;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.custom.ToolStationBlock;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tool_Forge.MOD_ID);


    public static final RegistryObject<Block> GILDED_GOLD_BLOCK = registerBlock("gilded_gold_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> TOOL_STATION = registerBlock("tool_station",
            () -> new ToolStationBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
