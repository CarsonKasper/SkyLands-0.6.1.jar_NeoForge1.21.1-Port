package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.potion.FrozenMobEffect;
import net.mcreator.flyingstuff.potion.HiddenMobEffect;
import net.mcreator.flyingstuff.potion.WarmthMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModMobEffects {
   public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "flying_stuff");
   public static final RegistryObject<MobEffect> HIDDEN = REGISTRY.register("hidden", () -> new HiddenMobEffect());
   public static final RegistryObject<MobEffect> FROZEN = REGISTRY.register("frozen", () -> new FrozenMobEffect());
   public static final RegistryObject<MobEffect> WARMTH = REGISTRY.register("warmth", () -> new WarmthMobEffect());
}

