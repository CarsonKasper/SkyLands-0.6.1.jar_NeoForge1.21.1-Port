package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.GlaciatedSkyLevel1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GlaciatedSkyLevel1ChestDisplayItemRenderer extends GeoItemRenderer<GlaciatedSkyLevel1ChestDisplayItem> {
   public GlaciatedSkyLevel1ChestDisplayItemRenderer() {
      super(new GlaciatedSkyLevel1ChestDisplayModel());
   }

   public RenderType getRenderType(GlaciatedSkyLevel1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
