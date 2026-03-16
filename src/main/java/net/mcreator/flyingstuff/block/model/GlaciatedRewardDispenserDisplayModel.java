package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GlaciatedRewardDispenserDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GlaciatedRewardDispenserDisplayModel extends GeoModel<GlaciatedRewardDispenserDisplayItem> {
   public ResourceLocation getAnimationResource(GlaciatedRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(GlaciatedRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(GlaciatedRewardDispenserDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_ice.png");
   }
}
