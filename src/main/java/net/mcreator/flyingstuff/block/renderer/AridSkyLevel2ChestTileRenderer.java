package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.AridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.AridSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AridSkyLevel2ChestTileRenderer extends GeoBlockRenderer<AridSkyLevel2ChestTileEntity> {
   public AridSkyLevel2ChestTileRenderer() {
      super(new AridSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(AridSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
