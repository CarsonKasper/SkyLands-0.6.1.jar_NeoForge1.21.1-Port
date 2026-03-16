package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.world.features.LAUNCHER01FeatureFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModFeatures {
   public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, "flying_stuff");
   public static final RegistryObject<Feature<?>> LAUNCHER_01_FEATURE = REGISTRY.register("launcher_01_feature", LAUNCHER01FeatureFeature::new);
}

