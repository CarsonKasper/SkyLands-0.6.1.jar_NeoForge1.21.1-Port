package net.mcreator.flyingstuff;

import net.custom.flyingstuff.blocks.mHangingSignBlock;
import net.custom.flyingstuff.blocks.mStandingSignBlock;
import net.custom.flyingstuff.blocks.mWallHangingSignBlock;
import net.custom.flyingstuff.blocks.mWallSignBlock;
import net.custom.flyingstuff.blocks.signs.ModHangingSignBlockEntity;
import net.custom.flyingstuff.blocks.signs.ModSignBlockEntity;
import net.custom.flyingstuff.entity.ModBoatEntity;
import net.custom.flyingstuff.entity.ModChestBoatEntity;
import net.custom.flyingstuff.item.ModBoatItem;
import net.custom.flyingstuff.util.WoodTypes;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

@EventBusSubscriber(bus = Bus.MOD)
public class FlyingStuffModSigns {
   public static final RegistryObject<Block> GOLDEN_LEAVES_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("golden_leaves_sign", () -> new mStandingSignBlock(Properties.ofFullCopy(Blocks.OAK_SIGN), WoodTypes.GOLDEN_LEAVES));
   public static final RegistryObject<Block> GOLDEN_LEAVES_WALL_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("golden_leaves_wall_sign", () -> new mWallSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), WoodTypes.GOLDEN_LEAVES));
   public static final RegistryObject<Block> GOLDEN_LEAVES_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("golden_leaves_hanging_sign", () -> new mHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), WoodTypes.GOLDEN_LEAVES));
   public static final RegistryObject<Block> GOLDEN_LEAVES_WALL_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("golden_leaves_hanging_wall_sign", () -> new mWallHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.GOLDEN_LEAVES));
   public static final RegistryObject<Block> GLACIATED_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("glaciated_sign", () -> new mStandingSignBlock(Properties.ofFullCopy(Blocks.OAK_SIGN), WoodTypes.GLACIATED));
   public static final RegistryObject<Block> GLACIATED_WALL_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("glaciated_wall_sign", () -> new mWallSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), WoodTypes.GLACIATED));
   public static final RegistryObject<Block> GLACIATED_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("glaciated_hanging_sign", () -> new mHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), WoodTypes.GLACIATED));
   public static final RegistryObject<Block> GLACIATED_WALL_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("glaciated_hanging_wall_sign", () -> new mWallHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.GLACIATED));
   public static final RegistryObject<Block> LAVIC_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("lavic_sign", () -> new mStandingSignBlock(Properties.ofFullCopy(Blocks.OAK_SIGN), WoodTypes.LAVIC));
   public static final RegistryObject<Block> LAVIC_WALL_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("lavic_wall_sign", () -> new mWallSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), WoodTypes.LAVIC));
   public static final RegistryObject<Block> LAVIC_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("lavic_hanging_sign", () -> new mHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), WoodTypes.LAVIC));
   public static final RegistryObject<Block> LAVIC_WALL_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("lavic_hanging_wall_sign", () -> new mWallHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.LAVIC));
   public static final RegistryObject<Block> INKY_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("inky_sign", () -> new mStandingSignBlock(Properties.ofFullCopy(Blocks.OAK_SIGN), WoodTypes.INKY));
   public static final RegistryObject<Block> INKY_WALL_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("inky_wall_sign", () -> new mWallSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), WoodTypes.INKY));
   public static final RegistryObject<Block> INKY_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("inky_hanging_sign", () -> new mHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN), WoodTypes.INKY));
   public static final RegistryObject<Block> INKY_WALL_HANGING_SIGN = FlyingStuffModBlocks.REGISTRY
      .register("inky_hanging_wall_sign", () -> new mWallHangingSignBlock(Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.INKY));
   public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = FlyingStuffModBlockEntities.REGISTRY
      .register(
         "mod_sign",
         () -> Builder.of(
               ModSignBlockEntity::new,
               new Block[]{
                  (Block)GOLDEN_LEAVES_SIGN.get(),
                  (Block)GOLDEN_LEAVES_WALL_SIGN.get(),
                  (Block)GLACIATED_SIGN.get(),
                  (Block)GLACIATED_WALL_SIGN.get(),
                  (Block)LAVIC_SIGN.get(),
                  (Block)LAVIC_WALL_SIGN.get(),
                  (Block)INKY_SIGN.get(),
                  (Block)INKY_WALL_SIGN.get()
               }
            )
            .build(null)
      );
   public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = FlyingStuffModBlockEntities.REGISTRY
      .register(
         "mod_hanging_sign",
         () -> Builder.of(
               ModHangingSignBlockEntity::new,
               new Block[]{
                  (Block)GOLDEN_LEAVES_HANGING_SIGN.get(),
                  (Block)GOLDEN_LEAVES_WALL_HANGING_SIGN.get(),
                  (Block)GLACIATED_HANGING_SIGN.get(),
                  (Block)GLACIATED_WALL_HANGING_SIGN.get(),
                  (Block)LAVIC_HANGING_SIGN.get(),
                  (Block)LAVIC_WALL_HANGING_SIGN.get(),
                  (Block)INKY_HANGING_SIGN.get(),
                  (Block)INKY_WALL_HANGING_SIGN.get()
               }
            )
            .build(null)
      );
   public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = FlyingStuffModEntities.REGISTRY
      .register(
         "mod_boat",
         () -> net.minecraft.world.entity.EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("mod_boat")
      );
   public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT = FlyingStuffModEntities.REGISTRY
      .register(
         "mod_chest_boat",
         () -> net.minecraft.world.entity.EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
            .sized(1.375F, 0.5625F)
            .build("mod_chest_boat")
      );
   public static final RegistryObject<Item> GOLDEN_LEAVES_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "golden_leaves_sign",
         () -> new SignItem(new net.minecraft.world.item.Item.Properties().stacksTo(16), (Block)GOLDEN_LEAVES_SIGN.get(), (Block)GOLDEN_LEAVES_WALL_SIGN.get())
      );
   public static final RegistryObject<Item> GOLDEN_LEAVES_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "golden_leaves_hanging_sign",
         () -> new HangingSignItem(
            (Block)GOLDEN_LEAVES_HANGING_SIGN.get(), (Block)GOLDEN_LEAVES_WALL_HANGING_SIGN.get(), new net.minecraft.world.item.Item.Properties().stacksTo(16)
         )
      );
   public static final RegistryObject<Item> GLACIATED_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "glaciated_sign",
         () -> new SignItem(new net.minecraft.world.item.Item.Properties().stacksTo(16), (Block)GLACIATED_SIGN.get(), (Block)GLACIATED_WALL_SIGN.get())
      );
   public static final RegistryObject<Item> GLACIATED_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "glaciated_hanging_sign",
         () -> new HangingSignItem(
            (Block)GLACIATED_HANGING_SIGN.get(), (Block)GLACIATED_WALL_HANGING_SIGN.get(), new net.minecraft.world.item.Item.Properties().stacksTo(16)
         )
      );
   public static final RegistryObject<Item> LAVIC_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "lavic_sign", () -> new SignItem(new net.minecraft.world.item.Item.Properties().stacksTo(16), (Block)LAVIC_SIGN.get(), (Block)LAVIC_WALL_SIGN.get())
      );
   public static final RegistryObject<Item> LAVIC_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "lavic_hanging_sign",
         () -> new HangingSignItem(
            (Block)LAVIC_HANGING_SIGN.get(), (Block)LAVIC_WALL_HANGING_SIGN.get(), new net.minecraft.world.item.Item.Properties().stacksTo(16)
         )
      );
   public static final RegistryObject<Item> INKY_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "inky_sign", () -> new SignItem(new net.minecraft.world.item.Item.Properties().stacksTo(16), (Block)INKY_SIGN.get(), (Block)INKY_WALL_SIGN.get())
      );
   public static final RegistryObject<Item> INKY_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY
      .register(
         "inky_hanging_sign",
         () -> new HangingSignItem(
            (Block)INKY_HANGING_SIGN.get(), (Block)INKY_WALL_HANGING_SIGN.get(), new net.minecraft.world.item.Item.Properties().stacksTo(16)
         )
      );
   public static final RegistryObject<Item> GOLDEN_LEAVES_BOAT = FlyingStuffModItems.REGISTRY
      .register("golden_leaves_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.GOLDEN_LEAVES, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> GOLDEN_LEAVES_CHEST_BOAT = FlyingStuffModItems.REGISTRY
      .register("golden_leaves_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.GOLDEN_LEAVES, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> GLACIATED_BOAT = FlyingStuffModItems.REGISTRY
      .register("glaciated_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.GLACIATED, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> GLACIATED_CHEST_BOAT = FlyingStuffModItems.REGISTRY
      .register("glaciated_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.GLACIATED, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> LAVIC_BOAT = FlyingStuffModItems.REGISTRY
      .register("lavic_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.LAVIC, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> LAVIC_CHEST_BOAT = FlyingStuffModItems.REGISTRY
      .register("lavic_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.LAVIC, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> INKY_BOAT = FlyingStuffModItems.REGISTRY
      .register("inky_boat", () -> new ModBoatItem(false, ModBoatEntity.Type.INKY, new net.minecraft.world.item.Item.Properties()));
   public static final RegistryObject<Item> INKY_CHEST_BOAT = FlyingStuffModItems.REGISTRY
      .register("inky_chest_boat", () -> new ModBoatItem(true, ModBoatEntity.Type.INKY, new net.minecraft.world.item.Item.Properties()));

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
   }

   @EventBusSubscriber
   private static class ForgeBusEvents {
      @SubscribeEvent
      public static void serverLoad(ServerStartingEvent event) {
      }

      @OnlyIn(Dist.CLIENT)
      @SubscribeEvent
      public static void clientLoad(FMLClientSetupEvent event) {
         Sheets.addWoodType(WoodTypes.GOLDEN_LEAVES);
         Sheets.addWoodType(WoodTypes.GLACIATED);
         Sheets.addWoodType(WoodTypes.LAVIC);
         Sheets.addWoodType(WoodTypes.INKY);
      }
   }
}

