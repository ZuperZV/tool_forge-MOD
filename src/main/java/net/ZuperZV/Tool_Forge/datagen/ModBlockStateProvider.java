package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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

        blockWithItem(ModBlocks.LILLIUM_BLOCK);
        blockWithItem(ModBlocks.LILLIUM_ORE);

        //blockWithItem(ModBlocks.ALLOY_PROCESSOR);
        simpleBlock(ModBlocks.TOOL_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tool_station")));
        simpleBlock(ModBlocks.GOLDEN_EXPORTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/golden_extracer")));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tool_forge:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}