package net.mcreator.flyingstuff.block.model;

import net.mcreator.flyingstuff.block.display.LavicRewardDispenserDisplayItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LavicRewardDispenserDisplayModel extends GeoModel<LavicRewardDispenserDisplayItem> {
   public ResourceLocation getAnimationResource(LavicRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "animations/gambling_machine.animation.json");
   }

   public ResourceLocation getModelResource(LavicRewardDispenserDisplayItem animatable) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "geo/gambling_machine.geo.json");
   }

   public ResourceLocation getTextureResource(LavicRewardDispenserDisplayItem entity) {
      return ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/gambling_machine_lavic.png");
   }
}
