package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;
import net.mcreator.flyingstuff.block.model.WalkableAbyssalDoorBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WalkableAbyssalDoorTileRenderer extends GeoBlockRenderer<WalkableAbyssalDoorTileEntity> {
   public WalkableAbyssalDoorTileRenderer() {
      super(new WalkableAbyssalDoorBlockModel());
   }

   public RenderType getRenderType(WalkableAbyssalDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
