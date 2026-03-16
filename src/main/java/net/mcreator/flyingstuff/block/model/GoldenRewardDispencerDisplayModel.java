package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.GoldenRewardDispencerDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GoldenRewardDispencerDisplayModel extends GeoModel<GoldenRewardDispencerDisplayItem> {
   public ResourceLocation getAnimationResource(GoldenRewardDispencerDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(GoldenRewardDispencerDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(GoldenRewardDispencerDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine.png");
   }
}
