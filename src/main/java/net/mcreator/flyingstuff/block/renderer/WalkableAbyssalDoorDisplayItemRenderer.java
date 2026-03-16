package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.WalkableAbyssalDoorDisplayItem;
import net.mcreator.flyingstuff.block.model.WalkableAbyssalDoorDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WalkableAbyssalDoorDisplayItemRenderer extends GeoItemRenderer<WalkableAbyssalDoorDisplayItem> {
   public WalkableAbyssalDoorDisplayItemRenderer() {
      super(new WalkableAbyssalDoorDisplayModel());
   }

   public RenderType getRenderType(WalkableAbyssalDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
