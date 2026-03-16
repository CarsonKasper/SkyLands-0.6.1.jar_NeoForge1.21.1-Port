package net.custom.flyingstuff.item;

import java.util.List;
import java.util.function.Predicate;
import net.custom.flyingstuff.entity.ModBoatEntity;
import net.custom.flyingstuff.entity.ModChestBoatEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;

public class ModBoatItem extends Item {
   private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
   private final ModBoatEntity.Type type;
   private final boolean hasChest;

   public ModBoatItem(boolean pHasChest, ModBoatEntity.Type pType, Properties pProperties) {
      super(pProperties);
      this.hasChest = pHasChest;
      this.type = pType;
   }

   @Override
   public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
      ItemStack itemstack = pPlayer.getItemInHand(pHand);
      HitResult hitresult = getPlayerPOVHitResult(pLevel, pPlayer, Fluid.ANY);
      if (hitresult.getType() == Type.MISS) {
         return InteractionResultHolder.pass(itemstack);
      } else {
         Vec3 vec3 = pPlayer.getViewVector(1.0F);
         List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0)).inflate(1.0), ENTITY_PREDICATE);
         if (!list.isEmpty()) {
            Vec3 vec31 = pPlayer.getEyePosition();

            for (Entity entity : list) {
               AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
               if (aabb.contains(vec31)) {
                  return InteractionResultHolder.pass(itemstack);
               }
            }
         }

         if (hitresult.getType() == Type.BLOCK) {
            Boat boat = this.getBoat(pLevel, hitresult);
            if (boat instanceof ModChestBoatEntity chestBoat) {
               chestBoat.setModVariant(this.type);
            } else if (boat instanceof ModBoatEntity modBoat) {
               modBoat.setModVariant(this.type);
            }

            boat.setYRot(pPlayer.getYRot());
            if (!pLevel.noCollision(boat, boat.getBoundingBox())) {
               return InteractionResultHolder.fail(itemstack);
            } else {
               if (!pLevel.isClientSide) {
                  pLevel.addFreshEntity(boat);
                  pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                  if (!pPlayer.getAbilities().instabuild) {
                     itemstack.shrink(1);
                  }
               }

               pPlayer.awardStat(Stats.ITEM_USED.get(this));
               return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
            }
         } else {
            return InteractionResultHolder.pass(itemstack);
         }
      }
   }

   private Boat getBoat(Level level, HitResult hitResult) {
      Vec3 location = hitResult.getLocation();
      return this.hasChest ? new ModChestBoatEntity(level, location.x, location.y, location.z) : new ModBoatEntity(level, location.x, location.y, location.z);
   }
}

