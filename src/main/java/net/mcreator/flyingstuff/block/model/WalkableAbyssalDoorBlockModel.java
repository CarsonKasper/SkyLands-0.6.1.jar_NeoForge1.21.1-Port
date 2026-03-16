package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WalkableAbyssalDoorBlockModel extends GeoModel<WalkableAbyssalDoorTileEntity> {
   public ResourceLocation getAnimationResource(WalkableAbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/abyssal_door.animation.json");
   }

   public ResourceLocation getModelResource(WalkableAbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/abyssal_door.geo.json");
   }

   public ResourceLocation getTextureResource(WalkableAbyssalDoorTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/abyssal_door.png");
   }
}
