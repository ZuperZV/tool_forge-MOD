package net.ZuperZV.Tool_Forge.datagen;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.ZuperZV.Tool_Forge.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Tool_Forge.MOD_ID);
    }

    @Override
    protected void start() {

        /*add("raw_gilded_gold_from_gilded_blackstone", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("blocks/gilded_blackstone")).build() },
                ModItems.RAW_GILDED_GOLD.get()));
         */
        add("soul_stone_sword_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build() }, ModItems.SOUL_STONE_SWORD.get()));

        add("soul_stone_sword_from_simple_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build() }, ModItems.SOUL_STONE_SWORD.get()));

        add("gilded_diamond_upgrade_smithing_template_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.38f).build() }, ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()));

        add("gilded_diamond_upgrade_smithing_template_from_bastion_treasure", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.40f).build() }, ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE.get()));

        add("gilded_netherite_upgrade_smithing_template_from_nether_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.36f).build() }, ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}