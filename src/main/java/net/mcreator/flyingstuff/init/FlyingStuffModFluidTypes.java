package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.fluid.types.MoltenMetalFluidType;
import net.neoforged.neoforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class FlyingStuffModFluidTypes {
   public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(Keys.FLUID_TYPES, "flying_stuff");
   public static final RegistryObject<FluidType> MOLTEN_METAL_TYPE = REGISTRY.register("molten_metal", () -> new MoltenMetalFluidType());
}

