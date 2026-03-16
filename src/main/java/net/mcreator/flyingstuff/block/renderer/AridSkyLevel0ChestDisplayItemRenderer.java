package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.AridSkyLevel0ChestDisplayItem;
import net.mcreator.flyingstuff.block.model.AridSkyLevel0ChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AridSkyLevel0ChestDisplayItemRenderer extends GeoItemRenderer<AridSkyLevel0ChestDisplayItem> {
   public AridSkyLevel0ChestDisplayItemRenderer() {
      super(new AridSkyLevel0ChestDisplayModel());
   }

   public RenderType getRenderType(AridSkyLevel0ChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
