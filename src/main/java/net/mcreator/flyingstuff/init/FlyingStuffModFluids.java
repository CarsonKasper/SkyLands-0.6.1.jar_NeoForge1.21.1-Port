package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.fluid.MoltenMetalFluid;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModFluids {
   public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, "flying_stuff");
   public static final RegistryObject<FlowingFluid> MOLTEN_METAL = REGISTRY.register("molten_metal", () -> new MoltenMetalFluid.Source());
   public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_METAL = REGISTRY.register("flowing_molten_metal", () -> new MoltenMetalFluid.Flowing());

   @EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
   public static class ClientSideHandler {
      @SubscribeEvent
      public static void clientSetup(FMLClientSetupEvent event) {
         ItemBlockRenderTypes.setRenderLayer((Fluid)FlyingStuffModFluids.MOLTEN_METAL.get(), RenderType.translucent());
         ItemBlockRenderTypes.setRenderLayer((Fluid)FlyingStuffModFluids.FLOWING_MOLTEN_METAL.get(), RenderType.translucent());
      }
   }
}

