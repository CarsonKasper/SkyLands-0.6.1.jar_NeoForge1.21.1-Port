package net.custom.flyingstuff.entity;

import net.mcreator.flyingstuff.FlyingStuffModSigns;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity extends ChestBoat {
   private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

   public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
      super(pEntityType, pLevel);
   }

   public ModChestBoatEntity(Level level, double pX, double pY, double pZ) {
      this((EntityType<? extends ChestBoat>)FlyingStuffModSigns.MOD_CHEST_BOAT.get(), level);
      this.setPos(pX, pY, pZ);
   }

   @Override
   public Item getDropItem() {
      return switch (this.getModVariant()) {
         case GOLDEN_LEAVES -> (Item)FlyingStuffModSigns.GOLDEN_LEAVES_CHEST_BOAT.get();
         case GLACIATED -> (Item)FlyingStuffModSigns.GLACIATED_CHEST_BOAT.get();
         case LAVIC -> (Item)FlyingStuffModSigns.LAVIC_CHEST_BOAT.get();
         case INKY -> (Item)FlyingStuffModSigns.INKY_CHEST_BOAT.get();
      };
   }

   public void setModVariant(ModBoatEntity.Type pVariant) {
      this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
   }

   public ModBoatEntity.Type getModVariant() {
      return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
   }

   @Override
   protected void defineSynchedData(SynchedEntityData.Builder builder) {
      super.defineSynchedData(builder);
      builder.define(DATA_ID_TYPE, ModBoatEntity.Type.GOLDEN_LEAVES.ordinal());
   }

   @Override
   protected void addAdditionalSaveData(CompoundTag pCompound) {
      super.addAdditionalSaveData(pCompound);
      pCompound.putString("Type", this.getModVariant().getSerializedName());
   }

   @Override
   protected void readAdditionalSaveData(CompoundTag pCompound) {
      super.readAdditionalSaveData(pCompound);
      if (pCompound.contains("Type", 8)) {
         this.setModVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
      }
   }
}

