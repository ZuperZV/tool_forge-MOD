package net.ZuperZV.Tool_Forge.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ZuperZV.Tool_Forge.Tool_Forge;
import net.ZuperZV.Tool_Forge.entity.custom.SoulEntity;
import net.ZuperZV.Tool_Forge.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoulRenderer extends MobRenderer<SoulEntity, SoulModel<SoulEntity>> {
    private static final ResourceLocation SOUL_LOCATION = new ResourceLocation(Tool_Forge.MOD_ID,"textures/entity/Soul.png");

    public SoulRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SoulModel<>(pContext.bakeLayer(ModModelLayers.SOUL_LAYER)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(SoulEntity pEntity) {
        return SOUL_LOCATION;
    }

    @Override
    public void render(SoulEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
