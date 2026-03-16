package net.minecraftforge.registries;

import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;

public final class ForgeRegistries {
   public static final DefaultedRegistry<Block> BLOCKS = BuiltInRegistries.BLOCK;
   public static final Registry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = BuiltInRegistries.BLOCK_ENTITY_TYPE;
   public static final DefaultedRegistry<EntityType<?>> ENTITY_TYPES = BuiltInRegistries.ENTITY_TYPE;
   @SuppressWarnings("unchecked")
   public static final Registry<Enchantment> ENCHANTMENTS = (Registry<Enchantment>)(Registry<?>)BuiltInRegistries.REGISTRY.get(Registries.ENCHANTMENT.location());
   public static final Registry<Feature<?>> FEATURES = BuiltInRegistries.FEATURE;
   public static final DefaultedRegistry<Fluid> FLUIDS = BuiltInRegistries.FLUID;
   public static final DefaultedRegistry<Item> ITEMS = BuiltInRegistries.ITEM;
   public static final Registry<MenuType<?>> MENU_TYPES = BuiltInRegistries.MENU;
   public static final Registry<MobEffect> MOB_EFFECTS = BuiltInRegistries.MOB_EFFECT;
   @SuppressWarnings("unchecked")
   public static final Registry<PaintingVariant> PAINTING_VARIANTS = (Registry<PaintingVariant>)(Registry<?>)BuiltInRegistries.REGISTRY.get(Registries.PAINTING_VARIANT.location());
   public static final Registry<ParticleType<?>> PARTICLE_TYPES = BuiltInRegistries.PARTICLE_TYPE;
   public static final Registry<PoiType> POI_TYPES = BuiltInRegistries.POINT_OF_INTEREST_TYPE;
   public static final Registry<SoundEvent> SOUND_EVENTS = BuiltInRegistries.SOUND_EVENT;
   public static final DefaultedRegistry<VillagerProfession> VILLAGER_PROFESSIONS = BuiltInRegistries.VILLAGER_PROFESSION;

   public static final class Keys {
      public static final ResourceKey<? extends Registry<FluidType>> FLUID_TYPES = net.neoforged.neoforge.registries.NeoForgeRegistries.Keys.FLUID_TYPES;
      public static final ResourceKey<? extends Registry<PoiType>> POI_TYPES = Registries.POINT_OF_INTEREST_TYPE;
      public static final ResourceKey<? extends Registry<TreeDecoratorType<?>>> TREE_DECORATOR_TYPES = Registries.TREE_DECORATOR_TYPE;

      private Keys() {
      }
   }

   private ForgeRegistries() {
   }
}

