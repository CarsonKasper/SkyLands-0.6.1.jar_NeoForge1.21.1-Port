package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenGoldenSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<OpenGoldenSkyLevel2ChestDisplayItem> {
   public OpenGoldenSkyLevel2ChestDisplayItemRenderer() {
      super(new OpenGoldenSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(OpenGoldenSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
