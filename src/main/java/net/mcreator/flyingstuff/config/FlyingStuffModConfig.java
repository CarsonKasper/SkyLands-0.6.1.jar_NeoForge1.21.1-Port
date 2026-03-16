package net.mcreator.flyingstuff.config;

import java.util.HashMap;
import java.util.Map;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.mcreator.flyingstuff.config.serializer.GsonSerializer;
import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FlyingStuffModConfig {
   public static final GsonSerializer serializer = new GsonSerializer("SkyLands-ClientConfig");
   public static Map<String, Object> entries = new HashMap<>();

   public static ConfigBuilder getConfigBuilder() {
      ConfigBuilder builder = ConfigBuilder.create().setTitle(Component.literal("FlyingStuffMod Config"));
      ConfigEntryBuilder entryBuilder = builder.entryBuilder();
      builder.setTitle(Component.literal("Sky Lands Configuration"));
      builder.setDefaultBackgroundTexture(ResourceLocation.fromNamespaceAndPath("flying_stuff", "textures/block/skyrock.png"));
      builder.setShouldTabsSmoothScroll(true);
      builder.setShouldTabsSmoothScroll(true);
      ConfigCategory Clouds = builder.getOrCreateCategory(Component.literal("Clouds"));
      entries.putIfAbsent("CloudActiveBolean", true);
      FlyingStuffModVariables.CloudActiveBolean = entryBuilder.startBooleanToggle(
            Component.literal("Show The Custom Biome Clouds"), (Boolean)entries.get("CloudActiveBolean")
         )
         .setDefaultValue(true)
         .setTooltip(new Component[]{Component.literal("Could take some time for the cloud particles to despawn")})
         .setSaveConsumer(newValue -> entries.put("CloudActiveBolean", newValue))
         .build();
      Clouds.addEntry(FlyingStuffModVariables.CloudActiveBolean);
      entries.putIfAbsent("CloudActiveOutside", true);
      FlyingStuffModVariables.CloudActiveOutside = entryBuilder.startBooleanToggle(
            Component.literal("Show The Custom Clouds Outside Sky Biomes"), (Boolean)entries.get("CloudActiveOutside")
         )
         .setDefaultValue(true)
         .setTooltip(new Component[]{Component.literal("Could take some time for the cloud particles to despawn")})
         .setSaveConsumer(newValue -> entries.put("CloudActiveOutside", newValue))
         .build();
      Clouds.addEntry(FlyingStuffModVariables.CloudActiveOutside);
      entries.putIfAbsent("CloudDist", 256);
      FlyingStuffModVariables.CloudDist = entryBuilder.startIntSlider(
            Component.literal("Custom Cloud Render Distance (In blocks)"), Double.valueOf(String.valueOf(entries.get("CloudDist"))).intValue(), 64, 2048
         )
         .setDefaultValue(256)
         .setSaveConsumer(newValue -> entries.put("CloudDist", newValue))
         .build();
      Clouds.addEntry(FlyingStuffModVariables.CloudDist);
      entries.putIfAbsent("CloudBlockActive", true);
      FlyingStuffModVariables.CloudBlockActive = entryBuilder.startBooleanToggle(
            Component.literal("Show The Cloud Block Particles"), (Boolean)entries.get("CloudBlockActive")
         )
         .setDefaultValue(true)
         .setSaveConsumer(newValue -> entries.put("CloudBlockActive", newValue))
         .build();
      Clouds.addEntry(FlyingStuffModVariables.CloudBlockActive);
      builder.setSavingRunnable(() -> serializer.serialize(entries));
      return builder;
   }

   public static void setValue(String key, Object newValue) {
      entries.put(key, newValue);
      getConfigBuilder();
      serializer.serialize(entries);
   }
}
