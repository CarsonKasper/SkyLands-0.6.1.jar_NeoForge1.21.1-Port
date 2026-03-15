package com.carsonkasper.skylands;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public final class SkyIslandFeature extends Feature<NoneFeatureConfiguration> {
    private final SupplierPalette palette;

    public SkyIslandFeature(Codec<NoneFeatureConfiguration> codec, SupplierPalette palette) {
        super(codec);
        this.palette = palette;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin().above(30 + random.nextInt(70));
        int radius = 10 + random.nextInt(9);
        int height = 4 + random.nextInt(4);
        boolean placed = false;

        BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                double distance = (x * x + z * z) / (double) (radius * radius);
                if (distance > 1.0D) {
                    continue;
                }

                int columnHeight = Math.max(1, Mth.floor((1.0D - distance) * height) + random.nextInt(2));
                for (int y = -columnHeight; y <= 1; y++) {
                    cursor.set(origin.getX() + x, origin.getY() + y, origin.getZ() + z);
                    if (!level.isOutsideBuildHeight(cursor)) {
                        level.setBlock(cursor, chooseState(y, columnHeight, random), Block.UPDATE_CLIENTS);
                        placed = true;
                    }
                }

                if (random.nextFloat() < 0.05F) {
                    int dangling = 2 + random.nextInt(4);
                    for (int y = 1; y <= dangling; y++) {
                        cursor.set(origin.getX() + x, origin.getY() - columnHeight - y, origin.getZ() + z);
                        if (!level.isOutsideBuildHeight(cursor)) {
                            level.setBlock(cursor, palette.accent().get(), Block.UPDATE_CLIENTS);
                        }
                    }
                }
            }
        }

        if (placed && palette.cap().get() != Blocks.AIR.defaultBlockState()) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    double distance = (x * x + z * z) / (double) (radius * radius);
                    if (distance <= 0.85D && random.nextFloat() < 0.14F) {
                        cursor.set(origin.getX() + x, origin.getY() + 2, origin.getZ() + z);
                        if (level.isEmptyBlock(cursor)) {
                            level.setBlock(cursor, palette.cap().get(), Block.UPDATE_CLIENTS);
                        }
                    }
                }
            }
        }

        return placed;
    }

    private BlockState chooseState(int y, int columnHeight, RandomSource random) {
        if (y == 1) {
            return palette.top().get();
        }
        if (y >= -1) {
            return random.nextFloat() < 0.2F ? palette.midVariant().get() : palette.mid().get();
        }
        if (y <= -columnHeight + 1 && random.nextFloat() < 0.25F) {
            return palette.accent().get();
        }
        return palette.core().get();
    }

    public record SupplierPalette(
        Supplier<BlockState> top,
        Supplier<BlockState> mid,
        Supplier<BlockState> midVariant,
        Supplier<BlockState> core,
        Supplier<BlockState> accent,
        Supplier<BlockState> cap
    ) {
    }
}
