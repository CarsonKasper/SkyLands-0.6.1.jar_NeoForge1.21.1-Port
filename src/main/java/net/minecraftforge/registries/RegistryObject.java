package net.minecraftforge.registries;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class RegistryObject<T> implements Supplier<T> {
   private final DeferredHolder<?, ?> holder;

   RegistryObject(DeferredHolder<?, ?> holder) {
      this.holder = holder;
   }

   static <R, T extends R> RegistryObject<T> of(DeferredHolder<R, T> holder) {
      return new RegistryObject<>(holder);
   }

   public T get() {
      return (T)this.holder.get();
   }

   public T value() {
      return (T)this.holder.get();
   }

   public ResourceLocation getId() {
      return this.holder.getId();
   }

   public boolean isPresent() {
      return this.holder.asOptional().isPresent();
   }

   public Optional<T> asOptional() {
      return this.holder.asOptional().map(value -> (T)value);
   }

   public void ifPresent(Consumer<? super T> consumer) {
      this.asOptional().ifPresent(consumer);
   }

   public T orElse(T other) {
      return this.asOptional().orElse(other);
   }

   public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
      return this.asOptional().orElseThrow(exceptionSupplier);
   }
}

