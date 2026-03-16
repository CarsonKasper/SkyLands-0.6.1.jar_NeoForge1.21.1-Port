package net.mcreator.flyingstuff.client.renderer;

import net.mcreator.flyingstuff.client.model.Modelsky_boss0;
import net.mcreator.flyingstuff.entity.SkyAutomatonBossEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class SkyAutomatonBossRenderer extends MobRenderer<SkyAutomatonBossEntity, Modelsky_boss0<SkyAutomatonBossEntity>> {
   public SkyAutomatonBossRenderer(Context context) {
      super(context, new Modelsky_boss0(context.bakeLayer(Modelsky_boss0.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(SkyAutomatonBossEntity entity) {
      return ResourceLocation.parse("flying_stuff:textures/entities/boss.png");
   }
}


