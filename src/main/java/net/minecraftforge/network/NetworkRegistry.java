package net.minecraftforge.network;

import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.simple.SimpleChannel;

public final class NetworkRegistry {
   public static SimpleChannel newSimpleChannel(
      ResourceLocation name,
      Supplier<String> versionSupplier,
      Predicate<String> clientAcceptedVersions,
      Predicate<String> serverAcceptedVersions
   ) {
      return new SimpleChannel();
   }

   private NetworkRegistry() {
   }
}

