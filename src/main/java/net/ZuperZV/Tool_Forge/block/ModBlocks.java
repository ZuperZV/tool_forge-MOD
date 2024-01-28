package net.ZuperZV.Tool_Forge.block;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.custom.*;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tool_Forge.MOD_ID);



    public static final RegistryObject<Block> TOOL_STATION = registerBlock("tool_station",
            () -> new ToolStationBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES).noOcclusion()));
    public static final RegistryObject<Block> TOOL_FORGE = registerBlock("tool_forge",
            () -> new ToolForgeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES).noOcclusion()));

    public static final RegistryObject<Block> ALLOY_PROCESSOR = registerBlock("alloy_processor",
            () -> new AlloyProcessorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> GOLDEN_EXPORTER = registerBlock("golden_exporter",
            () -> new GoldenExporterBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));


    public static final RegistryObject<Block> GILDED_GOLD_BLOCK = registerBlock("gilded_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Block> DEEPSLATE_FURNACE = registerBlock("deepslate_furnace",
            () -> new DeepslateFurnace(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> SOUL_STONE = registerBlock("soul_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE = registerBlock("cobel_soul_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SOUL_STONE_BRICKS = registerBlock("soul_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_BRICKS = registerBlock("cobel_soul_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SOUL_STONE_BIG_BRICKS = registerBlock("soul_stone_big_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_BIG_BRICKS = registerBlock("cobel_soul_stone_big_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CHIESLED_SOUL_STONE = registerBlock("chiseled_soul_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> SOUL_STONE_STAIRS = registerBlock("soul_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SOUL_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_STAIRS = registerBlock("cobel_soul_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.COBEL_SOUL_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> SOUL_STONE_BIG_BRICKS_STAIRS = registerBlock("soul_stone_big_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.SOUL_STONE_BIG_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_BIG_BRICKS_STAIRS = registerBlock("cobel_soul_stone_big_bricks_stairs",
            () -> new StairBlock(() -> ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));

    public static final RegistryObject<Block> SOUL_STONE_SLAB = registerBlock("soul_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_SLAB = registerBlock("cobel_soul_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> SOUL_STONE_BIG_BRICKS_SLAB = registerBlock("soul_stone_big_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> COBEL_SOUL_STONE_BIG_BRICKS_SLAB = registerBlock("cobel_soul_stone_big_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));

    //bismuth
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
    public static final RegistryObject<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> DEPPSLATE_BISMUTH_ORE = registerBlock("deepslate_bismuth_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(1, 2)));
    public static final RegistryObject<Block> BISMUTH_ENDSTONE_ORE = registerBlock("bismuth_endstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    //lillium
    public static final RegistryObject<Block> LILLIUM_BLOCK = registerBlock("lillium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LILLIUM_ORE = registerBlock("lillium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(1, 2)));

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
