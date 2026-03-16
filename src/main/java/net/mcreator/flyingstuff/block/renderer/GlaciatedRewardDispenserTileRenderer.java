package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.model.GlaciatedRewardDispenserBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GlaciatedRewardDispenserTileRenderer extends GeoBlockRenderer<GlaciatedRewardDispenserTileEntity> {
   public GlaciatedRewardDispenserTileRenderer() {
      super(new GlaciatedRewardDispenserBlockModel());
   }

   public RenderType getRenderType(GlaciatedRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
