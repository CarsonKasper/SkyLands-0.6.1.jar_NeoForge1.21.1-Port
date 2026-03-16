package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.AbyssalDoorDisplayItem;
import net.mcreator.flyingstuff.block.model.AbyssalDoorDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AbyssalDoorDisplayItemRenderer extends GeoItemRenderer<AbyssalDoorDisplayItem> {
   public AbyssalDoorDisplayItemRenderer() {
      super(new AbyssalDoorDisplayModel());
   }

   public RenderType getRenderType(AbyssalDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
