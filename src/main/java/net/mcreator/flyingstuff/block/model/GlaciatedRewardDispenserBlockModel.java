package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedRewardDispenserBlockModel extends GeoModel<GlaciatedRewardDispenserTileEntity> {
   public ResourceLocation getAnimationResource(GlaciatedRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_ice.png");
   }
}
