package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.LavicRewardDispenserDisplayItem;
import net.mcreator.flyingstuff.block.model.LavicRewardDispenserDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LavicRewardDispenserDisplayItemRenderer extends GeoItemRenderer<LavicRewardDispenserDisplayItem> {
   public LavicRewardDispenserDisplayItemRenderer() {
      super(new LavicRewardDispenserDisplayModel());
   }

   public RenderType getRenderType(LavicRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
