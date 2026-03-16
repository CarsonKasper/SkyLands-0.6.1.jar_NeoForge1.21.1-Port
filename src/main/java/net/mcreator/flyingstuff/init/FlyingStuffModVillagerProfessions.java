package net.mcreator.flyingstuff.init;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.mcreator.flyingstuff.FlyingStuffMod;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

import net.minecraftforge.registries.ForgeRegistries.Keys;

@EventBusSubscriber(bus = Bus.MOD)
public class FlyingStuffModVillagerProfessions {
   private static final Map<String, FlyingStuffModVillagerProfessions.ProfessionPoiType> POI_TYPES = new HashMap<>();
   public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, "flying_stuff");
   public static final Supplier<VillagerProfession> COOL = registerProfession(
      "cool",
      () -> (Block)FlyingStuffModBlocks.CELESTIUM_ANVIL.get(),
      () -> (SoundEvent)ForgeRegistries.SOUND_EVENTS.get(ResourceLocation.withDefaultNamespace("entity.villager.trade"))
   );

   private static Supplier<VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
      POI_TYPES.put(name, new FlyingStuffModVillagerProfessions.ProfessionPoiType(block, null));
      return PROFESSIONS.register(
         name,
         () -> {
            Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> POI_TYPES.get(name).poiType != null
               && poiTypeHolder.value() == POI_TYPES.get(name).poiType.value();
            return new VillagerProfession("flying_stuff:" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
         }
      );
   }

   @SubscribeEvent
   public static void registerProfessionPointsOfInterest(RegisterEvent event) {
      event.register(
         Keys.POI_TYPES,
         registerHelper -> {
            for (Entry<String, FlyingStuffModVillagerProfessions.ProfessionPoiType> entry : POI_TYPES.entrySet()) {
               Block block = entry.getValue().block.get();
               String name = entry.getKey();
               Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
               if (existingCheck.isPresent()) {
                  FlyingStuffMod.LOGGER
                     .error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
               } else {
                  PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
                  registerHelper.register(ResourceLocation.fromNamespaceAndPath("flying_stuff", name), poiType);
                  entry.getValue().poiType = Holder.direct(poiType);
               }
            }
         }
      );
   }

   private static class ProfessionPoiType {
      final Supplier<Block> block;
      Holder<PoiType> poiType;

      ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
         this.block = block;
         this.poiType = poiType;
      }
   }
}



