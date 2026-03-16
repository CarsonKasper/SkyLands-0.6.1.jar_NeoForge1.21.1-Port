package net.mcreator.flyingstuff.fluid;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModFluidTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties;

public abstract class MoltenMetalFluid extends BaseFlowingFluid {
   public static final Properties PROPERTIES = new Properties(
         () -> (FluidType)FlyingStuffModFluidTypes.MOLTEN_METAL_TYPE.get(),
         () -> (Fluid)FlyingStuffModFluids.MOLTEN_METAL.get(),
         () -> (Fluid)FlyingStuffModFluids.FLOWING_MOLTEN_METAL.get()
      )
      .explosionResistance(100.0F)
      .tickRate(8)
      .slopeFindDistance(8)
      .bucket(() -> (Item)FlyingStuffModItems.MOLTEN_METAL_BUCKET.get())
      .block(() -> (LiquidBlock)FlyingStuffModBlocks.MOLTEN_METAL.get());

   private MoltenMetalFluid() {
      super(PROPERTIES);
   }

   public static class Flowing extends MoltenMetalFluid {
      protected void createFluidStateDefinition(Builder<Fluid, FluidState> builder) {
         super.createFluidStateDefinition(builder);
         builder.add(LEVEL);
      }

      public int getAmount(FluidState state) {
         return (Integer)state.getValue(LEVEL);
      }

      public boolean isSource(FluidState state) {
         return false;
      }
   }

   public static class Source extends MoltenMetalFluid {
      public int getAmount(FluidState state) {
         return 8;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}

