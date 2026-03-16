package net.mcreator.flyingstuff.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CloudSmoke1Particle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static CloudSmoke1Particle.CloudSmoke1ParticleProvider provider(SpriteSet spriteSet) {
      return new CloudSmoke1Particle.CloudSmoke1ParticleProvider(spriteSet);
   }

   protected CloudSmoke1Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.setSize(4.0F, 4.0F);
      this.quadSize *= 8.0F;
      this.lifetime = Math.max(1, 300 + (this.random.nextInt(80) - 40));
      this.gravity = 0.0F;
      this.hasPhysics = true;
      this.xd = vx * 0.02;
      this.yd = vy * 0.02;
      this.zd = vz * 0.02;
      this.pickSprite(spriteSet);
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public void tick() {
      super.tick();
   }

   public static class CloudSmoke1ParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public CloudSmoke1ParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new CloudSmoke1Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}


