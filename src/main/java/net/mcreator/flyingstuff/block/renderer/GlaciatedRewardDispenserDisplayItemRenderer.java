package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GlaciatedRewardDispenserDisplayItem;
import net.mcreator.flyingstuff.block.model.GlaciatedRewardDispenserDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GlaciatedRewardDispenserDisplayItemRenderer extends GeoItemRenderer<GlaciatedRewardDispenserDisplayItem> {
   public GlaciatedRewardDispenserDisplayItemRenderer() {
      super(new GlaciatedRewardDispenserDisplayModel());
   }

   public RenderType getRenderType(GlaciatedRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
