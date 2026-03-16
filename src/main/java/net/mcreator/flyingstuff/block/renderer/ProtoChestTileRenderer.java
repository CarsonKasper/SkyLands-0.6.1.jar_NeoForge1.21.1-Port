package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;
import net.mcreator.flyingstuff.block.model.ProtoChestBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ProtoChestTileRenderer extends GeoBlockRenderer<ProtoChestTileEntity> {
   public ProtoChestTileRenderer() {
      super(new ProtoChestBlockModel());
   }

   public RenderType getRenderType(ProtoChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
