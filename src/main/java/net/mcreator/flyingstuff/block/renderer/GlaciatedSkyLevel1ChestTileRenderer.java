package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.GlaciatedSkyLevel1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GlaciatedSkyLevel1ChestTileRenderer extends GeoBlockRenderer<GlaciatedSkyLevel1ChestTileEntity> {
   public GlaciatedSkyLevel1ChestTileRenderer() {
      super(new GlaciatedSkyLevel1ChestBlockModel());
   }

   public RenderType getRenderType(GlaciatedSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
