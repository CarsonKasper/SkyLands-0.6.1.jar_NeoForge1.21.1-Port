package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenAridSkyLevel0ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel0ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenAridSkyLevel0ChestDisplayItemRenderer extends GeoItemRenderer<OpenAridSkyLevel0ChestDisplayItem> {
   public OpenAridSkyLevel0ChestDisplayItemRenderer() {
      super(new OpenAridSkyLevel0ChestDisplayModel());
   }

   public RenderType getRenderType(OpenAridSkyLevel0ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
