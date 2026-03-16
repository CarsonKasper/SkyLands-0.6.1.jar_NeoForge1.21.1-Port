package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GoldenRewardDispencerDisplayItem;
import net.mcreator.flyingstuff.block.model.GoldenRewardDispencerDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GoldenRewardDispencerDisplayItemRenderer extends GeoItemRenderer<GoldenRewardDispencerDisplayItem> {
   public GoldenRewardDispencerDisplayItemRenderer() {
      super(new GoldenRewardDispencerDisplayModel());
   }

   public RenderType getRenderType(GoldenRewardDispencerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
