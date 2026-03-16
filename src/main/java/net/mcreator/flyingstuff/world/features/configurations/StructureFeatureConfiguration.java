package net.mcreator.flyingstuff.world.features.configurations;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record StructureFeatureConfiguration(
   ResourceLocation structure, boolean randomRotation, boolean randomMirror, HolderSet<Block> ignoredBlocks, Vec3i offset
) implements FeatureConfiguration {
   public static final Codec<StructureFeatureConfiguration> CODEC = Codec.unit(
      new StructureFeatureConfiguration(ResourceLocation.fromNamespaceAndPath("flying_stuff", "empty"), false, false, HolderSet.direct(), Vec3i.ZERO)
   );
}

