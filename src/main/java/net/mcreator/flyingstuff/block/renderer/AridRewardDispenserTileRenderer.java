package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.model.AridRewardDispenserBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AridRewardDispenserTileRenderer extends GeoBlockRenderer<AridRewardDispenserTileEntity> {
   public AridRewardDispenserTileRenderer() {
      super(new AridRewardDispenserBlockModel());
   }

   public RenderType getRenderType(AridRewardDispenserTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
