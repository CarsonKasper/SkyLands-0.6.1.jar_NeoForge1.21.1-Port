package net.mcreator.flyingstuff.init;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModPaintings {
   public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, "flying_stuff");
   public static final RegistryObject<PaintingVariant> GOLDEN_SKY = REGISTRY.register(
      "golden_sky", () -> new PaintingVariant(16, 32, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("flying_stuff", "golden_sky"))
   );
   public static final RegistryObject<PaintingVariant> MOD_LOGO_PAINTING = REGISTRY.register(
      "mod_logo_painting", () -> new PaintingVariant(32, 32, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("flying_stuff", "mod_logo_painting"))
   );
   public static final RegistryObject<PaintingVariant> GLACIATED_SKY_PAINTING = REGISTRY.register(
      "glaciated_sky_painting", () -> new PaintingVariant(32, 16, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("flying_stuff", "glaciated_sky_painting"))
   );
}

