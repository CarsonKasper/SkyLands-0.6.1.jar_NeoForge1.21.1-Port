package net.mcreator.flyingstuff.init;

import net.mcreator.flyingstuff.client.particle.CloudBarrier0Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier1Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier2Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier3Particle;
import net.mcreator.flyingstuff.client.particle.CloudBarrier4Particle;
import net.mcreator.flyingstuff.client.particle.CloudBig2Particle;
import net.mcreator.flyingstuff.client.particle.CloudDetailedParticle;
import net.mcreator.flyingstuff.client.particle.CloudParticle;
import net.mcreator.flyingstuff.client.particle.CloudSmoke1Particle;
import net.mcreator.flyingstuff.client.particle.CloudSmokeParticle;
import net.mcreator.flyingstuff.client.particle.EmptyParticle;
import net.mcreator.flyingstuff.client.particle.FastParticle;
import net.mcreator.flyingstuff.client.particle.FireLeafParticle;
import net.mcreator.flyingstuff.client.particle.FireflyParticle;
import net.mcreator.flyingstuff.client.particle.IceParticle;
import net.mcreator.flyingstuff.client.particle.ItemBreakParticle;
import net.mcreator.flyingstuff.client.particle.Snowfall0Particle;
import net.mcreator.flyingstuff.client.particle.TempFireParticleParticle;
import net.mcreator.flyingstuff.client.particle.WindParticle;
import net.minecraft.core.particles.ParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModParticles {
   @SubscribeEvent
   public static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD.get(), CloudParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.FIRE_LEAF.get(), FireLeafParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_DETAILED.get(), CloudDetailedParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BIG_2.get(), CloudBig2Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.FAST.get(), FastParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.SNOWFALL_0.get(), Snowfall0Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.EMPTY.get(), EmptyParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_SMOKE.get(), CloudSmokeParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_SMOKE_1.get(), CloudSmoke1Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BARRIER_0.get(), CloudBarrier0Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BARRIER_1.get(), CloudBarrier1Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BARRIER_2.get(), CloudBarrier2Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BARRIER_3.get(), CloudBarrier3Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.CLOUD_BARRIER_4.get(), CloudBarrier4Particle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.ICE.get(), IceParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.TEMP_FIRE_PARTICLE.get(), TempFireParticleParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.WIND.get(), WindParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.FIREFLY.get(), FireflyParticle::provider);
      event.registerSpriteSet((ParticleType)FlyingStuffModParticleTypes.ITEM_BREAK.get(), ItemBreakParticle::provider);
   }
}
