package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenAridSkyLevel0ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenAridSkyLevel0ChestTileRenderer extends GeoBlockRenderer<OpenAridSkyLevel0ChestTileEntity> {
   public OpenAridSkyLevel0ChestTileRenderer() {
      super(new OpenAridSkyLevel0ChestBlockModel());
   }

   public RenderType getRenderType(OpenAridSkyLevel0ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
