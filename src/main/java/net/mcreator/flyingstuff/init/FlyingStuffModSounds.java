package net.mcreator.flyingstuff.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FlyingStuffModSounds {
   public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "flying_stuff");
   public static final RegistryObject<SoundEvent> SKY_WIND = REGISTRY.register(
      "sky_wind", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_wind"))
   );
   public static final RegistryObject<SoundEvent> FREEFALL = REGISTRY.register(
      "freefall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "freefall"))
   );
   public static final RegistryObject<SoundEvent> FREEFALL_FAST = REGISTRY.register(
      "freefall_fast", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "freefall_fast"))
   );
   public static final RegistryObject<SoundEvent> SKY_RIVER_DISK = REGISTRY.register(
      "sky_river_disk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_river_disk"))
   );
   public static final RegistryObject<SoundEvent> GOLDEN_SKY_MUSIC = REGISTRY.register(
      "golden_sky_music", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "golden_sky_music"))
   );
   public static final RegistryObject<SoundEvent> SKY_CHEST_OPEN = REGISTRY.register(
      "sky_chest_open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_chest_open"))
   );
   public static final RegistryObject<SoundEvent> SKY_CHEST_CLOSE = REGISTRY.register(
      "sky_chest_close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_chest_close"))
   );
   public static final RegistryObject<SoundEvent> DRAGON_FINAL_KILL = REGISTRY.register(
      "dragon_final_kill", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "dragon_final_kill"))
   );
   public static final RegistryObject<SoundEvent> ICE_DRAGON_FLAP = REGISTRY.register(
      "ice_dragon_flap", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "ice_dragon_flap"))
   );
   public static final RegistryObject<SoundEvent> DRAGON_ATTACK = REGISTRY.register(
      "dragon_attack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "dragon_attack"))
   );
   public static final RegistryObject<SoundEvent> ICE_BOMB_HITS = REGISTRY.register(
      "ice_bomb_hits", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "ice_bomb_hits"))
   );
   public static final RegistryObject<SoundEvent> ICE_DRAGON_ROAR = REGISTRY.register(
      "ice_dragon_roar", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "ice_dragon_roar"))
   );
   public static final RegistryObject<SoundEvent> ICE_BOMB_TROWN = REGISTRY.register(
      "ice_bomb_trown", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "ice_bomb_trown"))
   );
   public static final RegistryObject<SoundEvent> SKY_AUTOMATON_BOSS_FINAL_KILL = REGISTRY.register(
      "sky_automaton_boss_final_kill", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_automaton_boss_final_kill"))
   );
   public static final RegistryObject<SoundEvent> CHEST_UNLOCK = REGISTRY.register(
      "chest_unlock", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "chest_unlock"))
   );
   public static final RegistryObject<SoundEvent> DISKICE = REGISTRY.register(
      "diskice", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "diskice"))
   );
   public static final RegistryObject<SoundEvent> UNDERGROUND_SOUND = REGISTRY.register(
      "underground_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "underground_sound"))
   );
   public static final RegistryObject<SoundEvent> UNDERGROUND_MUSIC_DISK = REGISTRY.register(
      "underground_music_disk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "underground_music_disk"))
   );
   public static final RegistryObject<SoundEvent> LAVA_DISK = REGISTRY.register(
      "lava_disk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "lava_disk"))
   );
   public static final RegistryObject<SoundEvent> IGNEUS_SKY = REGISTRY.register(
      "igneus_sky", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "igneus_sky"))
   );
   public static final RegistryObject<SoundEvent> GLACIATED_SKY = REGISTRY.register(
      "glaciated_sky", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "glaciated_sky"))
   );
   public static final RegistryObject<SoundEvent> MECHANISM_STATIC = REGISTRY.register(
      "mechanism_static", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "mechanism_static"))
   );
   public static final RegistryObject<SoundEvent> MECHANISM_ACTIVATED = REGISTRY.register(
      "mechanism_activated", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "mechanism_activated"))
   );
   public static final RegistryObject<SoundEvent> FIREBLADE_SOUND = REGISTRY.register(
      "fireblade_sound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "fireblade_sound"))
   );
   public static final RegistryObject<SoundEvent> MECHANISM_DEACTIVATION = REGISTRY.register(
      "mechanism_deactivation", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "mechanism_deactivation"))
   );
   public static final RegistryObject<SoundEvent> POWERFUL_WIND = REGISTRY.register(
      "powerful_wind", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "powerful_wind"))
   );
   public static final RegistryObject<SoundEvent> DESERT_DISC = REGISTRY.register(
      "desert_disc", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "desert_disc"))
   );
   public static final RegistryObject<SoundEvent> SKY_WATERFALL = REGISTRY.register(
      "sky_waterfall", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "sky_waterfall"))
   );
   public static final RegistryObject<SoundEvent> TEARS_OF_MOOG_CITY = REGISTRY.register(
      "tears_of_moog_city", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("flying_stuff", "tears_of_moog_city"))
   );
}


