package net.mcreator.flyingstuff.fluid.types;

import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidType.Properties;

public class MoltenMetalFluidType extends FluidType {
   public MoltenMetalFluidType() {
      super(
         Properties.create()
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
            .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.LAVA_EXTINGUISH)
      );
   }

   public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
      consumer.accept(new IClientFluidTypeExtensions() {
         private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("flying_stuff:block/molten_metal_still");
         private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("flying_stuff:block/molten_metal_flow");

         public ResourceLocation getStillTexture() {
            return STILL_TEXTURE;
         }

         public ResourceLocation getFlowingTexture() {
            return FLOWING_TEXTURE;
         }
      });
   }
}

