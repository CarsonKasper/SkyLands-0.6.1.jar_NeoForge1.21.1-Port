package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenGlaciatedSkyLvl2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenGlaciatedSkyLvl2ChestTileRenderer extends GeoBlockRenderer<OpenGlaciatedSkyLvl2ChestTileEntity> {
   public OpenGlaciatedSkyLvl2ChestTileRenderer() {
      super(new OpenGlaciatedSkyLvl2ChestBlockModel());
   }

   public RenderType getRenderType(OpenGlaciatedSkyLvl2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
