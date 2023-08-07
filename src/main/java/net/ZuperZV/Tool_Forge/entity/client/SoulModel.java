package net.ZuperZV.Tool_Forge.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ZuperZV.Tool_Forge.entity.animations.ModAnimationDefinitions;
import net.ZuperZV.Tool_Forge.entity.custom.SoulEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import javax.swing.text.html.parser.Entity;

public class SoulModel<T extends SoulEntity> extends HierarchicalModel<T> {
	private final ModelPart Head;
	private final ModelPart back;

	public SoulModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.back = root.getChild("back");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -7.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(21, 0).addBox(2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-3.0F, -6.0F, 2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 15).addBox(1.0F, -6.0F, 2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(SoulEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.SOUL_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.SOUL_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Head;
	}
}