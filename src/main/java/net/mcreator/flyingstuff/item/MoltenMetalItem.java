package net.mcreator.flyingstuff.item;

import net.mcreator.flyingstuff.init.FlyingStuffModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item.Properties;

public class MoltenMetalItem extends BucketItem {
   public MoltenMetalItem() {
      super(FlyingStuffModFluids.MOLTEN_METAL.get(), new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
   }
}

