package net.mcreator.flyingstuff.potion;

import net.mcreator.flyingstuff.procedures.HiddenEffectExpiresProcedure;
import net.mcreator.flyingstuff.procedures.HiddenOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class HiddenMobEffect extends MobEffect {
   public HiddenMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public boolean applyEffectTick(LivingEntity entity, int amplifier) {
      HiddenOnEffectActiveTickProcedure.execute(entity);
      return true;
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      HiddenEffectExpiresProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}

