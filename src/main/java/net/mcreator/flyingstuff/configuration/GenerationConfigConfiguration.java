package net.mcreator.flyingstuff.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.Builder;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public class GenerationConfigConfiguration {
   public static final Builder BUILDER = new Builder();
   public static final ModConfigSpec SPEC = BUILDER.build();
   public static final ConfigValue<Double> SKY_BIOMES_WEIGHT = BUILDER.define("Sky Biomes Generation Weight", 2.0);

   static {
      BUILDER.push("BiomeRarity");
      BUILDER.pop();
   }
}
