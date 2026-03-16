package net.mcreator.flyingstuff.block;

import java.util.Optional;
import javax.annotation.Nullable;
import net.mcreator.flyingstuff.world.teleporter.UnderGroundPortalShape;
import net.mcreator.flyingstuff.world.teleporter.UnderGroundTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.portal.DimensionTransition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class UnderGroundPortalBlock extends NetherPortalBlock {
   public UnderGroundPortalBlock() {
      super(
         Properties.of()
            .noCollission()
            .randomTicks()
            .pushReaction(PushReaction.BLOCK)
            .strength(-1.0F)
            .sound(SoundType.GLASS)
            .lightLevel(state -> 0)
            .noLootTable()
      );
   }

   @Override
   public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
   }

   public static void portalSpawn(Level world, BlockPos pos) {
      Optional<UnderGroundPortalShape> optional = UnderGroundPortalShape.findEmptyPortalShape(world, pos, Axis.X);
      optional.ifPresent(UnderGroundPortalShape::createPortalBlocks);
   }

   @OnlyIn(Dist.CLIENT)
   @Override
   public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
      for (int i = 0; i < 4; i++) {
         double px = pos.getX() + random.nextDouble();
         double py = pos.getY() + random.nextDouble();
         double pz = pos.getZ() + random.nextDouble();
         double vx = (random.nextDouble() - 0.5) / 2.0;
         double vy = (random.nextDouble() - 0.5) / 2.0;
         double vz = (random.nextDouble() - 0.5) / 2.0;
         int offset = random.nextInt(4) - 1;
         if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
            px = pos.getX() + 0.5 + 0.25 * offset;
            vx = random.nextDouble() * 2.0F * offset;
         } else {
            pz = pos.getZ() + 0.5 + 0.25 * offset;
            vz = random.nextDouble() * 2.0F * offset;
         }

         world.addParticle(ParticleTypes.PORTAL, px, py, pz, vx, vy, vz);
      }
   }

   @Override
   protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
      if (entity.canUsePortal(false) && !entity.level().isClientSide()) {
         entity.setAsInsidePortal(this, pos);
      }
   }

   @Nullable
   @Override
   public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
      ResourceKey<Level> destinationType = level.dimension() != ResourceKey.create(
            Registries.DIMENSION, ResourceLocation.parse("flying_stuff:under_ground")
         )
         ? ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("flying_stuff:under_ground"))
         : Level.OVERWORLD;
      ServerLevel destinationLevel = level.getServer().getLevel(destinationType);
      return destinationLevel == null ? null : new UnderGroundTeleporter(destinationLevel, pos).getPortalDestination(entity, destinationLevel);
   }
}

