package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.model.LavicRewardDispenserBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LavicRewardDispenserTileRenderer extends GeoBlockRenderer<LavicRewardDispenserTileEntity> {
   public LavicRewardDispenserTileRenderer() {
      super(new LavicRewardDispenserBlockModel());
   }

   public RenderType getRenderType(LavicRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
