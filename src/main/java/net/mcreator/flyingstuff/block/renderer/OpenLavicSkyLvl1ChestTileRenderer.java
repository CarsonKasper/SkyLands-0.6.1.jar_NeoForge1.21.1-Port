package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.OpenLavicSkyLvl1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class OpenLavicSkyLvl1ChestTileRenderer extends GeoBlockRenderer<OpenLavicSkyLvl1ChestTileEntity> {
   public OpenLavicSkyLvl1ChestTileRenderer() {
      super(new OpenLavicSkyLvl1ChestBlockModel());
   }

   public RenderType getRenderType(OpenLavicSkyLvl1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
