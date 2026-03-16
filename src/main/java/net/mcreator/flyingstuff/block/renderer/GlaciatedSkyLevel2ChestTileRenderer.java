package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GlaciatedSkyLevel2ChestTileRenderer extends GeoBlockRenderer<GlaciatedSkyLevel2ChestTileEntity> {
   public GlaciatedSkyLevel2ChestTileRenderer() {
      super(new GlaciatedSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(GlaciatedSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
