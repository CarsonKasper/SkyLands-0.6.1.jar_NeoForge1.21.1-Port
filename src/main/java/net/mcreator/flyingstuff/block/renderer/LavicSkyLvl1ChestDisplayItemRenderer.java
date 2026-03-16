package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.LavicSkyLvl1ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.LavicSkyLvl1ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LavicSkyLvl1ChestDisplayItemRenderer extends GeoItemRenderer<LavicSkyLvl1ChestDisplayItem> {
   public LavicSkyLvl1ChestDisplayItemRenderer() {
      super(new LavicSkyLvl1ChestDisplayModel());
   }

   public RenderType getRenderType(LavicSkyLvl1ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
