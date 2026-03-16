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
public class CloudParticle extends TextureSheetParticle {
   private final SpriteSet spriteSet;

   public static CloudParticle.CloudParticleProvider provider(SpriteSet spriteSet) {
      return new CloudParticle.CloudParticleProvider(spriteSet);
   }

   protected CloudParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
      super(world, x, y, z);
      this.spriteSet = spriteSet;
      this.setSize(4.0F, 4.0F);
      this.quadSize *= 8.0F;
      this.lifetime = Math.max(1, 360 + (this.random.nextInt(360) - 180));
      this.gravity = 0.0F;
      this.alpha = 0.0F;
      this.hasPhysics = false;
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
      this.alpha = Mth.clamp((float)this.age / this.lifetime * 2.0F - 0.1F, 0.0F, 1.0F)
         * (1.0F - Mth.clamp((float)this.age / this.lifetime * 2.0F, 0.0F, 1.0F))
         * 4.0F;
   }

   public static class CloudParticleProvider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet spriteSet;

      public CloudParticleProvider(SpriteSet spriteSet) {
         this.spriteSet = spriteSet;
      }

      public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new CloudParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
      }
   }
}


