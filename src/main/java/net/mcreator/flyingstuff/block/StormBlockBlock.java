package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.StormBlockOnBlockRightClickedProcedure;
import net.mcreator.flyingstuff.procedures.StormBlockUpdateTickProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class StormBlockBlock extends Block {
   public StormBlockBlock() {
      super(
         Properties.of()
            .sound(SoundType.AMETHYST)
            .strength(-1.0F, 3600000.0F)
            .lightLevel(s -> 15)
            .requiresCorrectToolForDrops()
            .randomTicks()
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
      );
   }

   public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 15;
   }

   public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
      super.onPlace(blockstate, world, pos, oldState, moving);
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
      super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
      super.randomTick(blockstate, world, pos, random);
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      StormBlockUpdateTickProcedure.execute(world, x, y, z);
   }

   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
      super.animateTick(blockstate, world, pos, random);
      Player entity = Minecraft.getInstance().player;
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      StormBlockUpdateTickProcedure.execute(world, x, y, z);
   }

   public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState blockstate, Player entity) {
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
      return super.playerWillDestroy(world, pos, blockstate, entity);
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
      super.stepOn(world, pos, blockstate, entity);
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
      super.onProjectileHit(world, blockstate, hit, entity);
      StormBlockUpdateTickProcedure.execute(world, hit.getBlockPos().getX(), hit.getBlockPos().getY(), hit.getBlockPos().getZ());
   }

   public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
      super.setPlacedBy(world, pos, blockstate, entity, itemstack);
      StormBlockUpdateTickProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
   }

   public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      double hitX = hit.getLocation().x;
      double hitY = hit.getLocation().y;
      double hitZ = hit.getLocation().z;
      Direction direction = hit.getDirection();
      StormBlockOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
      return InteractionResult.sidedSuccess(world.isClientSide());
   }
}


