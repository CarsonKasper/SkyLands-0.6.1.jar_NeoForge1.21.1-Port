package net.mcreator.flyingstuff.world.features.treedecorators;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class GlaciatedFliningIslandsTrunkDecorator extends TreeDecorator {
   public static final MapCodec<GlaciatedFliningIslandsTrunkDecorator> CODEC = MapCodec.unit(new GlaciatedFliningIslandsTrunkDecorator());
   public static final TreeDecoratorType<GlaciatedFliningIslandsTrunkDecorator> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

   @SubscribeEvent
   public static void registerTreeDecorator(RegisterEvent event) {
   }

   @Override
   protected TreeDecoratorType<?> type() {
      return DECORATOR_TYPE;
   }

   @Override
   public void place(Context context) {
   }
}
