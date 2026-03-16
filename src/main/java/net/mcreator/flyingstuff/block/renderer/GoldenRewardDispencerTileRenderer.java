package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;
import net.mcreator.flyingstuff.block.model.GoldenRewardDispencerBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldenRewardDispencerTileRenderer extends GeoBlockRenderer<GoldenRewardDispencerTileEntity> {
   public GoldenRewardDispencerTileRenderer() {
      super(new GoldenRewardDispencerBlockModel());
   }

   public RenderType getRenderType(GoldenRewardDispencerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
