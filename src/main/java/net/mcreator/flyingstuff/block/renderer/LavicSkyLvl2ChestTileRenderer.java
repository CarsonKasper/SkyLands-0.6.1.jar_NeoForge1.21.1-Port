package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.LavicSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.model.LavicSkyLvl2ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LavicSkyLvl2ChestTileRenderer extends GeoBlockRenderer<LavicSkyLvl2ChestTileEntity> {
   public LavicSkyLvl2ChestTileRenderer() {
      super(new LavicSkyLvl2ChestBlockModel());
   }

   public RenderType getRenderType(LavicSkyLvl2ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
