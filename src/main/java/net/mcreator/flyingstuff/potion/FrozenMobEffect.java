package net.mcreator.flyingstuff.potion;

import net.mcreator.flyingstuff.procedures.FrozenOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrozenMobEffect extends MobEffect {
   public FrozenMobEffect() {
      super(MobEffectCategory.HARMFUL, -6684673);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      FrozenOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}

