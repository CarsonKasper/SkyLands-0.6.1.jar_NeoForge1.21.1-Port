package net.mcreator.flyingstuff.init;

import java.lang.reflect.Field;
import net.mcreator.flyingstuff.entity.ArtificialAracnidEntity;
import net.mcreator.flyingstuff.entity.GlaciatedDragonEntity;
import net.mcreator.flyingstuff.entity.HappySlobertEntity;
import net.mcreator.flyingstuff.entity.IceBlobEntity;
import net.mcreator.flyingstuff.entity.IgneoRoboFelineEntity;
import net.mcreator.flyingstuff.entity.MagmaSlobertEntity;
import net.mcreator.flyingstuff.entity.SkyAutomatonBruteEntity;
import net.mcreator.flyingstuff.entity.SkyBirdEntity;
import net.mcreator.flyingstuff.entity.SkyPharaohEntity;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
   @SubscribeEvent
   public static void onEntityTick(EntityTickEvent.Post event) {
      if (event != null && event.getEntity() != null) {
         if (event.getEntity() instanceof GlaciatedDragonEntity syncable) {
            String animation = syncable.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncable.setAnimation("undefined");
               setAnimationProcedure(syncable, animation);
            }
         }

         if (event.getEntity() instanceof SkyAutomatonBruteEntity syncablex) {
            String animation = syncablex.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablex.setAnimation("undefined");
               setAnimationProcedure(syncablex, animation);
            }
         }

         if (event.getEntity() instanceof IceBlobEntity syncablexx) {
            String animation = syncablexx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexx.setAnimation("undefined");
               setAnimationProcedure(syncablexx, animation);
            }
         }

         if (event.getEntity() instanceof MagmaSlobertEntity syncablexxx) {
            String animation = syncablexxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxx, animation);
            }
         }

         if (event.getEntity() instanceof IgneoRoboFelineEntity syncablexxxx) {
            String animation = syncablexxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxxx, animation);
            }
         }

         if (event.getEntity() instanceof SkyBirdEntity syncablexxxxx) {
            String animation = syncablexxxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxxxx, animation);
            }
         }

         if (event.getEntity() instanceof SkyPharaohEntity syncablexxxxxx) {
            String animation = syncablexxxxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxxxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxxxxx, animation);
            }
         }

         if (event.getEntity() instanceof HappySlobertEntity syncablexxxxxxx) {
            String animation = syncablexxxxxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxxxxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxxxxxx, animation);
            }
         }

         if (event.getEntity() instanceof ArtificialAracnidEntity syncablexxxxxxxx) {
            String animation = syncablexxxxxxxx.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               syncablexxxxxxxx.setAnimation("undefined");
               setAnimationProcedure(syncablexxxxxxxx, animation);
            }
         }
      }
   }

   private static void setAnimationProcedure(Object entity, String animation) {
      try {
         Field field = entity.getClass().getDeclaredField("animationprocedure");
         field.setAccessible(true);
         field.set(entity, animation);
      } catch (ReflectiveOperationException ignored) {
      }
   }
}

