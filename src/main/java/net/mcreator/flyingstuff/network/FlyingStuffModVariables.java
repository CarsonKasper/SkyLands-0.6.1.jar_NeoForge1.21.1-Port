package net.mcreator.flyingstuff.network;

import java.util.function.Supplier;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerSliderEntry;
import net.mcreator.flyingstuff.FlyingStuffMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.capabilities.EntityCapability;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class FlyingStuffModVariables {
   public static boolean CloudActive = true;
   public static BooleanListEntry CloudActiveBolean;
   public static BooleanListEntry CloudBlockActive;
   public static IntegerSliderEntry CloudDist;
   public static BooleanListEntry CloudActiveOutside;
   public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, "flying_stuff");
   public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register(
      "player_variables", () -> AttachmentType.serializable(PlayerVariables::new).copyOnDeath().build()
   );
   public static final EntityCapability<PlayerVariables, Void> PLAYER_VARIABLES_CAPABILITY = EntityCapability.createVoid(
      ResourceLocation.parse("flying_stuff:player_variables"), PlayerVariables.class
   );

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      FlyingStuffMod.addNetworkMessage(
         FlyingStuffModVariables.PlayerVariablesSyncMessage.class,
         FlyingStuffModVariables.PlayerVariablesSyncMessage::buffer,
         FlyingStuffModVariables.PlayerVariablesSyncMessage::new,
         FlyingStuffModVariables.PlayerVariablesSyncMessage::handler
      );
   }

   @SubscribeEvent
   public static void init(RegisterCapabilitiesEvent event) {
      event.registerEntity(PLAYER_VARIABLES_CAPABILITY, EntityType.PLAYER, (player, context) -> player.getData(PLAYER_VARIABLES.get()));
   }

   public static class PlayerVariables implements INBTSerializable<Tag> {
      public boolean is_freefall = false;
      public boolean is_gliding = false;
      public boolean was_freefall = false;
      public boolean is_fast_freefalling = false;
      public double gliding_stamina = 5.0;
      public boolean is_on_stamina_cooldown = false;

      public void syncPlayerVariables(Entity entity) {
         if (entity instanceof ServerPlayer serverPlayer) {
            FlyingStuffMod.PACKET_HANDLER.send(
               net.minecraftforge.network.PacketDistributor.PLAYER.with(() -> serverPlayer), new FlyingStuffModVariables.PlayerVariablesSyncMessage(this)
            );
         }
      }

      public Tag writeNBT() {
         CompoundTag nbt = new CompoundTag();
         nbt.putBoolean("is_freefall", this.is_freefall);
         nbt.putBoolean("is_gliding", this.is_gliding);
         nbt.putBoolean("was_freefall", this.was_freefall);
         nbt.putBoolean("is_fast_freefalling", this.is_fast_freefalling);
         nbt.putDouble("gliding_stamina", this.gliding_stamina);
         nbt.putBoolean("is_on_stamina_cooldown", this.is_on_stamina_cooldown);
         return nbt;
      }

      public void readNBT(Tag tag) {
         if (tag instanceof CompoundTag nbt) {
            this.is_freefall = nbt.getBoolean("is_freefall");
            this.is_gliding = nbt.getBoolean("is_gliding");
            this.was_freefall = nbt.getBoolean("was_freefall");
            this.is_fast_freefalling = nbt.getBoolean("is_fast_freefalling");
            this.gliding_stamina = nbt.getDouble("gliding_stamina");
            this.is_on_stamina_cooldown = nbt.getBoolean("is_on_stamina_cooldown");
         }
      }

      @Override
      public Tag serializeNBT(HolderLookup.Provider provider) {
         return this.writeNBT();
      }

      @Override
      public void deserializeNBT(HolderLookup.Provider provider, Tag nbt) {
         this.readNBT(nbt);
      }

      public void copyFrom(PlayerVariables other) {
         this.is_freefall = other.is_freefall;
         this.is_gliding = other.is_gliding;
         this.was_freefall = other.was_freefall;
         this.is_fast_freefalling = other.is_fast_freefalling;
         this.gliding_stamina = other.gliding_stamina;
         this.is_on_stamina_cooldown = other.is_on_stamina_cooldown;
      }

      public PlayerVariables orElse(PlayerVariables other) {
         return this;
      }
   }

   public static class PlayerVariablesSyncMessage {
      private final FlyingStuffModVariables.PlayerVariables data;

      public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
         this.data = new FlyingStuffModVariables.PlayerVariables();
         this.data.readNBT(buffer.readNbt());
      }

      public PlayerVariablesSyncMessage(FlyingStuffModVariables.PlayerVariables data) {
         this.data = data;
      }

      public static void buffer(FlyingStuffModVariables.PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
         buffer.writeNbt((CompoundTag)message.data.writeNBT());
      }

      public static void handler(FlyingStuffModVariables.PlayerVariablesSyncMessage message, Supplier<net.minecraftforge.network.NetworkEvent.Context> contextSupplier) {
         net.minecraftforge.network.NetworkEvent.Context context = contextSupplier.get();
         context.enqueueWork(
            () -> {
               if (!context.getDirection().getReceptionSide().isServer() && Minecraft.getInstance().player != null) {
                  Minecraft.getInstance().player.getData(PLAYER_VARIABLES.get()).copyFrom(message.data);
               }
            }
         );
         context.setPacketHandled(true);
      }
   }
}

