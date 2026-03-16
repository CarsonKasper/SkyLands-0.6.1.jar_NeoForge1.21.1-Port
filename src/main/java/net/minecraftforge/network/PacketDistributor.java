package net.minecraftforge.network;

import java.util.function.Supplier;

public final class PacketDistributor {
   public static final PacketTarget<Object> PLAYER = new PacketTarget<>();

   public static final class PacketTarget<T> {
      public Supplier<T> with(Supplier<T> supplier) {
         return supplier;
      }
   }

   private PacketDistributor() {
   }
}

