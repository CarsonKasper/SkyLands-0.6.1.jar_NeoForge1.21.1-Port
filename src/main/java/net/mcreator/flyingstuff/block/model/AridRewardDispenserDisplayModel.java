package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.AridRewardDispenserDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AridRewardDispenserDisplayModel extends GeoModel<AridRewardDispenserDisplayItem> {
   public ResourceLocation getAnimationResource(AridRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(AridRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(AridRewardDispenserDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_arid.png");
   }
}
