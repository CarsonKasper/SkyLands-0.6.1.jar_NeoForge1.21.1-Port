package net.mcreator.flyingstuff.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;
import net.mcreator.flyingstuff.entity.model.IgneoRoboFelineModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IgneoRoboFelineRenderer extends GeoEntityRenderer<IgneoRoboFelineEntity> {
   public IgneoRoboFelineRenderer(Context renderManager) {
      super(renderManager, new IgneoRoboFelineModel());
      this.shadowRadius = 1.5F;
   }

   public RenderType getRenderType(IgneoRoboFelineEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      IgneoRoboFelineEntity entity,
      BakedGeoModel model,
      MultiBufferSource bufferSource,
      VertexConsumer buffer,
      boolean isReRender,
      float partialTick,
      int packedLight,
      int packedOverlay,
      float red,
      float green,
      float blue,
      float alpha
   ) {
      float scale = 1.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, -1);
   }

   protected float getDeathMaxRotation(IgneoRoboFelineEntity entityLivingBaseIn) {
      return 0.0F;
   }
}


