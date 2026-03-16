package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.ProtoChestDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ProtoChestDisplayModel extends GeoModel<ProtoChestDisplayItem> {
   public ResourceLocation getAnimationResource(ProtoChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/proto_chest.animation.json");
   }

   public ResourceLocation getModelResource(ProtoChestDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/proto_chest.geo.json");
   }

   public ResourceLocation getTextureResource(ProtoChestDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/protochest.png");
   }
}
