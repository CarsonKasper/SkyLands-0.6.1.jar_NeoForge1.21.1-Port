package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenGoldenSkyLevel1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenGoldenSkyLevel1ChestTileRenderer extends GeoBlockRenderer<OpenGoldenSkyLevel1ChestTileEntity> {
   public OpenGoldenSkyLevel1ChestTileRenderer() {
      super(new OpenGoldenSkyLevel1ChestBlockModel());
   }

   public RenderType getRenderType(OpenGoldenSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
