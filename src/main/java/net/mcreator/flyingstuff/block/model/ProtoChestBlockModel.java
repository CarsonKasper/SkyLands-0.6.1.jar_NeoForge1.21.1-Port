package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ProtoChestBlockModel extends GeoModel<ProtoChestTileEntity> {
   public ResourceLocation getAnimationResource(ProtoChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/proto_chest.animation.json");
   }

   public ResourceLocation getModelResource(ProtoChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/proto_chest.geo.json");
   }

   public ResourceLocation getTextureResource(ProtoChestTileEntity animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/protochest.png");
   }
}
