package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GoldenSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.GoldenSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GoldenSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<GoldenSkyLevel2ChestDisplayItem> {
   public GoldenSkyLevel2ChestDisplayItemRenderer() {
      super(new GoldenSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(GoldenSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
