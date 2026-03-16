package net.mcreator.flyingstuff.potion;

import net.mcreator.flyingstuff.procedures.WarmthOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WarmthMobEffect extends MobEffect {
   public WarmthMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -26368);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      WarmthOnEffectActiveTickProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
