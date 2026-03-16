package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenGoldenSkyLevel1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenGoldenSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<OpenGoldenSkyLevel1ChestDisplayItem> {
   public OpenGoldenSkyLevel1ChestDisplayItemRenderer() {
      super(new OpenGoldenSkyLevel1ChestDisplayModel());
   }

   public RenderType getRenderType(OpenGoldenSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
