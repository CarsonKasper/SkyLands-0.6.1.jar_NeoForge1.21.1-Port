package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AridRewardDispenserBlockModel extends GeoModel<AridRewardDispenserTileEntity> {
   public ResourceLocation getAnimationResource(AridRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(AridRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(AridRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_arid.png");
   }
}
