package net.custom.flyingstuff.world;

import com.mojang.datafixers.util.Pair;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class GoldenRegion extends Region {
   private static final ResourceKey<Biome> FLYING_ISLANDS = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "flying_islands")
   );
   private static final ResourceKey<Biome> GLACIATED_FLOATING_ISLANDS = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "glaciated_floating_islands")
   );
   private static final ResourceKey<Biome> LAVIC_FLOATING_ISLANDS = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "lavic_floating_islands")
   );
   private static final ResourceKey<Biome> ARID_FLOATING_ISLANDS = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "arid_floating_islands")
   );
   private static final ResourceKey<Biome> FLOATING_CHERRY_GROVE = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "floating_cherry_grove")
   );
   private static final ResourceKey<Biome> FLOATING_SWAMP = ResourceKey.create(
      Registries.BIOME, ResourceLocation.fromNamespaceAndPath("flying_stuff", "floating_swamp")
   );

   public GoldenRegion(ResourceLocation name, int weight) {
      super(name, RegionType.OVERWORLD, weight);
   }

   @Override
   public void addBiomes(Registry<Biome> registry, Consumer<Pair<ParameterPoint, ResourceKey<Biome>>> mapper) {
      this.addModifiedVanillaOverworldBiomes(
         mapper,
         builder -> {
            builder.replaceBiome(Biomes.PLAINS, FLYING_ISLANDS);
            builder.replaceBiome(Biomes.SUNFLOWER_PLAINS, FLYING_ISLANDS);
            builder.replaceBiome(Biomes.MEADOW, FLYING_ISLANDS);
            builder.replaceBiome(Biomes.ICE_SPIKES, GLACIATED_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.SNOWY_PLAINS, GLACIATED_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.BADLANDS, LAVIC_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.WOODED_BADLANDS, LAVIC_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.DESERT, ARID_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.ERODED_BADLANDS, ARID_FLOATING_ISLANDS);
            builder.replaceBiome(Biomes.CHERRY_GROVE, FLOATING_CHERRY_GROVE);
            builder.replaceBiome(Biomes.GROVE, FLOATING_CHERRY_GROVE);
            builder.replaceBiome(Biomes.SWAMP, FLOATING_SWAMP);
            builder.replaceBiome(Biomes.MANGROVE_SWAMP, FLOATING_SWAMP);
         }
      );
   }
}

