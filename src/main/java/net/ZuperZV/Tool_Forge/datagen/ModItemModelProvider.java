package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tool_Forge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GILDED_NETHERITE_INGOT);

        simpleItem(ModItems.GILDED_GOLD);
        simpleItem(ModItems.GILDED_GOLD_NUGGET);

        //simpleItem(ModItems.GILDED_NETHERITE_HELMET);
        //simpleItem(ModItems.GILDED_NETHERITE_CHESTPLATE);
        //simpleItem(ModItems.GILDED_NETHERITE_LEGGINGS);
        //simpleItem(ModItems.GILDED_NETHERITE_BOOTS);

        handheldItem(ModItems.GILDED_NETHERITE_SWORD);
        handheldItem(ModItems.GILDED_NETHERITE_PICKAXE);
        handheldItem(ModItems.GILDED_NETHERITE_AXE);
        handheldItem(ModItems.GILDED_NETHERITE_SHOVEL);
        handheldItem(ModItems.GILDED_NETHERITE_HOE);

        handheldItem(ModItems.ECTOPLASM);
        handheldItem(ModItems.SOUL_SHARD);

        withExistingParent(ModItems.SOUL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
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
