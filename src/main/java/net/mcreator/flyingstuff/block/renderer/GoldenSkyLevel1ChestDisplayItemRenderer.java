package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GoldenSkyLevel1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.GoldenSkyLevel1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GoldenSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<GoldenSkyLevel1ChestDisplayItem> {
   public GoldenSkyLevel1ChestDisplayItemRenderer() {
      super(new GoldenSkyLevel1ChestDisplayModel());
   }

   public RenderType getRenderType(GoldenSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
