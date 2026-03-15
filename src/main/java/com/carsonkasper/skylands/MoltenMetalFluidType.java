package com.carsonkasper.skylands;

import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

public final class MoltenMetalFluidType extends FluidType {
    private static final ResourceLocation STILL_TEXTURE = ResourceLocation.fromNamespaceAndPath(SkyLandsMod.MODID, "block/molten_metal_still");
    private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.fromNamespaceAndPath(SkyLandsMod.MODID, "block/molten_metal_flow");

    public MoltenMetalFluidType() {
        super(FluidType.Properties.create()
            .canSwim(false)
            .canDrown(false)
            .pathType(PathType.LAVA)
            .adjacentPathType(null)
            .motionScale(0.0035)
            .lightLevel(15)
            .density(1104)
            .viscosity(840)
            .temperature(30000)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }

            @Override
            public int getTintColor() {
                return 0xFFFFFFFF;
            }
        });
    }
}
