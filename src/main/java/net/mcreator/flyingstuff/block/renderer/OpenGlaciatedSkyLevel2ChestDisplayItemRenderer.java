package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenGlaciatedSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<OpenGlaciatedSkyLevel2ChestDisplayItem> {
   public OpenGlaciatedSkyLevel2ChestDisplayItemRenderer() {
      super(new OpenGlaciatedSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(
      OpenGlaciatedSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick
   ) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
