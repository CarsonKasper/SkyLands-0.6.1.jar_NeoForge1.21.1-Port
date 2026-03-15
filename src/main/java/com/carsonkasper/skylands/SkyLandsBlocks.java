package com.carsonkasper.skylands;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class SkyLandsBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SkyLandsMod.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SkyLandsMod.MODID);
    public static final List<Supplier<? extends Item>> CREATIVE_ORDER = new ArrayList<>();

    private static final BlockBehaviour.Properties SKYROCK_PROPS = stone(MapColor.TERRACOTTA_WHITE);
    private static final BlockBehaviour.Properties SKY_SANDSTONE_PROPS = stone(MapColor.SAND);
    private static final BlockBehaviour.Properties GLACIATED_PROPS = stone(MapColor.ICE);
    private static final BlockBehaviour.Properties LAVIC_PROPS = stone(MapColor.NETHER);
    private static final BlockBehaviour.Properties SULFUR_PROPS = stone(MapColor.COLOR_YELLOW);
    private static final BlockBehaviour.Properties GRIMSTONE_PROPS = stone(MapColor.COLOR_GRAY);
    private static final BlockBehaviour.Properties CELESTIUM_PROPS = stone(MapColor.COLOR_CYAN);
    private static final BlockBehaviour.Properties WOOD_PROPS = wood(MapColor.WOOD);
    private static final BlockBehaviour.Properties GRASSY_TOPSOIL_PROPS = grassyTopsoil();
    private static final BlockBehaviour.Properties SWAMPY_TOPSOIL_PROPS = swampyTopsoil();
    private static final BlockBehaviour.Properties LAVIC_TOPSOIL_PROPS = lavicTopsoil();
    private static final BlockBehaviour.Properties GLOWING_TOPSOIL_PROPS = glowingTopsoil();
    private static final BlockBehaviour.Properties LEAF_PROPS = leaves();
    private static final BlockBehaviour.Properties PLANT_PROPS = plant();

    public static final DeferredBlock<Block> SKYROCK = cube("skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> SKYROCK_STAIRS = stairs("skyrock_stairs", SKYROCK, SKYROCK_PROPS);
    public static final DeferredBlock<Block> SKYROCK_SLAB = slab("skyrock_slab", SKYROCK_PROPS);
    public static final DeferredBlock<Block> SKYROCK_WALL = wall("skyrock_wall", SKYROCK_PROPS);
    public static final DeferredBlock<Block> MOSSY_SKYROCK = cube("mossy_skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> COBBLED_SKYROCK = cube("cobbled_skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> COBBLED_SKYROCK_STAIRS = stairs("cobbled_skyrock_stairs", COBBLED_SKYROCK, SKYROCK_PROPS);
    public static final DeferredBlock<Block> COBBLED_SKYROCK_SLAB = slab("cobbled_skyrock_slab", SKYROCK_PROPS);
    public static final DeferredBlock<Block> COBBLED_SKYROCK_WALL = wall("cobbled_skyrock_wall", SKYROCK_PROPS);
    public static final DeferredBlock<Block> TILED_SKYROCK = cube("tiled_skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> TILED_SKYROCK_STAIRS = stairs("tiled_skyrock_stairs", TILED_SKYROCK, SKYROCK_PROPS);
    public static final DeferredBlock<Block> TILED_SKYROCK_SLAB = slab("tiled_skyrock_slab", SKYROCK_PROPS);
    public static final DeferredBlock<Block> MOSSY_TILED_SKYROCK = cube("mossy_tiled_skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKYROCK = cube("polished_skyrock", SKYROCK_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKYROCK_STAIRS = stairs("polished_skyrock_stairs", POLISHED_SKYROCK, SKYROCK_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKYROCK_SLAB = slab("polished_skyrock_slab", SKYROCK_PROPS);
    public static final DeferredBlock<Block> CHISELED_SKYROCK = cube("chiseled_skyrock", SKYROCK_PROPS);

    public static final DeferredBlock<Block> SKY_SANDSTONE = cube("sky_sandstone", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_STAIRS = stairs("sky_sandstone_stairs", SKY_SANDSTONE, SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_SLAB = slab("sky_sandstone_slab", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_WALL = wall("sky_sandstone_wall", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_BRICKS = cube("sky_sandstone_bricks", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_BRICK_STAIRS = stairs("sky_sandstone_brick_stairs", SKY_SANDSTONE_BRICKS, SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SANDSTONE_BRICK_SLAB = slab("sky_sandstone_brick_slab", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKY_SANDSTONE = cube("polished_sky_sandstone", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKY_SANDSTONE_STAIRS = stairs("polished_sky_sandstone_stairs", POLISHED_SKY_SANDSTONE, SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_SKY_SANDSTONE_SLAB = slab("polished_sky_sandstone_slab", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> CHISELED_SKY_SANDSTONE = cube("chiseled_sky_sandstone", SKY_SANDSTONE_PROPS);
    public static final DeferredBlock<Block> SKY_SAND = cube("sky_sand", SKY_SANDSTONE_PROPS);

    public static final DeferredBlock<Block> GLACIATED_SKYROCK = cube("glaciated_skyrock", GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCK_STAIRS = stairs("glaciated_skyrock_stairs", GLACIATED_SKYROCK, GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCKSLAB = slab("glaciated_skyrockslab", GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCK_WALL = wall("glaciated_skyrock_wall", GLACIATED_PROPS);
    public static final DeferredBlock<Block> MOSSY_GLACIATED_SKYROCK = cube("mossy_glaciated_skyrock", GLACIATED_PROPS);
    public static final DeferredBlock<Block> COBBLED_GLACIATED_SKYROCK = cube("cobbled_glaciated_skyrock", GLACIATED_PROPS);
    public static final DeferredBlock<Block> COBBLED_GLACIATED_SKYROCK_STAIRS = stairs("cobbled_glaciated_skyrock_stairs", COBBLED_GLACIATED_SKYROCK, GLACIATED_PROPS);
    public static final DeferredBlock<Block> COBBLED_GLACIATED_SKYROCK_SLAB = slab("cobbled_glaciated_skyrock_slab", GLACIATED_PROPS);
    public static final DeferredBlock<Block> COBBLED_GLACIATED_SKYROCKWALL = wall("cobbled_glaciated_skyrockwall", GLACIATED_PROPS);
    public static final DeferredBlock<Block> POLISHED_GLACITATED_SKYROCK = cube("polished_glacitated_skyrock", GLACIATED_PROPS);
    public static final DeferredBlock<Block> POLISHED_GLACIATED_SKYROCK_STAIRS = stairs("polished_glaciated_skyrock_stairs", POLISHED_GLACITATED_SKYROCK, GLACIATED_PROPS);
    public static final DeferredBlock<Block> POLISHED_GLACIATED_SKYROCK_SLAB = slab("polished_glaciated_skyrock_slab", GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCK_BRICKS = cube("glaciated_skyrock_bricks", GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCK_BRICKS_STAIRS = stairs("glaciated_skyrock_bricks_stairs", GLACIATED_SKYROCK_BRICKS, GLACIATED_PROPS);
    public static final DeferredBlock<Block> GLACIATED_SKYROCK_BRICKS_SLAB = slab("glaciated_skyrock_bricks_slab", GLACIATED_PROPS);
    public static final DeferredBlock<Block> MOSSY_GLACIATED_SKYROCK_BRICKS = cube("mossy_glaciated_skyrock_bricks", GLACIATED_PROPS);
    public static final DeferredBlock<Block> CHISELED_GLACIATED_SKYROCK = cube("chiseled_glaciated_skyrock", GLACIATED_PROPS);

    public static final DeferredBlock<Block> LAVIC_SKYROCK = cube("lavic_skyrock", LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_STAIRCASE = stairs("lavic_skyrock_staircase", LAVIC_SKYROCK, LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_SLAB = slab("lavic_skyrock_slab", LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_WALLS = wall("lavic_skyrock_walls", LAVIC_PROPS);
    public static final DeferredBlock<Block> POLISHED_LAVIC_SKYROCK = cube("polished_lavic_skyrock", LAVIC_PROPS);
    public static final DeferredBlock<Block> POLISHED_LAVIC_SKYROCK_STAIRCASE = stairs("polished_lavic_skyrock_staircase", POLISHED_LAVIC_SKYROCK, LAVIC_PROPS);
    public static final DeferredBlock<Block> POLISHED_LAVIC_SKYROCK_SLAB = slab("polished_lavic_skyrock_slab", LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_BRICKS = cube("lavic_skyrock_bricks", LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_BRICKS_STAIRCASE = stairs("lavic_skyrock_bricks_staircase", LAVIC_SKYROCK_BRICKS, LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_BRICKS_SLAB = slab("lavic_skyrock_bricks_slab", LAVIC_PROPS);
    public static final DeferredBlock<Block> LAVIC_SKYROCK_TILES = cube("lavic_skyrock_tiles", LAVIC_PROPS);
    public static final DeferredBlock<Block> SULFUR_SAND = cube("sulfur_sand", SULFUR_PROPS);
    public static final DeferredBlock<Block> SULFUR_BLOCK = cube("sulfur_block", SULFUR_PROPS);

    public static final DeferredBlock<Block> GRIMSTONE = cube("grimstone", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_STAIRS = stairs("grimstone_stairs", GRIMSTONE, GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_SLAB = slab("grimstone_slab", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_WALL = wall("grimstone_wall", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_GRIMSTONE = cube("polished_grimstone", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_GRIMSTONE_STAIRS = stairs("polished_grimstone_stairs", POLISHED_GRIMSTONE, GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> POLISHED_GRIMSTONE_SLAB = slab("polished_grimstone_slab", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_BRICKS = cube("grimstone_bricks", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_BRICKS_STAIRS = stairs("grimstone_bricks_stairs", GRIMSTONE_BRICKS, GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_BRICKS_SLAB = slab("grimstone_bricks_slab", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_TILES = cube("grimstone_tiles", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_TILES_STAIRS = stairs("grimstone_tiles_stairs", GRIMSTONE_TILES, GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> GRIMSTONE_TILES_SLAB = slab("grimstone_tiles_slab", GRIMSTONE_PROPS);
    public static final DeferredBlock<Block> CHISELED_GRIMSTONE = cube("chiseled_grimstone", GRIMSTONE_PROPS);

    static {
        // Skyrock family extras.
        cube("cherry_mossy_skyrock", SKYROCK_PROPS);
        cube("cherry_mossy_tiled_skyrock", SKYROCK_PROPS);
        pillar("skyrock_column_base", SKYROCK_PROPS);
        pillar("skyrockcolumn", SKYROCK_PROPS);

        // Golden biome plants and wood set.
        solidHorizontalFacing("fiery_grass_block", GRASSY_TOPSOIL_PROPS);
        plantBlock("fiery_grass");
        plantBlock("fiery_short_grass");
        doublePlant("golden_fern");
        plantBlock("blow_flower");
        doublePlant("smoke_flower_plant");
        doublePlant("smoke_flower_plant_grow_stage");
        plantBlock("float_grape_plant");
        sapling("firey_tree_sapling");
        leavesBlock("fiery_leaves");
        solidHorizontalFacing("cherry_grass_block", GRASSY_TOPSOIL_PROPS);
        plantBlock("cherry_grass");
        plantBlock("cherry_short_grass");
        pillar("fiery_log", WOOD_PROPS);
        pillar("fiery_wood", WOOD_PROPS);
        pillar("stripped_fierylog", WOOD_PROPS);
        pillar("stripped_fiery_wood", WOOD_PROPS);
        cube("f_iery_planks", WOOD_PROPS);
        stairs("fiery_planks_stairs", holder("f_iery_planks"), WOOD_PROPS);
        slab("fiery_planks_slab", WOOD_PROPS);
        fence("fiery_planks_fence", WOOD_PROPS);
        door("fiery_planks_door", BlockSetType.OAK, WOOD_PROPS);
        trapdoor("fiery_planks_trapdoor", BlockSetType.OAK, WOOD_PROPS);
        pressurePlate("fiery_pressure_plate", BlockSetType.OAK, WOOD_PROPS);
        button("fiery_button", BlockSetType.OAK, WOOD_PROPS);
        cube("celestiumore", CELESTIUM_PROPS);
        cube("celestium_block", CELESTIUM_PROPS);
        faceAttached("celestium_spike", CELESTIUM_PROPS);
        faceAttached("celestium_antenna", CELESTIUM_PROPS);

        // Glaciated family and swamp variants.
        cube("mossy_swampy_skyrock", GLACIATED_PROPS);
        cube("mossy_swampy_skyrock_bricks", GLACIATED_PROPS);
        pillar("glaciated_skyrock_pillar_base", GLACIATED_PROPS);
        pillar("glaciated_skyrock_pillar", GLACIATED_PROPS);
        cube("cristalizedice", GLACIATED_PROPS);
        cube("glaciated_grass_block", GRASSY_TOPSOIL_PROPS);
        plantBlock("short_glaciated_grass");
        plantBlock("tall_glaciated_grass");
        doublePlant("glaciated_fern");
        sapling("glaciated_tree_sapling");
        plantBlock("warmth_radish_plant");
        faceAttached("ice_spikes", GLACIATED_PROPS);
        leavesBlock("glaciated_leaves");
        cube("swampy_grass_block", SWAMPY_TOPSOIL_PROPS);
        plantBlock("swampy_grass");
        doublePlant("swampy_bush");
        doublePlant("swampy_water_plant");
        pillar("glaciated_log", WOOD_PROPS);
        pillar("glaciated_wood", WOOD_PROPS);
        pillar("stripped_glaciatedlog", WOOD_PROPS);
        pillar("stripped_glaciated_wood", WOOD_PROPS);
        cube("glaciated_planks", WOOD_PROPS);
        stairs("glaciated_planks_stairs", holder("glaciated_planks"), WOOD_PROPS);
        slab("glaciated_planks_slab", WOOD_PROPS);
        fence("glaciated_planks_fence", WOOD_PROPS);
        door("glaciated_planks_door", BlockSetType.OAK, WOOD_PROPS);
        trapdoor("glaciated_planks_trapdoor", BlockSetType.OAK, WOOD_PROPS);
        pressurePlate("glaciated_wood_pressure_plate", BlockSetType.OAK, WOOD_PROPS);
        button("glaciated_wood_button", BlockSetType.OAK, WOOD_PROPS);
        cube("amber_celestium_ore", CELESTIUM_PROPS);
        cube("amber_celestium_block", CELESTIUM_PROPS);
        faceAttached("amber_celestium_spike", CELESTIUM_PROPS);
        faceAttached("amber_celestium_antenna", CELESTIUM_PROPS);

        // Lavic family.
        cube("lavic_skyrock_grates", LAVIC_PROPS);
        pillar("lavic_skyrock_pipe", LAVIC_PROPS);
        cube("lavic_skymetal_grass", LAVIC_TOPSOIL_PROPS);
        plantBlock("short_lavic_grass");
        plantBlock("metallic_shorter_grass");
        doublePlant("lavic_mushrooms");
        sapling("lavic_tree_sapling");
        leavesBlock("lavic_fungus_block");
        pillar("lavic_stem", WOOD_PROPS);
        pillar("lavic_wood", WOOD_PROPS);
        pillar("stripped_lavic_stem", WOOD_PROPS);
        pillar("stripped_lavic_wood", WOOD_PROPS);
        cube("lavic_planks", WOOD_PROPS);
        stairs("lavic_planks_staircase", holder("lavic_planks"), WOOD_PROPS);
        slab("lavic_planks_slab", WOOD_PROPS);
        fence("lavic_planks_fence", WOOD_PROPS);
        door("lavic_planks_door", BlockSetType.OAK, WOOD_PROPS);
        trapdoor("lavic_planks_trapdoor", BlockSetType.OAK, WOOD_PROPS);
        pressurePlate("lavic_pressure_plate", BlockSetType.OAK, WOOD_PROPS);
        button("lavic_button", BlockSetType.OAK, WOOD_PROPS);
        cube("pale_celestium_ore", CELESTIUM_PROPS);
        cube("pale_celestium_block", CELESTIUM_PROPS);
        faceAttached("pale_celestium_spike", CELESTIUM_PROPS);
        faceAttached("pale_celestium_antenna", CELESTIUM_PROPS);

        // Desert and inky sets.
        cube("mossy_sky_sandstone", SKY_SANDSTONE_PROPS);
        cube("mossy_sky_sandstone_bricks", SKY_SANDSTONE_PROPS);
        cube("sky_sandstone_pillar_base", SKY_SANDSTONE_PROPS);
        plantBlock("arid_grass");
        plantBlock("small_arid_bush");
        plantBlock("small_sky_cactus");
        cube("sky_cactus", WOOD_PROPS);
        horizontalFacing("sky_cactus_branch", WOOD_PROPS);
        horizontalFacing("sky_cactus_top", WOOD_PROPS);
        cube("inky_planks", WOOD_PROPS);
        stairs("inky_planks_stairs", holder("inky_planks"), WOOD_PROPS);
        slab("inky_planks_slab", WOOD_PROPS);
        cube("inky_mosaic", WOOD_PROPS);
        stairs("inky_mosaic_stairs", holder("inky_mosaic"), WOOD_PROPS);
        slab("inky_mosaic_slab", WOOD_PROPS);
        fence("inky_planks_fence", WOOD_PROPS);
        door("inky_planks_door", BlockSetType.OAK, WOOD_PROPS);
        trapdoor("inky_planks_trapdoor", BlockSetType.OAK, WOOD_PROPS);
        pressurePlate("inky_pressure_plate", BlockSetType.OAK, WOOD_PROPS);
        button("inky_button", BlockSetType.OAK, WOOD_PROPS);
        cube("inky_celestium_ore", CELESTIUM_PROPS);
        cube("inky_celestium_block", CELESTIUM_PROPS);
        faceAttached("inky_celestium_spike", CELESTIUM_PROPS);
        faceAttached("inky_celestium_antenna", CELESTIUM_PROPS);

        // Grimstone and late-game materials.
        cube("blue_grimstone", GRIMSTONE_PROPS);
        cube("glowing_grimstone", GRIMSTONE_PROPS);
        cube("polished_bedrock", GRIMSTONE_PROPS);
        cube("grimstone_micelium", GLOWING_TOPSOIL_PROPS);
        pillar("grimstone_pillar", GRIMSTONE_PROPS);
        plantBlock("abyss_grass");
        plantBlock("short_abyss_grass");
        leavesBlock("celestial_tree_leaves");
        cube("metallic_silk_block", GRIMSTONE_PROPS);
        cube("grimstone_iron_ore", GRIMSTONE_PROPS);
        cube("grimstone_gold_ore", GRIMSTONE_PROPS);
        cube("grimstone_diamond_ore", GRIMSTONE_PROPS);
        cube("grimstone_redstone_ore", GRIMSTONE_PROPS);
        cube("grimstone_lapis_ore", GRIMSTONE_PROPS);
        cube("celestine_block", CELESTIUM_PROPS);
        faceAttached("celestine_spike", CELESTIUM_PROPS);
        faceAttached("small_celestine_spike", CELESTIUM_PROPS);
        faceAttached("sulfur_spike", SULFUR_PROPS);

        // Celestial and shrine sets.
        pillar("celestial_log", WOOD_PROPS);
        pillar("celestial_wood", WOOD_PROPS);
        cube("celestial_planks", WOOD_PROPS);
        stairs("celestial_stairs", holder("celestial_planks"), WOOD_PROPS);
        slab("celestial_slab", WOOD_PROPS);
        fence("celestial_fence", WOOD_PROPS);
        door("celestial_door", BlockSetType.OAK, WOOD_PROPS);
        trapdoor("celestial_trapdoor", BlockSetType.OAK, WOOD_PROPS);
        button("celestial_button", BlockSetType.OAK, WOOD_PROPS);
        pressurePlate("celestial_pressure_plate", BlockSetType.OAK, WOOD_PROPS);
        cube("shrine_plate", SKY_SANDSTONE_PROPS);
        cube("shrine_wall", SKY_SANDSTONE_PROPS);
        cube("shrine_wall_base", SKY_SANDSTONE_PROPS);
        stairs("shrine_wall_staircase", holder("shrine_wall"), SKY_SANDSTONE_PROPS);
        slab("shrine_wall_slab", SKY_SANDSTONE_PROPS);
        cube("shrine_tiles", SKY_SANDSTONE_PROPS);
        stairs("shrine_tiles_staircase", holder("shrine_tiles"), SKY_SANDSTONE_PROPS);
        slab("shrine_tiles_slab", SKY_SANDSTONE_PROPS);
        cube("shrine_floor", SKY_SANDSTONE_PROPS);
        stairs("shrine_floor_staircase", holder("shrine_floor"), SKY_SANDSTONE_PROPS);
        slab("shrine_floor_slab", SKY_SANDSTONE_PROPS);
        cube("shrine_sand", SKY_SANDSTONE_PROPS);
    }

    private SkyLandsBlocks() {
    }

    private static Supplier<Block> holder(String name) {
        return () -> BLOCKS.getEntries().stream()
            .filter(holder -> holder.getId().getPath().equals(name))
            .findFirst()
            .orElseThrow()
            .get();
    }

    private static DeferredBlock<Block> cube(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> new Block(copyProperties(properties)));
        DeferredItem<BlockItem> item = ITEMS.registerSimpleBlockItem(name, block);
        CREATIVE_ORDER.add(item);
        return block;
    }

    private static void pillar(String name, BlockBehaviour.Properties properties) {
        register(name, RotatedPillarBlock::new, properties);
    }

    private static DeferredBlock<Block> stairs(String name, Supplier<Block> baseBlock, BlockBehaviour.Properties properties) {
        return register(name, props -> new StairBlock(baseBlock.get().defaultBlockState(), props), properties);
    }

    private static DeferredBlock<Block> slab(String name, BlockBehaviour.Properties properties) {
        return register(name, SlabBlock::new, properties);
    }

    private static DeferredBlock<Block> wall(String name, BlockBehaviour.Properties properties) {
        return register(name, WallBlock::new, properties);
    }

    private static void fence(String name, BlockBehaviour.Properties properties) {
        register(name, FenceBlock::new, properties);
    }

    private static void door(String name, BlockSetType setType, BlockBehaviour.Properties properties) {
        register(name, props -> new DoorBlock(setType, props.noOcclusion()), properties);
    }

    private static void trapdoor(String name, BlockSetType setType, BlockBehaviour.Properties properties) {
        register(name, props -> new TrapDoorBlock(setType, props.noOcclusion()), properties);
    }

    private static void pressurePlate(String name, BlockSetType setType, BlockBehaviour.Properties properties) {
        register(name, props -> new PressurePlateBlock(setType, props), properties);
    }

    private static void button(String name, BlockSetType setType, BlockBehaviour.Properties properties) {
        register(name, props -> new ButtonBlock(setType, 30, props.noCollission()), properties);
    }

    private static void leavesBlock(String name) {
        register(name, LeavesBlock::new, LEAF_PROPS);
    }

    private static void plantBlock(String name) {
        register(name, TallGrassBlock::new, PLANT_PROPS);
    }

    private static void doublePlant(String name) {
        register(name, DoublePlantBlock::new, PLANT_PROPS);
    }

    private static void sapling(String name) {
        register(name, props -> new SaplingBlock(TreeGrower.OAK, props), PLANT_PROPS);
    }

    private static void horizontalFacing(String name, BlockBehaviour.Properties properties) {
        register(name, props -> new SimpleHorizontalFacingBlock(props.noOcclusion()), properties);
    }

    private static void solidHorizontalFacing(String name, BlockBehaviour.Properties properties) {
        register(name, SimpleHorizontalFacingBlock::new, properties);
    }

    private static void faceAttached(String name, BlockBehaviour.Properties properties) {
        register(name, props -> new SimpleFaceAttachedBlock(props.noOcclusion()), properties);
    }

    private static void simpleItem(String name) {
        DeferredItem<Item> item = ITEMS.registerSimpleItem(name, new Item.Properties());
        CREATIVE_ORDER.add(item);
    }

    private static DeferredBlock<Block> register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> factory.apply(copyProperties(properties)));
        DeferredItem<BlockItem> item = ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        CREATIVE_ORDER.add(item);
        return block;
    }

    private static BlockBehaviour.Properties copyProperties(BlockBehaviour.Properties properties) {
        return BlockBehaviour.Properties.ofFullCopy(new Block(properties));
    }

    private static BlockBehaviour.Properties stone(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).strength(1.8F, 6.0F).requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties wood(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).strength(2.0F, 3.0F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties leaves() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(0.2F)
            .randomTicks()
            .sound(SoundType.GRASS)
            .noOcclusion()
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties grassyTopsoil() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(1.0F, 10.0F)
            .sound(SoundType.GRASS);
    }

    private static BlockBehaviour.Properties swampyTopsoil() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(1.1F, 12.0F)
            .sound(SoundType.ROOTED_DIRT);
    }

    private static BlockBehaviour.Properties lavicTopsoil() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .strength(1.1F, 15.0F)
            .sound(SoundType.ROOTED_DIRT);
    }

    private static BlockBehaviour.Properties glowingTopsoil() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_GRAY)
            .strength(1.3F, 10.0F)
            .sound(SoundType.ROOTED_DIRT)
            .lightLevel(state -> 15);
    }

    private static BlockBehaviour.Properties plant() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .replaceable()
            .noCollission()
            .instabreak()
            .sound(SoundType.GRASS)
            .offsetType(BlockBehaviour.OffsetType.XYZ)
            .pushReaction(PushReaction.DESTROY);
    }
}
