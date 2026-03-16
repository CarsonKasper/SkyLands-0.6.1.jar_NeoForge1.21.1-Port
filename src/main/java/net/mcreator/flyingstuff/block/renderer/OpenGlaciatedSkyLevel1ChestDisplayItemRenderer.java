package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLevel1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLevel1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenGlaciatedSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<OpenGlaciatedSkyLevel1ChestDisplayItem> {
   public OpenGlaciatedSkyLevel1ChestDisplayItemRenderer() {
      super(new OpenGlaciatedSkyLevel1ChestDisplayModel());
   }

   public RenderType getRenderType(
      OpenGlaciatedSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick
   ) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
