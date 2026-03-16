package net.mcreator.flyingstuff.block;

import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.mcreator.flyingstuff.procedures.MoltenMetalMobplayerCollidesBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoltenMetalBlock extends LiquidBlock {
   public MoltenMetalBlock() {
      super(
         (FlowingFluid)FlyingStuffModFluids.MOLTEN_METAL.get(),
         Properties.of()
            .mapColor(MapColor.FIRE)
            .strength(100.0F)
            .isViewBlocking((bs, br, bp) -> true)
            .isSuffocating((bs, br, bp) -> true)
            .lightLevel(s -> 15)
            .noCollission()
            
            
            .pushReaction(PushReaction.DESTROY)
            
            .replaceable()
      );
   }

   public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
      super.entityInside(blockstate, world, pos, entity);
      MoltenMetalMobplayerCollidesBlockProcedure.execute(entity);
   }
}
