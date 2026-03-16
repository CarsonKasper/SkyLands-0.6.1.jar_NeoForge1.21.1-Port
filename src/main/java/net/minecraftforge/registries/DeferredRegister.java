package net.minecraftforge.registries;

import java.util.Collection;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;

public class DeferredRegister<T> {
   private final net.neoforged.neoforge.registries.DeferredRegister<T> delegate;

   private DeferredRegister(net.neoforged.neoforge.registries.DeferredRegister<T> delegate) {
      this.delegate = delegate;
   }

   public static <T> DeferredRegister<T> create(Registry<T> registry, String namespace) {
      return new DeferredRegister<>(net.neoforged.neoforge.registries.DeferredRegister.create(registry, namespace));
   }

   public static <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> registry, String namespace) {
      return new DeferredRegister<>(net.neoforged.neoforge.registries.DeferredRegister.create(registry, namespace));
   }

   public static <T> DeferredRegister<T> create(ResourceLocation registry, String namespace) {
      return new DeferredRegister<>(net.neoforged.neoforge.registries.DeferredRegister.create(registry, namespace));
   }

   public <I extends T> RegistryObject<I> register(String name, Supplier<? extends I> supplier) {
      return (RegistryObject<I>)RegistryObject.of(this.delegate.register(name, supplier));
   }

   public void register(IEventBus bus) {
      this.delegate.register(bus);
   }

   public Collection<?> getEntries() {
      return this.delegate.getEntries();
   }
}

