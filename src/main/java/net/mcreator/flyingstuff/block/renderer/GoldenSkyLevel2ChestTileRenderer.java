package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.GoldenSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldenSkyLevel2ChestTileRenderer extends GeoBlockRenderer<GoldenSkyLevel2ChestTileEntity> {
   public GoldenSkyLevel2ChestTileRenderer() {
      super(new GoldenSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(GoldenSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
