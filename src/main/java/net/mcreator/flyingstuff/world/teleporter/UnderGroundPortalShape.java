package net.mcreator.flyingstuff.world.teleporter;

import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

public class UnderGroundPortalShape {
   private static final int MIN_WIDTH = 2;
   public static final int MAX_WIDTH = 21;
   private static final int MIN_HEIGHT = 3;
   public static final int MAX_HEIGHT = 21;
   private static final StatePredicate FRAME = (state, level, pos) -> state.getBlock() == FlyingStuffModBlocks.POLISHED_BEDROCK.get();
   private final LevelAccessor level;
   private final Axis axis;
   private final Direction rightDir;
   private int numPortalBlocks;
   @Nullable
   private BlockPos bottomLeft;
   private int height;
   private final int width;

   public static Optional<UnderGroundPortalShape> findEmptyPortalShape(LevelAccessor level, BlockPos pos, Axis axis) {
      return findPortalShape(level, pos, shape -> shape.isValid() && shape.numPortalBlocks == 0, axis);
   }

   public static Optional<UnderGroundPortalShape> findPortalShape(
      LevelAccessor level, BlockPos pos, Predicate<UnderGroundPortalShape> predicate, Axis axis
   ) {
      Optional<UnderGroundPortalShape> portalShape = Optional.of(new UnderGroundPortalShape(level, pos, axis)).filter(predicate);
      if (portalShape.isPresent()) {
         return portalShape;
      }

      Axis alternateAxis = axis == Axis.X ? Axis.Z : Axis.X;
      return Optional.of(new UnderGroundPortalShape(level, pos, alternateAxis)).filter(predicate);
   }

   public UnderGroundPortalShape(LevelAccessor level, BlockPos pos, Axis axis) {
      this.level = level;
      this.axis = axis;
      this.rightDir = axis == Axis.X ? Direction.WEST : Direction.SOUTH;
      this.bottomLeft = this.calculateBottomLeft(pos);
      if (this.bottomLeft == null) {
         this.bottomLeft = pos;
         this.width = 1;
         this.height = 1;
      } else {
         this.width = this.calculateWidth();
         if (this.width > 0) {
            this.height = this.calculateHeight();
         }
      }
   }

   @Nullable
   private BlockPos calculateBottomLeft(BlockPos pos) {
      int minY = Math.max(this.level.getMinBuildHeight(), pos.getY() - 21);
      while (pos.getY() > minY && isEmpty(this.level.getBlockState(pos.below()))) {
         pos = pos.below();
      }

      Direction direction = this.rightDir.getOpposite();
      int distance = this.getDistanceUntilEdgeAboveFrame(pos, direction) - 1;
      return distance < 0 ? null : pos.relative(direction, distance);
   }

   private int calculateWidth() {
      int distance = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
      return distance >= MIN_WIDTH && distance <= MAX_WIDTH ? distance : 0;
   }

   private int getDistanceUntilEdgeAboveFrame(BlockPos pos, Direction direction) {
      MutableBlockPos cursor = new MutableBlockPos();

      for (int i = 0; i <= MAX_WIDTH; i++) {
         cursor.set(pos).move(direction, i);
         BlockState state = this.level.getBlockState(cursor);
         if (!isEmpty(state)) {
            if (FRAME.test(state, this.level, cursor)) {
               return i;
            }
            break;
         }

         BlockState belowState = this.level.getBlockState(cursor.move(Direction.DOWN));
         cursor.move(Direction.UP);
         if (!FRAME.test(belowState, this.level, cursor)) {
            break;
         }
      }

      return 0;
   }

   private int calculateHeight() {
      MutableBlockPos cursor = new MutableBlockPos();
      int distance = this.getDistanceUntilTop(cursor);
      return distance >= MIN_HEIGHT && distance <= MAX_HEIGHT && this.hasTopFrame(cursor, distance) ? distance : 0;
   }

   private boolean hasTopFrame(MutableBlockPos cursor, int height) {
      for (int i = 0; i < this.width; i++) {
         cursor.set(this.bottomLeft).move(Direction.UP, height).move(this.rightDir, i);
         if (!FRAME.test(this.level.getBlockState(cursor), this.level, cursor)) {
            return false;
         }
      }

      return true;
   }

   private int getDistanceUntilTop(MutableBlockPos cursor) {
      for (int i = 0; i < MAX_HEIGHT; i++) {
         cursor.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
         if (!FRAME.test(this.level.getBlockState(cursor), this.level, cursor)) {
            return i;
         }

         cursor.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
         if (!FRAME.test(this.level.getBlockState(cursor), this.level, cursor)) {
            return i;
         }

         for (int j = 0; j < this.width; j++) {
            cursor.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
            BlockState state = this.level.getBlockState(cursor);
            if (!isEmpty(state)) {
               return i;
            }

            if (state.getBlock() == FlyingStuffModBlocks.UNDER_GROUND_PORTAL.get()) {
               this.numPortalBlocks++;
            }
         }
      }

      return MAX_HEIGHT;
   }

   private static boolean isEmpty(BlockState state) {
      return state.isAir() || state.getBlock() == FlyingStuffModBlocks.UNDER_GROUND_PORTAL.get();
   }

   public boolean isValid() {
      return this.bottomLeft != null && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
   }

   public void createPortalBlocks() {
      BlockState portalState = ((Block)FlyingStuffModBlocks.UNDER_GROUND_PORTAL.get())
         .defaultBlockState()
         .setValue(NetherPortalBlock.AXIS, this.axis);
      BlockPos.betweenClosed(
            this.bottomLeft,
            this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)
         )
         .forEach(
            pos -> {
               this.level.setBlock(pos, portalState, 18);
               if (this.level instanceof ServerLevel serverLevel && UnderGroundTeleporter.poi != null) {
                  serverLevel.getPoiManager().add(pos, UnderGroundTeleporter.poi);
               }
            }
         );
   }

   public boolean isComplete() {
      return this.isValid() && this.numPortalBlocks == this.width * this.height;
   }

   public static Vec3 getRelativePosition(FoundRectangle rectangle, Axis axis, Vec3 entityPos, EntityDimensions dimensions) {
      double horizontalRoom = rectangle.axis1Size - dimensions.width();
      double verticalRoom = rectangle.axis2Size - dimensions.height();
      BlockPos blockPos = rectangle.minCorner;
      double relativeHorizontal;
      if (horizontalRoom > 0.0) {
         float center = blockPos.get(axis) + dimensions.width() / 2.0F;
         relativeHorizontal = Mth.clamp(Mth.inverseLerp(entityPos.get(axis) - center, 0.0, horizontalRoom), 0.0, 1.0);
      } else {
         relativeHorizontal = 0.5;
      }

      double relativeVertical;
      if (verticalRoom > 0.0) {
         relativeVertical = Mth.clamp(Mth.inverseLerp(entityPos.y - blockPos.getY(), 0.0, verticalRoom), 0.0, 1.0);
      } else {
         relativeVertical = 0.0;
      }

      Axis perpendicularAxis = axis == Axis.X ? Axis.Z : Axis.X;
      double perpendicularOffset = entityPos.get(perpendicularAxis) - (blockPos.get(perpendicularAxis) + 0.5);
      return new Vec3(relativeHorizontal, relativeVertical, perpendicularOffset);
   }

   public static DimensionTransition createDimensionTransition(
      ServerLevel level,
      FoundRectangle rectangle,
      Axis axis,
      Vec3 offset,
      Entity entity,
      Vec3 speed,
      float yRot,
      float xRot,
      DimensionTransition.PostDimensionTransition postTransition
   ) {
      BlockPos blockPos = rectangle.minCorner;
      BlockState state = level.getBlockState(blockPos);
      Axis targetAxis = state.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Axis.X);
      double horizontalRoom = rectangle.axis1Size;
      double verticalRoom = rectangle.axis2Size;
      EntityDimensions dimensions = entity.getDimensions(entity.getPose());
      int rotation = axis == targetAxis ? 0 : 90;
      Vec3 targetSpeed = axis == targetAxis ? speed : new Vec3(speed.z, speed.y, -speed.x);
      double targetHorizontal = dimensions.width() / 2.0 + (horizontalRoom - dimensions.width()) * offset.x();
      double targetVertical = (verticalRoom - dimensions.height()) * offset.y();
      double perpendicularOffset = 0.5 + offset.z();
      boolean xAxis = targetAxis == Axis.X;
      Vec3 targetPos = new Vec3(
         blockPos.getX() + (xAxis ? targetHorizontal : perpendicularOffset),
         blockPos.getY() + targetVertical,
         blockPos.getZ() + (xAxis ? perpendicularOffset : targetHorizontal)
      );
      Vec3 collisionFreePos = PortalShape.findCollisionFreePosition(targetPos, level, entity, dimensions);
      return new DimensionTransition(level, collisionFreePos, targetSpeed, yRot + rotation, xRot, postTransition);
   }
}

