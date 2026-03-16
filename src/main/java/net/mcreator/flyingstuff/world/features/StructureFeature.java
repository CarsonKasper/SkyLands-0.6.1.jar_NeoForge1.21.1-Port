package net.mcreator.flyingstuff.world.features;

import com.mojang.serialization.Codec;
import net.mcreator.flyingstuff.world.features.configurations.StructureFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber
public class StructureFeature extends Feature<StructureFeatureConfiguration> {
   public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, "flying_stuff");
   public static final RegistryObject<Feature<?>> STRUCTURE_FEATURE = REGISTRY.register(
      "structure_feature", () -> new StructureFeature(StructureFeatureConfiguration.CODEC)
   );

   public StructureFeature(Codec<StructureFeatureConfiguration> codec) {
      super(codec);
   }

   @Override
   public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
      return true;
   }
}

