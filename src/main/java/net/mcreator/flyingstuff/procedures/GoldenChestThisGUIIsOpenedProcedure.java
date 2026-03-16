package net.mcreator.flyingstuff.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.registries.ForgeRegistries;

public class GoldenChestThisGUIIsOpenedProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof Level _level) {
         if (!_level.isClientSide()) {
            _level.playSound(
               null,
               BlockPos.containing(x, y, z),
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.get(ResourceLocation.parse("flying_stuff:sky_chest_open")),
               SoundSource.BLOCKS,
               0.5F,
               1.0F
            );
         } else {
            _level.playLocalSound(
               x,
               y,
               z,
               (SoundEvent)ForgeRegistries.SOUND_EVENTS.get(ResourceLocation.parse("flying_stuff:sky_chest_open")),
               SoundSource.BLOCKS,
               0.5F,
               1.0F,
               false
            );
         }
      }

      BlockPos _pos = BlockPos.containing(x, y, z);
      BlockState _bs = world.getBlockState(_pos);
      if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp) {
         world.setBlock(_pos, (BlockState)_bs.setValue(_integerProp, 0), 3);
      }

      int _value = 1;
      BlockPos _posx = BlockPos.containing(x, y, z);
      BlockState _bsx = world.getBlockState(_posx);
      if (_bsx.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value)) {
         world.setBlock(_posx, (BlockState)_bsx.setValue(_integerProp, _value), 3);
      }
   }
}



