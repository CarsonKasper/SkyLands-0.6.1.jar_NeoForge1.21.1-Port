package net.mcreator.flyingstuff.procedures;

import java.util.Comparator;
import net.mcreator.flyingstuff.init.FlyingStuffModMobEffects;
import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IcebombProjectileHitsBlockProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      Vec3 _center = new Vec3(x, y, z);

      for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5), e -> true)
         .stream()
         .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
         .toList()) {
         if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(Holder.direct((MobEffect)FlyingStuffModMobEffects.FROZEN.get()), 80, 1));
         }
      }

      if (world instanceof ServerLevel _level) {
         _level.sendParticles((SimpleParticleType)FlyingStuffModParticleTypes.ICE.get(), x, y + 1.0, z, 5, 0.5, 0.1, 0.5, 0.0);
      }

      if (world instanceof Level _level) {
         if (!_level.isClientSide()) {
            _level.playSound(
               null,
               BlockPos.containing(x, y, z),
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.get(ResourceLocation.parse("flying_stuff:ice_bomb_hits")),
               SoundSource.PLAYERS,
               1.0F,
               1.0F
            );
         } else {
            _level.playLocalSound(
               x,
               y,
               z,
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.get(ResourceLocation.parse("flying_stuff:ice_bomb_hits")),
               SoundSource.PLAYERS,
               1.0F,
               1.0F,
               false
            );
         }
      }
   }
}




