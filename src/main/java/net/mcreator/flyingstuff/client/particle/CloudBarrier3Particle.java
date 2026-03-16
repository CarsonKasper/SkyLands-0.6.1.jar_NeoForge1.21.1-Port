package net.mcreator.flyingstuff.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CloudBarrier3Particle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static CloudBarrier3Particle.CloudBarrier3ParticleProvider provider(SpriteSet spriteSet) {
      return new CloudBarrier3Particle.CloudBarrier3ParticleProvider(spriteSet);
   }

   protected CloudBarrier3Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.setSize(80.0F, 80.0F);
      this.quadSize *= 86.0F;
      this.lifetime = Math.max(1, 1000 + (this.random.nextInt(10) - 5));
      this.friction = 0.995F;
      this.gravity = 0.0F;
      this.hasPhysics = false;
      this.alpha = 0.0F;
      this.xd = vx * 1.0;
      this.yd = vy * 1.0;
      this.zd = vz * 1.0;
      this.pickSprite(spriteSet);
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public void tick() {
      super.tick();
      this.alpha = Mth.clamp((float)this.age / this.lifetime * 2.0F - 0.1F, 0.0F, 1.0F)
         * (1.0F - Mth.clamp((float)this.age / this.lifetime * 2.0F, 0.0F, 1.0F))
         * 3.5F;
   }

   public static class CloudBarrier3ParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public CloudBarrier3ParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new CloudBarrier3Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}


