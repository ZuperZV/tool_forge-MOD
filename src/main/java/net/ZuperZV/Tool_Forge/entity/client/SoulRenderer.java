package net.ZuperZV.Tool_Forge.entity.client;

import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.entity.custom.SoulEntity;
import net.ZuperZV.Tool_Forge.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoulRenderer extends MobRenderer<SoulEntity, SoulModel<SoulEntity>> {
    private static final ResourceLocation SOUL_LOCATION = new ResourceLocation(Tool_Forge.MOD_ID,"textures/entity/soul.png");
    public SoulRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SoulModel<>(pContext.bakeLayer(ModModelLayers.SOUL_LAYER)), 1);
    }

    @Override
    public ResourceLocation getTextureLocation(SoulEntity pEntity) {
        return SOUL_LOCATION;
    }
}
