package com.carsonkasper.skylands;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class SkyLandsFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, SkyLandsMod.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, SkyLandsMod.MODID);

    public static final DeferredHolder<FluidType, FluidType> MOLTEN_METAL_TYPE = FLUID_TYPES.register("molten_metal", MoltenMetalFluidType::new);

    public static final DeferredHolder<Fluid, Fluid> MOLTEN_METAL = FLUIDS.register("molten_metal", () -> new BaseFlowingFluid.Source(moltenMetalProperties()));
    public static final DeferredHolder<Fluid, Fluid> FLOWING_MOLTEN_METAL = FLUIDS.register("flowing_molten_metal", () -> new BaseFlowingFluid.Flowing(moltenMetalProperties()));

    public static final DeferredBlock<LiquidBlock> MOLTEN_METAL_BLOCK = SkyLandsBlocks.BLOCKS.register("molten_metal", () -> new LiquidBlock(
        (net.minecraft.world.level.material.FlowingFluid) MOLTEN_METAL.get(),
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.FIRE)
            .strength(100.0F)
            .lightLevel(state -> 15)
            .replaceable()
            .noCollission()
            .noLootTable()
            .pushReaction(PushReaction.DESTROY)
            .sound(SoundType.EMPTY)
    ));

    public static final DeferredItem<Item> MOLTEN_METAL_BUCKET = SkyLandsBlocks.ITEMS.register("molten_metal_bucket", () -> new BucketItem(
        MOLTEN_METAL.get(),
        new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
    ));

    static {
        SkyLandsBlocks.CREATIVE_ORDER.add(MOLTEN_METAL_BUCKET);
    }

    private SkyLandsFluids() {
    }

    private static BaseFlowingFluid.Properties moltenMetalProperties() {
        return new BaseFlowingFluid.Properties(
            MOLTEN_METAL_TYPE::value,
            MOLTEN_METAL::value,
            FLOWING_MOLTEN_METAL::value
        )
            .bucket(MOLTEN_METAL_BUCKET::get)
            .block(MOLTEN_METAL_BLOCK::get)
            .explosionResistance(100.0F)
            .tickRate(8)
            .slopeFindDistance(8);
    }
}
