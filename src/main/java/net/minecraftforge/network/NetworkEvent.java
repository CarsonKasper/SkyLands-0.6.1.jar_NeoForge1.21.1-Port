package net.minecraftforge.network;

import java.util.function.Consumer;
import net.minecraft.world.entity.player.Player;

public final class NetworkEvent {
   public static class Context {
      private final Player sender;
      private final NetworkDirection direction;

      public Context() {
         this(null, NetworkDirection.PLAY_TO_CLIENT);
      }

      public Context(Player sender, NetworkDirection direction) {
         this.sender = sender;
         this.direction = direction;
      }

      public void enqueueWork(Runnable runnable) {
         runnable.run();
      }

      public void setPacketHandled(boolean handled) {
      }

      public Player getSender() {
         return this.sender;
      }

      public NetworkDirection getDirection() {
         return this.direction;
      }
   }

   public enum NetworkDirection {
      PLAY_TO_CLIENT(false),
      PLAY_TO_SERVER(true);

      private final ReceptionSide receptionSide;

      NetworkDirection(boolean server) {
         this.receptionSide = new ReceptionSide(server);
      }

      public ReceptionSide getReceptionSide() {
         return this.receptionSide;
      }
   }

   public static final class ReceptionSide {
      private final boolean server;

      private ReceptionSide(boolean server) {
         this.server = server;
      }

      public boolean isServer() {
         return this.server;
      }
   }

   private NetworkEvent() {
   }
}

