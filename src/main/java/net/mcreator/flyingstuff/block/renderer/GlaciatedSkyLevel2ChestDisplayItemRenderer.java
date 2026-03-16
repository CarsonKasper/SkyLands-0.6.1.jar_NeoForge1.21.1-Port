package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GlaciatedSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<GlaciatedSkyLevel2ChestDisplayItem> {
   public GlaciatedSkyLevel2ChestDisplayItemRenderer() {
      super(new GlaciatedSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(GlaciatedSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
