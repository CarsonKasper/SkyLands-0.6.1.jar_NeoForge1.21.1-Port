package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.entity.AridSkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.ArtificialAracnidEntity;
import net.mcreator.flyingstuff.entity.AutomatonDroneEntity;
import net.mcreator.flyingstuff.entity.EyeOftsProjectileEntity;
import net.mcreator.flyingstuff.entity.FireWaveEntity;
import net.mcreator.flyingstuff.entity.FloatGrapeProjEntity;
import net.mcreator.flyingstuff.entity.FriendlyVexEntity;
import net.mcreator.flyingstuff.entity.GlaciatedDragonEntity;
import net.mcreator.flyingstuff.entity.GlaciatedSkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.HappySlobertEntity;
import net.mcreator.flyingstuff.entity.IceArrowEntity;
import net.mcreator.flyingstuff.entity.IceBlobEntity;
import net.mcreator.flyingstuff.entity.IcebombEntity;
import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;
import net.mcreator.flyingstuff.entity.LavicSkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.MagmaSlobertEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonBossEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonBruteEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonEntity;
import net.mcreator.flyingstuff.entity.SkyBirdEntity;
import net.mcreator.flyingstuff.entity.SkyPharaohEntity;
import net.mcreator.flyingstuff.entity.SmokeFlowerProjEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(bus = Bus.MOD)
public class FlyingStuffModEntities {
   public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "flying_stuff");
   public static final RegistryObject<EntityType<SkyAutomatonEntity>> SKY_AUTOMATON = register(
      "sky_automaton",
      Builder.of(SkyAutomatonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<SkyAutomatonBossEntity>> SKY_AUTOMATON_BOSS = register(
      "sky_automaton_boss",
      Builder.of(SkyAutomatonBossEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<SmokeFlowerProjEntity>> SMOKE_FLOWER_PROJ = register(
      "smoke_flower_proj",
      Builder.<SmokeFlowerProjEntity>of((type, level) -> new SmokeFlowerProjEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<AutomatonDroneEntity>> AUTOMATON_DRONE = register(
      "automaton_drone",
      Builder.of(AutomatonDroneEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(72)
         .setUpdateInterval(3)
         .sized(0.6F, 1.2F)
   );
   public static final RegistryObject<EntityType<FloatGrapeProjEntity>> FLOAT_GRAPE_PROJ = register(
      "float_grape_proj",
      Builder.<FloatGrapeProjEntity>of((type, level) -> new FloatGrapeProjEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<IceArrowEntity>> ICE_ARROW = register(
      "ice_arrow",
      Builder.<IceArrowEntity>of((type, level) -> new IceArrowEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<GlaciatedSkyAutomatonEntity>> GLACIATED_SKY_AUTOMATON = register(
      "glaciated_sky_automaton",
      Builder.of(GlaciatedSkyAutomatonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<GlaciatedDragonEntity>> GLACIATED_DRAGON = register(
      "glaciated_dragon",
      Builder.of(GlaciatedDragonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(100)
         .setUpdateInterval(3)
         .sized(2.7F, 3.8F)
   );
   public static final RegistryObject<EntityType<IcebombEntity>> ICEBOMB = register(
      "icebomb",
      Builder.<IcebombEntity>of((type, level) -> new IcebombEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<SkyAutomatonBruteEntity>> SKY_AUTOMATON_BRUTE = register(
      "sky_automaton_brute",
      Builder.of(SkyAutomatonBruteEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<IceBlobEntity>> ICE_BLOB = register(
      "ice_blob",
      Builder.of(IceBlobEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(72)
         .setUpdateInterval(3)
         .sized(1.0F, 1.0F)
   );
   public static final RegistryObject<EntityType<MagmaSlobertEntity>> MAGMA_SLOBERT = register(
      "magma_slobert",
      Builder.of(MagmaSlobertEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(72)
         .setUpdateInterval(3)
         .fireImmune()
         .sized(1.0F, 1.0F)
   );
   public static final RegistryObject<EntityType<LavicSkyAutomatonEntity>> LAVIC_SKY_AUTOMATON = register(
      "lavic_sky_automaton",
      Builder.of(LavicSkyAutomatonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .fireImmune()
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<FireWaveEntity>> FIRE_WAVE = register(
      "fire_wave",
      Builder.<FireWaveEntity>of((type, level) -> new FireWaveEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<IgneoRoboFelineEntity>> IGNEO_ROBO_FELINE = register(
      "igneo_robo_feline",
      Builder.of(IgneoRoboFelineEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .fireImmune()
         .sized(1.3F, 2.4F)
   );
   public static final RegistryObject<EntityType<SkyBirdEntity>> SKY_BIRD = register(
      "sky_bird",
      Builder.of(SkyBirdEntity::new, MobCategory.CREATURE)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<AridSkyAutomatonEntity>> ARID_SKY_AUTOMATON = register(
      "arid_sky_automaton",
      Builder.of(AridSkyAutomatonEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<SkyPharaohEntity>> SKY_PHARAOH = register(
      "sky_pharaoh",
      Builder.of(SkyPharaohEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(1.2F, 3.0F)
   );
   public static final RegistryObject<EntityType<FriendlyVexEntity>> FRIENDLY_VEX = register(
      "friendly_vex",
      Builder.of(FriendlyVexEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(3)
         .sized(0.5F, 0.5F)
   );
   public static final RegistryObject<EntityType<HappySlobertEntity>> HAPPY_SLOBERT = register(
      "happy_slobert",
      Builder.of(HappySlobertEntity::new, MobCategory.CREATURE)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(72)
         .setUpdateInterval(3)
         .sized(1.0F, 1.0F)
   );
   public static final RegistryObject<EntityType<ArtificialAracnidEntity>> ARTIFICIAL_ARACNID = register(
      "artificial_aracnid",
      Builder.of(ArtificialAracnidEntity::new, MobCategory.MONSTER)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(96)
         .setUpdateInterval(3)
         .sized(0.6F, 1.8F)
   );
   public static final RegistryObject<EntityType<EyeOftsProjectileEntity>> EYE_OFTS_PROJECTILE = register(
      "eye_ofts_projectile",
      Builder.<EyeOftsProjectileEntity>of((type, level) -> new EyeOftsProjectileEntity(type, level), MobCategory.MISC)
         .setShouldReceiveVelocityUpdates(true)
         .setTrackingRange(64)
         .setUpdateInterval(1)
         .sized(0.5F, 0.5F)
   );

   private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
      return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      event.enqueueWork(() -> {
         SkyAutomatonEntity.init();
         SkyAutomatonBossEntity.init();
         AutomatonDroneEntity.init();
         GlaciatedSkyAutomatonEntity.init();
         GlaciatedDragonEntity.init();
         SkyAutomatonBruteEntity.init();
         IceBlobEntity.init();
         MagmaSlobertEntity.init();
         LavicSkyAutomatonEntity.init();
         IgneoRoboFelineEntity.init();
         SkyBirdEntity.init();
         AridSkyAutomatonEntity.init();
         SkyPharaohEntity.init();
         FriendlyVexEntity.init();
         HappySlobertEntity.init();
         ArtificialAracnidEntity.init();
      });
   }

   @SubscribeEvent
   public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put((EntityType)SKY_AUTOMATON.get(), SkyAutomatonEntity.createAttributes().build());
      event.put((EntityType)SKY_AUTOMATON_BOSS.get(), SkyAutomatonBossEntity.createAttributes().build());
      event.put((EntityType)AUTOMATON_DRONE.get(), AutomatonDroneEntity.createAttributes().build());
      event.put((EntityType)GLACIATED_SKY_AUTOMATON.get(), GlaciatedSkyAutomatonEntity.createAttributes().build());
      event.put((EntityType)GLACIATED_DRAGON.get(), GlaciatedDragonEntity.createAttributes().build());
      event.put((EntityType)SKY_AUTOMATON_BRUTE.get(), SkyAutomatonBruteEntity.createAttributes().build());
      event.put((EntityType)ICE_BLOB.get(), IceBlobEntity.createAttributes().build());
      event.put((EntityType)MAGMA_SLOBERT.get(), MagmaSlobertEntity.createAttributes().build());
      event.put((EntityType)LAVIC_SKY_AUTOMATON.get(), LavicSkyAutomatonEntity.createAttributes().build());
      event.put((EntityType)IGNEO_ROBO_FELINE.get(), IgneoRoboFelineEntity.createAttributes().build());
      event.put((EntityType)SKY_BIRD.get(), SkyBirdEntity.createAttributes().build());
      event.put((EntityType)ARID_SKY_AUTOMATON.get(), AridSkyAutomatonEntity.createAttributes().build());
      event.put((EntityType)SKY_PHARAOH.get(), SkyPharaohEntity.createAttributes().build());
      event.put((EntityType)FRIENDLY_VEX.get(), FriendlyVexEntity.createAttributes().build());
      event.put((EntityType)HAPPY_SLOBERT.get(), HappySlobertEntity.createAttributes().build());
      event.put((EntityType)ARTIFICIAL_ARACNID.get(), ArtificialAracnidEntity.createAttributes().build());
   }
}


