package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenGlaciatedSkyLvl2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLvl2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenGlaciatedSkyLvl2ChestDisplayItemRenderer extends GeoItemRenderer<OpenGlaciatedSkyLvl2ChestDisplayItem> {
   public OpenGlaciatedSkyLvl2ChestDisplayItemRenderer() {
      super(new OpenGlaciatedSkyLvl2ChestDisplayModel());
   }

   public RenderType getRenderType(OpenGlaciatedSkyLvl2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
