package net.mcreator.flyingstuff.block.listener;

import net.mcreator.flyingstuff.block.renderer.AbyssalDoorTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridSkyLevel0ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.AridSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GlaciatedSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenRewardDispencerTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.GoldenSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicRewardDispenserTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicSkyLvl1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.LavicSkyLvl2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenAridSkyLevel0ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenAridSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGlaciatedSkyLvl2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGoldenSkyLevel1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenGoldenSkyLevel2ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.OpenLavicSkyLvl1ChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.ProtoChestTileRenderer;
import net.mcreator.flyingstuff.block.renderer.WalkableAbyssalDoorTileRenderer;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = "flying_stuff", bus = Bus.MOD)
public class ClientListener {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void registerRenderers(RegisterRenderers event) {
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GOLDEN_SKY_LEVEL_1_CHEST.get(), context -> new GoldenSkyLevel1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_GOLDEN_SKY_LEVEL_1_CHEST.get(), context -> new OpenGoldenSkyLevel1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GOLDEN_SKY_LEVEL_2_CHEST.get(), context -> new GoldenSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_GOLDEN_SKY_LEVEL_2_CHEST.get(), context -> new OpenGoldenSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GLACIATED_SKY_LEVEL_1_CHEST.get(), context -> new GlaciatedSkyLevel1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_GLACIATED_SKY_LEVEL_1_CHEST.get(), context -> new OpenGlaciatedSkyLevel1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GLACIATED_SKY_LEVEL_2_CHEST.get(), context -> new GlaciatedSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_GLACIATED_SKY_LEVEL_2_CHEST.get(), context -> new OpenGlaciatedSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.LAVIC_SKY_LVL_1_CHEST.get(), context -> new LavicSkyLvl1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_LAVIC_SKY_LVL_1_CHEST.get(), context -> new OpenLavicSkyLvl1ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.LAVIC_SKY_LVL_2_CHEST.get(), context -> new LavicSkyLvl2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_LAVIC_SKY_LVL_2_CHEST.get(), context -> new OpenGlaciatedSkyLvl2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.ARID_SKY_LEVEL_0_CHEST.get(), context -> new AridSkyLevel0ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_ARID_SKY_LEVEL_0_CHEST.get(), context -> new OpenAridSkyLevel0ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.ARID_SKY_LEVEL_2_CHEST.get(), context -> new AridSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.OPEN_ARID_SKY_LEVEL_2_CHEST.get(), context -> new OpenAridSkyLevel2ChestTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GOLDEN_REWARD_DISPENCER.get(), context -> new GoldenRewardDispencerTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.GLACIATED_REWARD_DISPENSER.get(), context -> new GlaciatedRewardDispenserTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.LAVIC_REWARD_DISPENSER.get(), context -> new LavicRewardDispenserTileRenderer()
      );
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.ARID_REWARD_DISPENSER.get(), context -> new AridRewardDispenserTileRenderer()
      );
      event.registerBlockEntityRenderer((BlockEntityType)FlyingStuffModBlockEntities.ABYSSAL_DOOR.get(), context -> new AbyssalDoorTileRenderer());
      event.registerBlockEntityRenderer(
         (BlockEntityType)FlyingStuffModBlockEntities.WALKABLE_ABYSSAL_DOOR.get(), context -> new WalkableAbyssalDoorTileRenderer()
      );
      event.registerBlockEntityRenderer((BlockEntityType)FlyingStuffModBlockEntities.PROTO_CHEST.get(), context -> new ProtoChestTileRenderer());
   }
}
