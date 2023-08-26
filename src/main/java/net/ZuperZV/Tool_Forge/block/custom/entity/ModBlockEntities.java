package net.ZuperZV.Tool_Forge.block.custom.entity;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
             DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Tool_Forge.MOD_ID);

    public static final RegistryObject<BlockEntityType<ToolStationBlockEntity>> TOOL_STATION_BE =
            BLOCK_ENTITIES.register("tool_station_block_entity", () ->
                    BlockEntityType.Builder.of(ToolStationBlockEntity::new,
                            ModBlocks.T.))

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
