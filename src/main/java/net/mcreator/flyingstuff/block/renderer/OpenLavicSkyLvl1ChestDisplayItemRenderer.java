package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.OpenLavicSkyLvl1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.OpenLavicSkyLvl1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OpenLavicSkyLvl1ChestDisplayItemRenderer extends GeoItemRenderer<OpenLavicSkyLvl1ChestDisplayItem> {
   public OpenLavicSkyLvl1ChestDisplayItemRenderer() {
      super(new OpenLavicSkyLvl1ChestDisplayModel());
   }

   public RenderType getRenderType(OpenLavicSkyLvl1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
