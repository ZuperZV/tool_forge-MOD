package net.ZuperZV.Tool_Forge.util;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items{

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Tool_Forge.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks{
        public static final TagKey<Block> NEEDS_GILDED_NETHERITE_TOOL = tag("needs_gilded_netherite_tool");

        public static final TagKey<Block> NEEDS_GILDED_DIAMOND_TOOL = tag("needs_gilded_diamond_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Tool_Forge.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }
}
