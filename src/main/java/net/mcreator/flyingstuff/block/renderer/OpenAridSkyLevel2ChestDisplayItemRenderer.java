package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenAridSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<OpenAridSkyLevel2ChestDisplayItem> {
   public OpenAridSkyLevel2ChestDisplayItemRenderer() {
      super(new OpenAridSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(OpenAridSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
