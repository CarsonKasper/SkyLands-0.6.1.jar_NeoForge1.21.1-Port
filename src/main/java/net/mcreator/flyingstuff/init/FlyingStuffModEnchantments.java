package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.enchantment.LightweightEnchantment;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModEnchantments {
   public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, "flying_stuff");
   public static final RegistryObject<Enchantment> LIGHTWEIGHT = REGISTRY.register("lightweight", LightweightEnchantment::create);
}

