package net.minecraftforge.network.simple;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SimpleChannel {
   private final Map<Class<?>, BiConsumer<?, Supplier<NetworkEvent.Context>>> handlers = new ConcurrentHashMap<>();

   public <T> void registerMessage(
      int id,
      Class<T> messageType,
      BiConsumer<T, FriendlyByteBuf> encoder,
      Function<FriendlyByteBuf, T> decoder,
      BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer
   ) {
      this.handlers.put(messageType, messageConsumer);
   }

   public void sendToServer(Object message) {
   }

   public void send(Object target, Object message) {
   }

   public void sendTo(Object message, Object connection, net.minecraftforge.network.NetworkDirection direction) {
   }
}

