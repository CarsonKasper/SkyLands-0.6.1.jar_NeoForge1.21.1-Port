package com.carsonkasper.skylands;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class SkyLandsFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, SkyLandsMod.MODID);
    public static final DeferredHolder<Feature<?>, Feature<?>> STRUCTURE_FEATURE = register("structure_feature", new StructureFeature(StructureFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, Feature<?>> FLYING_ISLAND = register(
        "flying_island",
        new SkyIslandFeature(
            NoneFeatureConfiguration.CODEC,
            new SkyIslandFeature.SupplierPalette(
                () -> SkyLandsBlocks.MOSSY_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.TILED_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.COBBLED_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.SKYROCK_WALL.get().defaultBlockState(),
                Blocks.AIR::defaultBlockState
            )
        )
    );
    public static final DeferredHolder<Feature<?>, Feature<?>> ARID_ISLAND = register(
        "arid_island",
        new SkyIslandFeature(
            NoneFeatureConfiguration.CODEC,
            new SkyIslandFeature.SupplierPalette(
                () -> SkyLandsBlocks.SKY_SAND.get().defaultBlockState(),
                () -> SkyLandsBlocks.SKY_SANDSTONE.get().defaultBlockState(),
                () -> SkyLandsBlocks.CHISELED_SKY_SANDSTONE.get().defaultBlockState(),
                () -> SkyLandsBlocks.SKY_SANDSTONE_BRICKS.get().defaultBlockState(),
                () -> SkyLandsBlocks.SKY_SANDSTONE_WALL.get().defaultBlockState(),
                Blocks.DEAD_BUSH::defaultBlockState
            )
        )
    );
    public static final DeferredHolder<Feature<?>, Feature<?>> GLACIATED_ISLAND = register(
        "glaciated_island",
        new SkyIslandFeature(
            NoneFeatureConfiguration.CODEC,
            new SkyIslandFeature.SupplierPalette(
                () -> SkyLandsBlocks.GLACIATED_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.MOSSY_GLACIATED_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.GLACIATED_SKYROCK_BRICKS.get().defaultBlockState(),
                () -> SkyLandsBlocks.COBBLED_GLACIATED_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.GLACIATED_SKYROCK_WALL.get().defaultBlockState(),
                Blocks.SNOW::defaultBlockState
            )
        )
    );
    public static final DeferredHolder<Feature<?>, Feature<?>> LAVIC_ISLAND = register(
        "lavic_island",
        new SkyIslandFeature(
            NoneFeatureConfiguration.CODEC,
            new SkyIslandFeature.SupplierPalette(
                () -> SkyLandsBlocks.SULFUR_SAND.get().defaultBlockState(),
                () -> SkyLandsBlocks.LAVIC_SKYROCK.get().defaultBlockState(),
                () -> SkyLandsBlocks.LAVIC_SKYROCK_TILES.get().defaultBlockState(),
                () -> SkyLandsBlocks.LAVIC_SKYROCK_BRICKS.get().defaultBlockState(),
                () -> SkyLandsBlocks.LAVIC_SKYROCK_WALLS.get().defaultBlockState(),
                Blocks.LAVA::defaultBlockState
            )
        )
    );

    private SkyLandsFeatures() {
    }

    private static DeferredHolder<Feature<?>, Feature<?>> register(String name, Feature<?> feature) {
        return FEATURES.register(name, () -> feature);
    }
}
