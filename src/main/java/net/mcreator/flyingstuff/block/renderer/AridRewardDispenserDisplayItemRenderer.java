package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.AridRewardDispenserDisplayItem;
import net.mcreator.flyingstuff.block.model.AridRewardDispenserDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AridRewardDispenserDisplayItemRenderer extends GeoItemRenderer<AridRewardDispenserDisplayItem> {
   public AridRewardDispenserDisplayItemRenderer() {
      super(new AridRewardDispenserDisplayModel());
   }

   public RenderType getRenderType(AridRewardDispenserDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
