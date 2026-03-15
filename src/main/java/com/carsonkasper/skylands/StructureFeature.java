package com.carsonkasper.skylands;

import com.mojang.serialization.Codec;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public final class StructureFeature extends Feature<StructureFeatureConfiguration> {
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
        StructureTemplateManager manager = level.getLevel().getStructureManager();
        StructureTemplate template = manager.get(config.structure()).orElse(null);
        if (template == null) {
            SkyLandsMod.LOGGER.warn("Missing structure template {}", config.structure());
            return false;
        }

        List<Block> ignored = config.ignoredBlocks().stream().map(Holder::value).toList();
        StructurePlaceSettings settings = new StructurePlaceSettings()
            .setRotation(rotation)
            .setMirror(mirror)
            .setRandom(random)
            .setIgnoreEntities(false)
            .addProcessor(new BlockIgnoreProcessor(ignored));
        boolean placed = template.placeInWorld(level, placePos, placePos, settings, random, 4);
        if (placed) {
            SkyLandsMod.LOGGER.info("Placed structure {} at {}", config.structure(), placePos);
        } else {
            SkyLandsMod.LOGGER.warn("Structure {} failed to place at {}", config.structure(), placePos);
        }
        return placed;
    }
}
