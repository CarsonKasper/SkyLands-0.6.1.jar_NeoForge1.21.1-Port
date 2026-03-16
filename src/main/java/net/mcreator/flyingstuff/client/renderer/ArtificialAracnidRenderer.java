package net.mcreator.flyingstuff.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.flyingstuff.entity.ArtificialAracnidEntity;
import net.mcreator.flyingstuff.entity.layer.ArtificialAracnidLayer;
import net.mcreator.flyingstuff.entity.model.ArtificialAracnidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ArtificialAracnidRenderer extends GeoEntityRenderer<ArtificialAracnidEntity> {
   public ArtificialAracnidRenderer(Context renderManager) {
      super(renderManager, new ArtificialAracnidModel());
      this.shadowRadius = 0.5F;
      this.addRenderLayer(new ArtificialAracnidLayer(this));
   }

   public RenderType getRenderType(ArtificialAracnidEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }

   public void preRender(
      PoseStack poseStack,
      ArtificialAracnidEntity entity,
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
}


