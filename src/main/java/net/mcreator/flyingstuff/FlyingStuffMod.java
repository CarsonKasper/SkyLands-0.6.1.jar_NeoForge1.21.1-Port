package net.mcreator.flyingstuff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModEnchantments;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModFeatures;
import net.mcreator.flyingstuff.init.FlyingStuffModFluidTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModMenus;
import net.mcreator.flyingstuff.init.FlyingStuffModMobEffects;
import net.mcreator.flyingstuff.init.FlyingStuffModPaintings;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModSounds;
import net.mcreator.flyingstuff.init.FlyingStuffModTabs;
import net.mcreator.flyingstuff.init.FlyingStuffModVillagerProfessions;
import net.mcreator.flyingstuff.network.FlyingStuffModVariables;
import net.mcreator.flyingstuff.world.features.StructureFeature;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("flying_stuff")
public class FlyingStuffMod {
   public static final Logger LOGGER = LogManager.getLogger(FlyingStuffMod.class);
   public static final String MODID = "flying_stuff";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
      ResourceLocation.fromNamespaceAndPath("flying_stuff", "flying_stuff"), () -> "1", "1"::equals, "1"::equals
   );
   private static int messageID = 0;
   private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

   public FlyingStuffMod(IEventBus bus) {
      NeoForge.EVENT_BUS.register(this);
      FlyingStuffModSounds.REGISTRY.register(bus);
      FlyingStuffModBlocks.REGISTRY.register(bus);
      FlyingStuffModBlockEntities.REGISTRY.register(bus);
      FlyingStuffModItems.REGISTRY.register(bus);
      FlyingStuffModEntities.REGISTRY.register(bus);
      FlyingStuffModEnchantments.REGISTRY.register(bus);
      FlyingStuffModTabs.REGISTRY.register(bus);
      FlyingStuffModFeatures.REGISTRY.register(bus);
      StructureFeature.REGISTRY.register(bus);
      FlyingStuffModMobEffects.REGISTRY.register(bus);
      FlyingStuffModPaintings.REGISTRY.register(bus);
      FlyingStuffModParticleTypes.REGISTRY.register(bus);
      FlyingStuffModVillagerProfessions.PROFESSIONS.register(bus);
      FlyingStuffModMenus.REGISTRY.register(bus);
      FlyingStuffModFluids.REGISTRY.register(bus);
      FlyingStuffModFluidTypes.REGISTRY.register(bus);
      FlyingStuffModVariables.ATTACHMENT_TYPES.register(bus);
   }

   public static <T> void addNetworkMessage(
      Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<Context>> messageConsumer
   ) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      messageID++;
   }

   public static void queueServerWork(int tick, Runnable action) {
      if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
         workQueue.add(new SimpleEntry<>(action, tick));
      }
   }

   @SubscribeEvent
   public void tick(ServerTickEvent.Post event) {
      List<SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
      workQueue.forEach(work -> {
         work.setValue(work.getValue() - 1);
         if (work.getValue() == 0) {
            actions.add((SimpleEntry<Runnable, Integer>)work);
         }
      });
      actions.forEach(e -> e.getKey().run());
      workQueue.removeAll(actions);
   }
}

