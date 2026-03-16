package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.LavicSkyLvl2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LavicSkyLvl2ChestDisplayItemRenderer extends GeoItemRenderer<LavicSkyLvl2ChestDisplayItem> {
   public LavicSkyLvl2ChestDisplayItemRenderer() {
      super(new LavicSkyLvl2ChestDisplayModel());
   }

   public RenderType getRenderType(LavicSkyLvl2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
