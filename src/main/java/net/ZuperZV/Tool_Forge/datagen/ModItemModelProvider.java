package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tool_Forge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GILDED_NETHERITE_INGOT);
        simpleItem(ModItems.SOUL_STONE_INGOT);
        simpleItem(ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.GILDED_DIAMOND);
        simpleItem(ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE);

        simpleItem(ModItems.GILDED_GOLD);
        simpleItem(ModItems.RAW_GILDED_GOLD);
        simpleItem(ModItems.GILDED_GOLD_NUGGET);

        simpleItem(ModItems.BLADE_PATTERN);
        simpleItem(ModItems.GUARD_PATTERN);
        simpleItem(ModItems.STICK_PATTERN);
        simpleItem(ModItems.BLANK_PATTERN);

        simpleItem(ModItems.HELMET_PATTERN);
        simpleItem(ModItems.CHESTPLATE_PATTERN);
        simpleItem(ModItems.LEGGINGS_PATTERN);
        simpleItem(ModItems.BOOTS_PATTERN);

        simpleItem(ModItems.SOUL_STONE_BLADE);
        simpleItem(ModItems.SOUL_STONE_GUARD);
        simpleItem(ModItems.SOUL_STONE_STICK);

        handheldItem(ModItems.GILDED_NETHERITE_SWORD);
        handheldItem(ModItems.GILDED_NETHERITE_PICKAXE);
        handheldItem(ModItems.GILDED_NETHERITE_AXE);
        handheldItem(ModItems.GILDED_NETHERITE_SHOVEL);
        handheldItem(ModItems.GILDED_NETHERITE_HOE);

        handheldItem(ModItems.GILDED_DIAMOND_SWORD);
        handheldItem(ModItems.GILDED_DIAMOND_PICKAXE);
        handheldItem(ModItems.GILDED_DIAMOND_AXE);
        handheldItem(ModItems.GILDED_DIAMOND_SHOVEL);
        handheldItem(ModItems.GILDED_DIAMOND_HOE);

        handheldItem(ModItems.SOUL_STONE_SWORD);

        simpleItem(ModItems.ECTOPLASM);
        simpleItem(ModItems.SOUL_SHARD);

        simpleItem(ModItems.BISMUTH);
        simpleItem(ModItems.LILLIUM);

        simpleItem(ModItems.BISMUTH_CHESTPLATE);
        simpleItem(ModItems.BISMUTH_HELMET);
        simpleItem(ModItems.BISMUTH_BOOTS);
        simpleItem(ModItems.BISMUTH_LEGGINGS);

        complexBlock(ModBlocks.TOOL_STATION.get());
        complexBlock(ModBlocks.GOLDEN_EXPORTER.get());
        complexBlock(ModBlocks.ALLOY_PROCESSOR.get());
        complexBlock(ModBlocks.TOOL_FORGE.get());

        withExistingParent(ModItems.SOUL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }


    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(Tool_Forge.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Tool_Forge.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Tool_Forge.MOD_ID,"item/" + item.getId().getPath()));
    }
}
