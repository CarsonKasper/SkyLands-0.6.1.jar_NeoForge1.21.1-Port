package net.minecraftforge.network;

public enum NetworkDirection {
   PLAY_TO_CLIENT(NetworkEvent.NetworkDirection.PLAY_TO_CLIENT),
   PLAY_TO_SERVER(NetworkEvent.NetworkDirection.PLAY_TO_SERVER);

   private final NetworkEvent.NetworkDirection delegate;

   NetworkDirection(NetworkEvent.NetworkDirection delegate) {
      this.delegate = delegate;
   }

   public NetworkEvent.ReceptionSide getReceptionSide() {
      return this.delegate.getReceptionSide();
   }
}

