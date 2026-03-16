package net.mcreator.flyingstuff.init;
import java.util.function.Supplier;
import net.mcreator.flyingstuff.block.entity.AbyssalDoorTileEntity;
import net.mcreator.flyingstuff.block.entity.AridRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.AridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenRewardDispencerTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.GoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicRewardDispenserTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.LavicSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel0ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenAridSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGlaciatedSkyLvl2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenGoldenSkyLevel2ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.OpenLavicSkyLvl1ChestTileEntity;
import net.mcreator.flyingstuff.block.entity.ProtoChestTileEntity;
import net.mcreator.flyingstuff.block.entity.WalkableAbyssalDoorTileEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FlyingStuffModBlockEntities {
   public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "flying_stuff");
   public static final Supplier<BlockEntityType<GoldenSkyLevel1ChestTileEntity>> GOLDEN_SKY_LEVEL_1_CHEST = REGISTRY.register(
      "golden_sky_level_1_chest",
      () -> Builder.of(GoldenSkyLevel1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GOLDEN_SKY_LEVEL_1_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenGoldenSkyLevel1ChestTileEntity>> OPEN_GOLDEN_SKY_LEVEL_1_CHEST = REGISTRY.register(
      "open_golden_sky_level_1_chest",
      () -> Builder.of(OpenGoldenSkyLevel1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_GOLDEN_SKY_LEVEL_1_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<GoldenSkyLevel2ChestTileEntity>> GOLDEN_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "golden_sky_level_2_chest",
      () -> Builder.of(GoldenSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GOLDEN_SKY_LEVEL_2_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenGoldenSkyLevel2ChestTileEntity>> OPEN_GOLDEN_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "open_golden_sky_level_2_chest",
      () -> Builder.of(OpenGoldenSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_GOLDEN_SKY_LEVEL_2_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<GlaciatedSkyLevel1ChestTileEntity>> GLACIATED_SKY_LEVEL_1_CHEST = REGISTRY.register(
      "glaciated_sky_level_1_chest",
      () -> Builder.of(GlaciatedSkyLevel1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GLACIATED_SKY_LEVEL_1_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<OpenGlaciatedSkyLevel1ChestTileEntity>> OPEN_GLACIATED_SKY_LEVEL_1_CHEST = REGISTRY.register(
      "open_glaciated_sky_level_1_chest",
      () -> Builder.of(OpenGlaciatedSkyLevel1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_GLACIATED_SKY_LEVEL_1_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<GlaciatedSkyLevel2ChestTileEntity>> GLACIATED_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "glaciated_sky_level_2_chest",
      () -> Builder.of(GlaciatedSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GLACIATED_SKY_LEVEL_2_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<OpenGlaciatedSkyLevel2ChestTileEntity>> OPEN_GLACIATED_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "open_glaciated_sky_level_2_chest",
      () -> Builder.of(OpenGlaciatedSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_GLACIATED_SKY_LEVEL_2_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<LavicSkyLvl1ChestTileEntity>> LAVIC_SKY_LVL_1_CHEST = REGISTRY.register(
      "lavic_sky_lvl_1_chest",
      () -> Builder.of(LavicSkyLvl1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.LAVIC_SKY_LVL_1_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenLavicSkyLvl1ChestTileEntity>> OPEN_LAVIC_SKY_LVL_1_CHEST = REGISTRY.register(
      "open_lavic_sky_lvl_1_chest",
      () -> Builder.of(OpenLavicSkyLvl1ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_LAVIC_SKY_LVL_1_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<LavicSkyLvl2ChestTileEntity>> LAVIC_SKY_LVL_2_CHEST = REGISTRY.register(
      "lavic_sky_lvl_2_chest",
      () -> Builder.of(LavicSkyLvl2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.LAVIC_SKY_LVL_2_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenGlaciatedSkyLvl2ChestTileEntity>> OPEN_LAVIC_SKY_LVL_2_CHEST = REGISTRY.register(
      "open_lavic_sky_lvl_2_chest",
      () -> Builder.of(OpenGlaciatedSkyLvl2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_LAVIC_SKY_LVL_2_CHEST.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<AridSkyLevel0ChestTileEntity>> ARID_SKY_LEVEL_0_CHEST = REGISTRY.register(
      "arid_sky_level_0_chest",
      () -> Builder.of(AridSkyLevel0ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.ARID_SKY_LEVEL_0_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenAridSkyLevel0ChestTileEntity>> OPEN_ARID_SKY_LEVEL_0_CHEST = REGISTRY.register(
      "open_arid_sky_level_0_chest",
      () -> Builder.of(OpenAridSkyLevel0ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_ARID_SKY_LEVEL_0_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<AridSkyLevel2ChestTileEntity>> ARID_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "arid_sky_level_2_chest",
      () -> Builder.of(AridSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.ARID_SKY_LEVEL_2_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<OpenAridSkyLevel2ChestTileEntity>> OPEN_ARID_SKY_LEVEL_2_CHEST = REGISTRY.register(
      "open_arid_sky_level_2_chest",
      () -> Builder.of(OpenAridSkyLevel2ChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.OPEN_ARID_SKY_LEVEL_2_CHEST.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<GoldenRewardDispencerTileEntity>> GOLDEN_REWARD_DISPENCER = REGISTRY.register(
      "golden_reward_dispencer",
      () -> Builder.of(GoldenRewardDispencerTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GOLDEN_REWARD_DISPENCER.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<GlaciatedRewardDispenserTileEntity>> GLACIATED_REWARD_DISPENSER = REGISTRY.register(
      "glaciated_reward_dispenser",
      () -> Builder.of(GlaciatedRewardDispenserTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.GLACIATED_REWARD_DISPENSER.get()})
         .build(null)
   );
   public static final Supplier<BlockEntityType<LavicRewardDispenserTileEntity>> LAVIC_REWARD_DISPENSER = REGISTRY.register(
      "lavic_reward_dispenser",
      () -> Builder.of(LavicRewardDispenserTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.LAVIC_REWARD_DISPENSER.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<AridRewardDispenserTileEntity>> ARID_REWARD_DISPENSER = REGISTRY.register(
      "arid_reward_dispenser",
      () -> Builder.of(AridRewardDispenserTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.ARID_REWARD_DISPENSER.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<AbyssalDoorTileEntity>> ABYSSAL_DOOR = REGISTRY.register(
      "abyssal_door", () -> Builder.of(AbyssalDoorTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.ABYSSAL_DOOR.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<WalkableAbyssalDoorTileEntity>> WALKABLE_ABYSSAL_DOOR = REGISTRY.register(
      "walkable_abyssal_door",
      () -> Builder.of(WalkableAbyssalDoorTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.WALKABLE_ABYSSAL_DOOR.get()}).build(null)
   );
   public static final Supplier<BlockEntityType<ProtoChestTileEntity>> PROTO_CHEST = REGISTRY.register(
      "proto_chest", () -> Builder.of(ProtoChestTileEntity::new, new Block[]{(Block)FlyingStuffModBlocks.PROTO_CHEST.get()}).build(null)
   );

   private static Supplier<BlockEntityType<?>> register(String registryname, Supplier<Block> block, BlockEntitySupplier<?> supplier) {
      return REGISTRY.register(registryname, () -> Builder.of(supplier, new Block[]{(Block)block.get()}).build(null));
   }
}


