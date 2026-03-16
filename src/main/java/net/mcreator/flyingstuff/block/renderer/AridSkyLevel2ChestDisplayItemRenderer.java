package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.AridSkyLevel2ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.AridSkyLevel2ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AridSkyLevel2ChestDisplayItemRenderer extends GeoItemRenderer<AridSkyLevel2ChestDisplayItem> {
   public AridSkyLevel2ChestDisplayItemRenderer() {
      super(new AridSkyLevel2ChestDisplayModel());
   }

   public RenderType getRenderType(AridSkyLevel2ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
