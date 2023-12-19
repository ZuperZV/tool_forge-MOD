package net.ZuperZV.Tool_Forge.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ZuperZV.Tool_Forge.block.entity.ToolStationBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import org.joml.Matrix4f;

    public class ToolStationBERenderer implements BlockEntityRenderer<ToolStationBlockEntity> {
        public ToolStationBERenderer (BlockEntityRendererProvider.Context pContext){

        }


        @Override
        public void render(ToolStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer,
                           int pPackedLight, int pPackedOverlay) {


            if(pBlockEntity.getTank() > 0 ){
                int fluidHeight = pBlockEntity.getTank();
                double correctFluidHeight =  fluidHeight*0.0006875 - 0.6875;


                pPoseStack.pushPose();
                pPoseStack.scale(1, 0.9375f, 1);
                pPoseStack.translate(0, correctFluidHeight, 0);




                Fluid f = pBlockEntity.FLUID_TANK.getFluid().getFluid();
                if (f != Fluids.EMPTY){

                    IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(f);

                    TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(fluidType.getStillTexture(f.defaultFluidState(), pBlockEntity.getLevel(), pBlockEntity.getBlockPos()));

                    float minU = sprite.getU0();

                    float minV = sprite.getV0();

                    int waterColor = fluidType.getTintColor(f.defaultFluidState(), pBlockEntity.getLevel(), pBlockEntity.getBlockPos());
                    float red = (waterColor >> 16 & 255) / 255F;
                    float green = (waterColor >> 8 & 255) / 255F;
                    float blue = (waterColor & 255) / 255F;

                    VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.translucent());

                    Matrix4f m = pPoseStack.last().pose();
                    vertexConsumer.vertex(m, (float)0, (float)1, (float)0).color(red, green, blue, 1f).uv(sprite.getU1(), minV).uv2(pPackedLight).normal(0, 5f, 0).endVertex();
                    vertexConsumer.vertex(m, (float)0, (float)1, (float)(1)).color(red, green, blue, 1f).uv(minU, minV).uv2(pPackedLight).normal(0, 5f, 0).endVertex();
                    vertexConsumer.vertex(m, (float)(1), (float)1, (float)(1)).color(red, green, blue, 1f).uv(minU, sprite.getV1()).uv2(pPackedLight).normal(0, 5f, 0).endVertex();
                    vertexConsumer.vertex(m, (float)(1), (float)1, (float)0).color(red, green, blue, 1f).uv(sprite.getU1(), sprite.getV1()).uv2(pPackedLight).normal(0, 5f, 0f).endVertex();
                    pPoseStack.popPose();
                }
            }
        }
    }
