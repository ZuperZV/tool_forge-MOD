package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Tool_Forge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GILDED_GOLD_BLOCK);

        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.BISMUTH_ENDSTONE_ORE);
        blockWithItem(ModBlocks.DEPPSLATE_BISMUTH_ORE);

        blockWithItem(ModBlocks.SOUL_STONE);
        blockWithItem(ModBlocks.COBEL_SOUL_STONE);

        blockWithItem(ModBlocks.SOUL_STONE_BRICKS);
        blockWithItem(ModBlocks.SOUL_STONE_BIG_BRICKS);
        blockWithItem(ModBlocks.COBEL_SOUL_STONE_BRICKS);
        blockWithItem(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS);
        blockWithItem(ModBlocks.CHIESLED_SOUL_STONE);

        stairsBlock((StairBlock) ModBlocks.SOUL_STONE_STAIRS.get(), blockTexture(ModBlocks.SOUL_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.COBEL_SOUL_STONE_STAIRS.get(), blockTexture(ModBlocks.COBEL_SOUL_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS.get(), blockTexture(ModBlocks.SOUL_STONE_BIG_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS.get(), blockTexture(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get()));

        slabBlock(((SlabBlock) ModBlocks.SOUL_STONE_SLAB.get()), blockTexture(ModBlocks.SOUL_STONE.get()), blockTexture(ModBlocks.SOUL_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.COBEL_SOUL_STONE_SLAB.get()), blockTexture(ModBlocks.COBEL_SOUL_STONE.get()), blockTexture(ModBlocks.COBEL_SOUL_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get()), blockTexture(ModBlocks.SOUL_STONE_BIG_BRICKS.get()), blockTexture(ModBlocks.SOUL_STONE_BIG_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB.get()), blockTexture(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get()), blockTexture(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get()));

        blockItem(ModBlocks.SOUL_STONE_STAIRS);
        blockItem(ModBlocks.COBEL_SOUL_STONE_STAIRS);
        blockItem(ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS);
        blockItem(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS);

        blockItem(ModBlocks.SOUL_STONE_SLAB);
        blockItem(ModBlocks.COBEL_SOUL_STONE_SLAB);
        blockItem(ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB);
        blockItem(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB);

        blockWithItem(ModBlocks.LILLIUM_BLOCK);
        blockWithItem(ModBlocks.LILLIUM_ORE);

        //blockWithItem(ModBlocks.ALLOY_PROCESSOR);
        simpleBlock(ModBlocks.TOOL_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tool_station")));
        simpleBlock(ModBlocks.TOOL_FORGE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tool_forge")));
        simpleBlock(ModBlocks.GOLDEN_EXPORTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/golden_exporter")));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tool_forge:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}