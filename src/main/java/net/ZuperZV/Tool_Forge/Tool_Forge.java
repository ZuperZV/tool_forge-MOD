package net.ZuperZV.Tool_Forge;

import com.mojang.logging.LogUtils;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.ZuperZV.Tool_Forge.block.entity.ModBlockEntities;
import net.ZuperZV.Tool_Forge.entity.ModEntities;
import net.ZuperZV.Tool_Forge.entity.client.SoulRenderer;
import net.ZuperZV.Tool_Forge.item.ModItems;
import net.ZuperZV.Tool_Forge.loot.ModLootModifiers;
import net.ZuperZV.Tool_Forge.recipe.ModRecipes;
import net.ZuperZV.Tool_Forge.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Tool_Forge.MOD_ID)
public class Tool_Forge {
    public static final String MOD_ID = "tool_forge";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Tool_Forge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.GILDED_NETHERITE_INGOT);
            event.accept(ModItems.GILDED_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
            event.accept(ModItems.GILDED_DIAMOND);
            event.accept(ModItems.GILDED_DIAMOND_UPGRADE_SMITHING_TEMPLATE);

            event.accept(ModItems.GILDED_GOLD);
            event.accept(ModItems.RAW_GILDED_GOLD);

            event.accept(ModItems.BISMUTH);

            event.accept(ModItems.SOUL_STONE_BLADE);
            event.accept(ModItems.SOUL_STONE_GUARD);
            event.accept(ModItems.SOUL_STONE_STICK);

            event.accept(ModItems.BLANK_PATTERN);
            event.accept(ModItems.STICK_PATTERN);
            event.accept(ModItems.GUARD_PATTERN);

            event.accept(ModItems.HELMET_PATTERN);
            event.accept(ModItems.CHESTPLATE_PATTERN);
            event.accept(ModItems.LEGGINGS_PATTERN);
            event.accept(ModItems.BOOTS_PATTERN);

        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.GILDED_NETHERITE_SWORD);
            event.accept(ModItems.GILDED_NETHERITE_AXE);

            event.accept(ModItems.GILDED_NETHERITE_HELMET);
            event.accept(ModItems.GILDED_NETHERITE_CHESTPLATE);
            event.accept(ModItems.GILDED_NETHERITE_LEGGINGS);
            event.accept(ModItems.GILDED_NETHERITE_BOOTS);

            event.accept(ModItems.BISMUTH_HELMET);
            event.accept(ModItems.BISMUTH_CHESTPLATE);
            event.accept(ModItems.BISMUTH_LEGGINGS);
            event.accept(ModItems.BISMUTH_BOOTS);

            event.accept(ModItems.GILDED_DIAMOND_HELMET);
            event.accept(ModItems.GILDED_DIAMOND_CHESTPLATE);
            event.accept(ModItems.GILDED_DIAMOND_LEGGINGS);
            event.accept(ModItems.GILDED_DIAMOND_BOOTS);

            event.accept(ModItems.GILDED_DIAMOND_SWORD);
            event.accept(ModItems.GILDED_DIAMOND_AXE);

            event.accept(ModItems.BISMUTH_HELMET);
            event.accept(ModItems.BISMUTH_CHESTPLATE);
            event.accept(ModItems.BISMUTH_LEGGINGS);
            event.accept(ModItems.BISMUTH_BOOTS);

            event.accept(ModItems.SOUL_STONE_SWORD);



        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.GILDED_NETHERITE_PICKAXE);
            event.accept(ModItems.GILDED_NETHERITE_AXE);
            event.accept(ModItems.GILDED_NETHERITE_SHOVEL);
            event.accept(ModItems.GILDED_NETHERITE_HOE);

            event.accept(ModItems.GILDED_DIAMOND_PICKAXE);
            event.accept(ModItems.GILDED_DIAMOND_AXE);
            event.accept(ModItems.GILDED_DIAMOND_SHOVEL);
            event.accept(ModItems.GILDED_DIAMOND_HOE);

        }

        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.SOUL_SPAWN_EGG);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.TOOL_STATION);
            event.accept(ModBlocks.TOOL_FORGE);
            event.accept(ModBlocks.ALLOY_PROCESSOR);
            event.accept(ModBlocks.GOLDEN_EXPORTER);

        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SOUL_STONE_BRICKS);
            event.accept(ModBlocks.SOUL_STONE_BIG_BRICKS);
            event.accept(ModBlocks.COBEL_SOUL_STONE);
            event.accept(ModBlocks.COBEL_SOUL_STONE_BRICKS);
            event.accept(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS);
            event.accept(ModBlocks.SOUL_STONE);

            event.accept(ModBlocks.SOUL_STONE_STAIRS);
            event.accept(ModBlocks.COBEL_SOUL_STONE_STAIRS);
            event.accept(ModBlocks.SOUL_STONE_BIG_BRICKS_STAIRS);
            event.accept(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_STAIRS);

            event.accept(ModBlocks.SOUL_STONE_SLAB);
            event.accept(ModBlocks.COBEL_SOUL_STONE_SLAB);
            event.accept(ModBlocks.SOUL_STONE_BIG_BRICKS_SLAB);
            event.accept(ModBlocks.COBEL_SOUL_STONE_BIG_BRICKS_SLAB);

            event.accept(ModBlocks.CHIESLED_SOUL_STONE);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            //bismuth
            event.accept(ModBlocks.BISMUTH_ORE);
            event.accept(ModBlocks.BISMUTH_BLOCK);
            event.accept(ModBlocks.DEPPSLATE_BISMUTH_ORE);
            event.accept(ModBlocks.BISMUTH_ENDSTONE_ORE);
            //lillium
            event.accept(ModBlocks.LILLIUM_ORE);
            event.accept(ModBlocks.LILLIUM_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntities.SOUL.get(), SoulRenderer::new);

                MenuScreens.register(ModMenuTypes.TOOL_STATION_MENU.get(), ToolStationScreen::new);
                MenuScreens.register(ModMenuTypes.TOOL_FORGE_MENU.get(), ToolForgeScreen::new);
                MenuScreens.register(ModMenuTypes.ALLOY_PROCESSOR_MENU.get(), AlloyProcessorScreen::new);
                MenuScreens.register(ModMenuTypes.GOLDEN_EXPORTER_MENU.get(), GoldenExporterScreen::new);

                MenuScreens.register(ModMenuTypes.DEEPSLATE_FURNACE_MENU.get(), DeepslateFurnaceScreen::new);
            });
        }
    }
}
