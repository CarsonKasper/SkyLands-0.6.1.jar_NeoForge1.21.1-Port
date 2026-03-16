package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLevel2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenGlaciatedSkyLevel2ChestTileRenderer extends GeoBlockRenderer<OpenGlaciatedSkyLevel2ChestTileEntity> {
   public OpenGlaciatedSkyLevel2ChestTileRenderer() {
      super(new OpenGlaciatedSkyLevel2ChestBlockModel());
   }

   public RenderType getRenderType(
      OpenGlaciatedSkyLevel2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick
   ) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
