package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.GoldenSkyLevel1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GoldenSkyLevel1ChestTileRenderer extends GeoBlockRenderer<GoldenSkyLevel1ChestTileEntity> {
   public GoldenSkyLevel1ChestTileRenderer() {
      super(new GoldenSkyLevel1ChestBlockModel());
   }

   public RenderType getRenderType(GoldenSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
