package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.model.AridSkyLevel0ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AridSkyLevel0ChestTileRenderer extends GeoBlockRenderer<AridSkyLevel0ChestTileEntity> {
   public AridSkyLevel0ChestTileRenderer() {
      super(new AridSkyLevel0ChestBlockModel());
   }

   public RenderType getRenderType(AridSkyLevel0ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
