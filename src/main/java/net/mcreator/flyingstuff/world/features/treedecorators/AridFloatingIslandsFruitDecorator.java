package net.mcreator.flyingstuff.world.features.treedecorators;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class AridFloatingIslandsFruitDecorator extends TreeDecorator {
   public static final MapCodec<AridFloatingIslandsFruitDecorator> CODEC = MapCodec.unit(new AridFloatingIslandsFruitDecorator());
   public static final TreeDecoratorType<AridFloatingIslandsFruitDecorator> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

   @SubscribeEvent
   public static void registerTreeDecorator(RegisterEvent event) {
      event.register(net.minecraftforge.registries.ForgeRegistries.Keys.TREE_DECORATOR_TYPES, helper -> helper.register(ResourceLocation.fromNamespaceAndPath("flying_stuff", "arid_floating_islands_tree_fruit_decorator"), DECORATOR_TYPE));
   }

   @Override
   protected TreeDecoratorType<?> type() {
      return DECORATOR_TYPE;
   }

   @Override
   public void place(Context context) {
   }
}
