package net.mcreator.flyingstuff.block.renderer;

import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;
import net.mcreator.flyingstuff.block.model.AbyssalDoorBlockModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AbyssalDoorTileRenderer extends GeoBlockRenderer<AbyssalDoorTileEntity> {
   public AbyssalDoorTileRenderer() {
      super(new AbyssalDoorBlockModel());
   }

   public RenderType getRenderType(AbyssalDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityCutoutNoCull(this.getTextureLocation(animatable));
   }
}
