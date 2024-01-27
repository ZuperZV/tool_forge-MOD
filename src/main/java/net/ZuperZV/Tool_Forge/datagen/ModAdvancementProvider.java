package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider  implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {

        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.TOOL_STATION.get()),
                        Component.literal("The Tool beginning"), Component.literal("everything is begging tools"),
                        new ResourceLocation(Tool_Forge.MOD_ID, "textures/block/dark_stone.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_tool_station", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.TOOL_STATION.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "tool_forge"), existingFileHelper);

        Advancement Wooden_Pick = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(Items.WOODEN_PICKAXE),
                        Component.literal("The Wooden Start"), Component.literal("wood is god to begging with"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_wooden_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WOODEN_PICKAXE))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "wooden_pickaxe"), existingFileHelper);

        Advancement Gilded_Blackstone = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(Blocks.GILDED_BLACKSTONE),
                        Component.literal("what is Gilded"), Component.literal("what can you use it for"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_gilded_blackstone", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GILDED_BLACKSTONE))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_blackstone"), existingFileHelper);

        Advancement Tools = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GILDED_GOLD.get()),
                        Component.literal("Gilded is better"), Component.literal("Gilded is as good as gold"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Gilded_Blackstone)
                .addCriterion("has_gilded_gold", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GILDED_GOLD.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_gold"), existingFileHelper);

        Advancement Gilded_Diamond = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GILDED_DIAMOND.get()),
                        Component.literal("Diamond but Gilded"), Component.literal("Gilded is a Diamond"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Tools)
                .addCriterion("has_gilded_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GILDED_DIAMOND.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_diamond"), existingFileHelper);

        Advancement Gilded_Netherite = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GILDED_NETHERITE_INGOT.get()),
                        Component.literal("Gilded Glory"), Component.literal("Netherite and Gilded"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Tools)
                .addCriterion("has_gilded_netherite", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GILDED_NETHERITE_INGOT.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_netherite"), existingFileHelper);

        Advancement Gilded_Netherite_Sword = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GILDED_NETHERITE_SWORD.get()),
                        Component.literal("Gilded Netherite Sword"), Component.literal("Sword not included with Gilded Netherite"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Gilded_Netherite)
                .addCriterion("has_gilded_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GILDED_NETHERITE_SWORD.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_netherite_sword"), existingFileHelper);

        Advancement Gilded_Diamond_Sword = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.GILDED_DIAMOND_SWORD.get()),
                        Component.literal("Gilded Diamond Sword"), Component.literal("The master sword"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Gilded_Diamond)
                .addCriterion("has_gilded_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GILDED_DIAMOND_SWORD.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "gilded_diamond_sword"), existingFileHelper);

        Advancement Soul_Stone = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.SOUL_STONE.get()),
                        Component.literal("A soul in a box"), Component.literal("Spooky Stone"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_soul_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SOUL_STONE.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone"), existingFileHelper);

        Advancement Soul_Stone_Sword = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.SOUL_STONE_SWORD.get()),
                        Component.literal("almost diamonds"), Component.literal("why are souls almost as strong as diamonds"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Soul_Stone)
                .addCriterion("has_soul_stone_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOUL_STONE_SWORD.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "soul_stone_sword"), existingFileHelper);

        Advancement Cobel_Soul_Stone = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModBlocks.COBEL_SOUL_STONE.get()),
                        Component.literal("Arr what are you think"), Component.literal("you can't just melt me"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(Soul_Stone)
                .addCriterion("has_soul_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COBEL_SOUL_STONE.get()))
                .save(saver, new ResourceLocation(Tool_Forge.MOD_ID, "cobel_soul_stone"), existingFileHelper);
    }
}
