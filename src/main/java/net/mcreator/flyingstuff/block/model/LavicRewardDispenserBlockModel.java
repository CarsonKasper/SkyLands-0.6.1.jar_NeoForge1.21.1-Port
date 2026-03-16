package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicRewardDispenserBlockModel extends GeoModel<LavicRewardDispenserTileEntity> {
   public ResourceLocation getAnimationResource(LavicRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(LavicRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(LavicRewardDispenserTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_lavic.png");
   }
}
