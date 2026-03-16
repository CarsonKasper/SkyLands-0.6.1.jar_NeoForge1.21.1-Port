package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.display.ProtoChestDisplayItem;
import net.mcreator.flyingstuff.block.model.ProtoChestDisplayModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ProtoChestDisplayItemRenderer extends GeoItemRenderer<ProtoChestDisplayItem> {
   public ProtoChestDisplayItemRenderer() {
      super(new ProtoChestDisplayModel());
   }

   public RenderType getRenderType(ProtoChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
