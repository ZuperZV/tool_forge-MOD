package net.ZuperZV.Tool_Forge.datagen.loot;

import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GILDED_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        this.dropSelf(ModBlocks.LILLIUM_BLOCK.get());
        this.dropSelf(ModBlocks.DEEPSLATE_FURNACE.get());
        this.dropSelf(ModBlocks.TOOL_STATION.get());
        this.dropSelf(ModBlocks.ALLOY_PROCESSOR.get());

        this.add(ModBlocks.BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.BISMUTH_ENDSTONE_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ENDSTONE_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.DEPPSLATE_BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.DEPPSLATE_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.LILLIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.LILLIUM_ORE.get(), ModItems.LILLIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
