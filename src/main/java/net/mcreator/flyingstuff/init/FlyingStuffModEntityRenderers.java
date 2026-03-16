package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.client.renderer.AridSkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.ArtificialAracnidRenderer;
import net.mcreator.flyingstuff.client.renderer.AutomatonDroneRenderer;
import net.mcreator.flyingstuff.client.renderer.FriendlyVexRenderer;
import net.mcreator.flyingstuff.client.renderer.GlaciatedDragonRenderer;
import net.mcreator.flyingstuff.client.renderer.GlaciatedSkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.HappySlobertRenderer;
import net.mcreator.flyingstuff.client.renderer.IceBlobRenderer;
import net.mcreator.flyingstuff.client.renderer.IgneoRoboFelineRenderer;
import net.mcreator.flyingstuff.client.renderer.LavicSkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.MagmaSlobertRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonBossRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonBruteRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyAutomatonRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyBirdRenderer;
import net.mcreator.flyingstuff.client.renderer.SkyPharaohRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModEntityRenderers {
   @SubscribeEvent
   public static void registerEntityRenderers(RegisterRenderers event) {
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SKY_AUTOMATON.get(), SkyAutomatonRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SKY_AUTOMATON_BOSS.get(), SkyAutomatonBossRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SMOKE_FLOWER_PROJ.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.AUTOMATON_DRONE.get(), AutomatonDroneRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.FLOAT_GRAPE_PROJ.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.ICE_ARROW.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.GLACIATED_SKY_AUTOMATON.get(), GlaciatedSkyAutomatonRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.GLACIATED_DRAGON.get(), GlaciatedDragonRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.ICEBOMB.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SKY_AUTOMATON_BRUTE.get(), SkyAutomatonBruteRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.ICE_BLOB.get(), IceBlobRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.MAGMA_SLOBERT.get(), MagmaSlobertRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.LAVIC_SKY_AUTOMATON.get(), LavicSkyAutomatonRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.FIRE_WAVE.get(), ThrownItemRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.IGNEO_ROBO_FELINE.get(), IgneoRoboFelineRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SKY_BIRD.get(), SkyBirdRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.ARID_SKY_AUTOMATON.get(), AridSkyAutomatonRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.SKY_PHARAOH.get(), SkyPharaohRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.FRIENDLY_VEX.get(), FriendlyVexRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.HAPPY_SLOBERT.get(), HappySlobertRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.ARTIFICIAL_ARACNID.get(), ArtificialAracnidRenderer::new);
      event.registerEntityRenderer((EntityType)FlyingStuffModEntities.EYE_OFTS_PROJECTILE.get(), ThrownItemRenderer::new);
   }
}
