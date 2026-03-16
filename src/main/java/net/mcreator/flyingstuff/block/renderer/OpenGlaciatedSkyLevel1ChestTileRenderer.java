package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLevel1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenGlaciatedSkyLevel1ChestTileRenderer extends GeoBlockRenderer<OpenGlaciatedSkyLevel1ChestTileEntity> {
   public OpenGlaciatedSkyLevel1ChestTileRenderer() {
      super(new OpenGlaciatedSkyLevel1ChestBlockModel());
   }

   public RenderType getRenderType(
      OpenGlaciatedSkyLevel1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick
   ) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
