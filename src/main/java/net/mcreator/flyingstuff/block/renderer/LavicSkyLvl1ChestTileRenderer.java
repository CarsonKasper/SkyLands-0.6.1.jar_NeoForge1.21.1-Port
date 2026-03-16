package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.LavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.model.LavicSkyLvl1ChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LavicSkyLvl1ChestTileRenderer extends GeoBlockRenderer<LavicSkyLvl1ChestTileEntity> {
   public LavicSkyLvl1ChestTileRenderer() {
      super(new LavicSkyLvl1ChestBlockModel());
   }

   public RenderType getRenderType(LavicSkyLvl1ChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
