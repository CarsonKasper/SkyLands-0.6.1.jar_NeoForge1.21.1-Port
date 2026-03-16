package net.mcreator.flyingstuff.procedures;

import net.mcreator.flyingstuff.init.FlyingStuffModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class WarmthPotionPlayerFinishesUsingItemProcedure {
   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(Holder.direct((MobEffect)FlyingStuffModMobEffects.WARMTH.get()), 1000, 1));
         }
      }
   }
}



