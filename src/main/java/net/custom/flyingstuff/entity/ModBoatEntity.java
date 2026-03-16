package net.custom.flyingstuff.entity;

import java.util.function.IntFunction;
import net.mcreator.flyingstuff.FlyingStuffModSigns;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.ByIdMap.OutOfBoundsStrategy;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.StringRepresentable.EnumCodec;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ModBoatEntity extends Boat {
   private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

   public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
      super(pEntityType, pLevel);
   }

   public ModBoatEntity(Level level, double pX, double pY, double pZ) {
      this((EntityType<? extends Boat>)FlyingStuffModSigns.MOD_BOAT.get(), level);
      this.setPos(pX, pY, pZ);
   }

   @Override
   public Item getDropItem() {
      return switch (this.getModVariant()) {
         case GOLDEN_LEAVES -> (Item)FlyingStuffModSigns.GOLDEN_LEAVES_BOAT.get();
         case GLACIATED -> (Item)FlyingStuffModSigns.GLACIATED_BOAT.get();
         case LAVIC -> (Item)FlyingStuffModSigns.LAVIC_BOAT.get();
         case INKY -> (Item)FlyingStuffModSigns.INKY_BOAT.get();
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

   public static enum Type implements StringRepresentable {
      GOLDEN_LEAVES((Block)FlyingStuffModBlocks.F_IERY_PLANKS.get(), "goldenleaves"),
      GLACIATED((Block)FlyingStuffModBlocks.GLACIATED_PLANKS.get(), "glaciated"),
      LAVIC((Block)FlyingStuffModBlocks.LAVIC_PLANKS.get(), "lavic"),
      INKY((Block)FlyingStuffModBlocks.INKY_PLANKS.get(), "inky");

      private final String name;
      private final Block planks;
      public static final EnumCodec<ModBoatEntity.Type> CODEC = StringRepresentable.fromEnum(ModBoatEntity.Type::values);
      private static final IntFunction<ModBoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), OutOfBoundsStrategy.ZERO);

      private Type(Block pPlanks, String pName) {
         this.name = pName;
         this.planks = pPlanks;
      }

      public String getName() {
         return this.name;
      }

      public Block getPlanks() {
         return this.planks;
      }

      @Override
      public String getSerializedName() {
         return this.name;
      }

      public static ModBoatEntity.Type byId(int pId) {
         return BY_ID.apply(pId);
      }

      public static ModBoatEntity.Type byName(String pName) {
         return CODEC.byName(pName, GOLDEN_LEAVES);
      }
   }
}

