package net.mcreator.flyingstuff.world.teleporter;

import java.util.Optional;
import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.portal.DimensionTransition;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(bus = Bus.MOD)
public class UnderGroundTeleporter {
   public static final TicketType<BlockPos> CUSTOM_PORTAL = TicketType.create("under_ground_portal", Vec3i::compareTo, 300);
   public static Holder<PoiType> poi;
   private final ServerLevel level;
   private final BlockPos entityEnterPos;

   public UnderGroundTeleporter(ServerLevel level, BlockPos entityEnterPos) {
      this.level = level;
      this.entityEnterPos = entityEnterPos;
   }

   @SubscribeEvent
   public static void registerPointOfInterest(RegisterEvent event) {
   }

   public DimensionTransition getPortalDestination(Entity entity, ServerLevel destinationLevel) {
      return null;
   }

   public Optional<FoundRectangle> findPortalAround(BlockPos pos, boolean shortRange, WorldBorder worldBorder) {
      return Optional.empty();
   }

   public Optional<FoundRectangle> createPortal(BlockPos pos, Axis axis) {
      return Optional.empty();
   }
}

