package net.mcreator.flyingstuff.world.features;

import com.mojang.serialization.Codec;
import java.util.concurrent.atomic.AtomicInteger;
import net.mcreator.flyingstuff.world.features.configurations.StructureFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StructureFeature extends Feature<StructureFeatureConfiguration> {
   private static final Logger LOGGER = LogManager.getLogger(StructureFeature.class);
   private static final AtomicInteger DEBUG_LOG_BUDGET = new AtomicInteger(24);
   public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, "flying_stuff");
   public static final RegistryObject<Feature<?>> STRUCTURE_FEATURE = REGISTRY.register(
      "structure_feature", () -> new StructureFeature(StructureFeatureConfiguration.CODEC)
   );

   public StructureFeature(Codec<StructureFeatureConfiguration> codec) {
      super(codec);
   }

   @Override
   public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
      RandomSource random = context.random();
      WorldGenLevel level = context.level();
      StructureFeatureConfiguration config = context.config();
      Rotation rotation = config.randomRotation() ? Rotation.getRandom(random) : Rotation.NONE;
      Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(2)] : Mirror.NONE;
      BlockPos placePos = context.origin().offset(config.offset());
      StructureTemplateManager structureManager = level.getLevel().getServer().getStructureManager();
      StructureTemplate template = structureManager.getOrCreate(config.structure());
      if (template == null) {
         logDebug("missing template " + config.structure() + " at " + placePos);
         return false;
      }

      StructurePlaceSettings placeSettings = new StructurePlaceSettings()
         .setRotation(rotation)
         .setMirror(mirror)
         .setRandom(random)
         .setKnownShape(false)
         .addProcessor(new BlockIgnoreProcessor(config.ignoredBlocks().stream().map(Holder::value).toList()));
      boolean placed = template.placeInWorld(level, placePos, placePos, placeSettings, random, 4);
      logDebug("template=" + config.structure() + " origin=" + context.origin() + " place=" + placePos + " placed=" + placed);
      return placed;
   }

   private static void logDebug(String message) {
      if (DEBUG_LOG_BUDGET.getAndDecrement() > 0) {
         LOGGER.info("[StructureFeature] {}", message);
      }
   }
}

