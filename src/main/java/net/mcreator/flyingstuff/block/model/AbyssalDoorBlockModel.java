package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AbyssalDoorBlockModel extends GeoModel<AbyssalDoorTileEntity> {
   public ResourceLocation getAnimationResource(AbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/abyssal_door.animation.json");
   }

   public ResourceLocation getModelResource(AbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/abyssal_door.geo.json");
   }

   public ResourceLocation getTextureResource(AbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/abyssal_door.png");
   }
}
