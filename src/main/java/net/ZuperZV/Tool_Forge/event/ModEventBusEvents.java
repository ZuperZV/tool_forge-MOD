package net.ZuperZV.Tool_Forge.event;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.entity.ModEntities;
import net.ZuperZV.Tool_Forge.entity.client.SoulModel;
import net.ZuperZV.Tool_Forge.entity.custom.SoulEntity;
import net.ZuperZV.Tool_Forge.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tool_Forge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SOUL_LAYER, SoulModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SOUL.get(), SoulEntity.createAttributes().build());
    }

}
