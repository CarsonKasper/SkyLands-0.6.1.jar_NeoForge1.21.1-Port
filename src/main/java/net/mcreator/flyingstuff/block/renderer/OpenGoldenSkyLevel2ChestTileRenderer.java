package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenGoldenSkyLevel2ChestTileRenderer extends GeoBlockRenderer<OpenGoldenSkyLevel2ChestTileEntity> {
   public OpenGoldenSkyLevel2ChestTileRenderer() {
      super(new OpenGoldenSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(OpenGoldenSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
