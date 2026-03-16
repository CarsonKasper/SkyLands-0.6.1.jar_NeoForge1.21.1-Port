package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenAridSkyLevel2ChestTileRenderer extends GeoBlockRenderer<OpenAridSkyLevel2ChestTileEntity> {
   public OpenAridSkyLevel2ChestTileRenderer() {
      super(new OpenAridSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(OpenAridSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
