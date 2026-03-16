package net.mcreator.flyingstuff.world.features;

import net.mcreator.flyingstuff.procedures.LAUNCHER01FeatureAdditionalGenerationConditionProcedure;
import net.mcreator.flyingstuff.world.features.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class LAUNCHER01FeatureFeature extends StructureFeature {
   public LAUNCHER01FeatureFeature() {
      super(StructureFeatureConfiguration.CODEC);
   }

   @Override
   public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
      WorldGenLevel world = context.level();
      int x = context.origin().getX();
      int y = context.origin().getY();
      int z = context.origin().getZ();
      return !LAUNCHER01FeatureAdditionalGenerationConditionProcedure.execute(world, x, y, z) ? false : super.place(context);
   }
}

