package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Tool_Forge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GILDED_GOLD_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_ENDSTONE_ORE.get())
                .add(ModBlocks.DEPPSLATE_BISMUTH_ORE.get())
                .add(ModBlocks.LILLIUM_ORE.get())
                .add(ModBlocks.ALLOY_PROCESSOR.get())
                .add(ModBlocks.TOOL_STATION.get())
                .add(ModBlocks.DEEPSLATE_FURNACE.get())
                .add(ModBlocks.SOUL_STONE.get())
                .add(ModBlocks.SOUL_STONE_BRICKS.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS.get())
                .add(ModBlocks.COBEL_SOUL_STONE.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get())

                .add(ModBlocks.SOUL_STONE_STAIRS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_STAIRS.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS.get())

                .add(ModBlocks.SOUL_STONE_SLAB.get())
                .add(ModBlocks.COBEL_SOUL_STONE_SLAB.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_ENDSTONE_ORE.get())
                .add(ModBlocks.DEPPSLATE_BISMUTH_ORE.get())
                .add(ModBlocks.LILLIUM_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GILDED_GOLD_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TOOL_STATION.get())
                .add(ModBlocks.ALLOY_PROCESSOR.get())
                .add(ModBlocks.DEEPSLATE_FURNACE.get())
                .add(ModBlocks.SOUL_STONE.get())
                .add(ModBlocks.SOUL_STONE_BRICKS.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS.get())
                .add(ModBlocks.COBEL_SOUL_STONE.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BRICKS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS.get())
                .add(ModBlocks.CHIESLED_SOUL_STONE.get())

                .add(ModBlocks.SOUL_STONE_STAIRS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_STAIRS.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS.get())

                .add(ModBlocks.SOUL_STONE_SLAB.get())
                .add(ModBlocks.COBEL_SOUL_STONE_SLAB.get())
                .add(ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB.get())
                .add(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}