package net.mcreator.flyingstuff.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.flyingstuff.procedures.GliderFirstStaminaProcedure;
import net.mcreator.flyingstuff.procedures.GliderStamina2Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina3Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina4Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina5Procedure;
import net.mcreator.flyingstuff.procedures.GliderStaminaDisplayOverlayIngameProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RenderGuiEvent.Pre;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
public class GliderStaminaOverlay {
   @SubscribeEvent(priority = EventPriority.NORMAL)
   public static void eventHandler(Pre event) {
      int w = Minecraft.getInstance().getWindow().getGuiScaledWidth();
      int h = Minecraft.getInstance().getWindow().getGuiScaledHeight();
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.getInstance().player;
      if (entity != null) {
         world = entity.level();
         x = entity.getX();
         y = entity.getY();
         z = entity.getZ();
      }

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (GliderStaminaDisplayOverlayIngameProcedure.execute(entity)) {
         event.getGuiGraphics()
            .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_under.png"), w / 2 + -47, h - 70, 0, 0.0F, 0.0F, 96, 16, 96, 16);
         if (GliderFirstStaminaProcedure.execute(entity)) {
            event.getGuiGraphics()
               .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -49, h - 70, 0, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (GliderStamina2Procedure.execute(entity)) {
            event.getGuiGraphics()
               .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -28, h - 70, 0, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (GliderStamina3Procedure.execute(entity)) {
            event.getGuiGraphics()
               .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -7, h - 70, 0, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (GliderStamina4Procedure.execute(entity)) {
            event.getGuiGraphics()
               .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_over.png"), w / 2 + 14, h - 70, 0, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (GliderStamina5Procedure.execute(entity)) {
            event.getGuiGraphics()
               .blit(ResourceLocation.parse("flying_stuff:textures/screens/stamina_over.png"), w / 2 + 36, h - 70, 0, 0.0F, 0.0F, 16, 16, 16, 16);
         }
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}

