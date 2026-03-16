package net.mcreator.flyingstuff.block;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PolishedLavicSkyrockBlock extends Block {
   public PolishedLavicSkyrockBlock() {
      super(Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.1F, 12.0F).requiresCorrectToolForDrops());
   }

   public void appendHoverText(ItemStack itemstack, net.minecraft.world.item.Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, context, list, flag);
      list.add(Component.literal("could be used to unlock some secret WIP feature"));
   }

   public int m_7753_(BlockState state, BlockGetter worldIn, BlockPos pos) {
      return 1;
   }
}


