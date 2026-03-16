package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.procedures.CloudBlockBlockAddedProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class CloudBlockBlock extends Block {
   public CloudBlockBlock() {
      super(
         Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .mapColor(MapColor.SNOW)
            .sound(SoundType.WOOL)
            .strength(0.1F, 1.0F)
            .noCollission()
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
      );
   }

   public boolean m_6104_(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
   }

   public boolean m_7420_(BlockState state, BlockGetter reader, BlockPos pos) {
      return true;
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 0;
   }

   public VoxelShape m_5909_(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   @OnlyIn(Dist.CLIENT)
   public void m_214162_(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
      super.animateTick(blockstate, world, pos, random);
      Player entity = Minecraft.getInstance().player;
      int x = pos.getX();
      int y = pos.getY();
      int z = pos.getZ();
      CloudBlockBlockAddedProcedure.execute(world, x, y, z);
   }
}
