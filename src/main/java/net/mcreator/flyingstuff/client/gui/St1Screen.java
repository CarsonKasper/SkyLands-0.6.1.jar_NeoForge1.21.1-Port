package net.mcreator.flyingstuff.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.flyingstuff.FlyingStuffMod;
import net.mcreator.flyingstuff.network.St1ButtonMessage;
import net.mcreator.flyingstuff.world.inventory.St1Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class St1Screen extends AbstractContainerScreen<St1Menu> {
   private static final HashMap<String, Object> guistate = St1Menu.guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   Button imagebutton_arrowr;
   Button imagebutton_arrowl;

   public St1Screen(St1Menu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 128;
      this.imageHeight = 196;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
   }

   protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.blit(
         ResourceLocation.parse("flying_stuff:textures/screens/page.png"), this.leftPos, this.topPos, 0.0F, 0.0F, 128, 196, 128, 196
      );
      RenderSystem.disableBlend();
   }

   public boolean keyPressed(int key, int b, int c) {
      if (key == 256) {
         this.minecraft.player.closeContainer();
         return true;
      } else {
         return super.keyPressed(key, b, c);
      }
   }

   public void init() {
      super.init();
      this.imagebutton_arrowr = Button.builder(Component.empty(), e -> {}).bounds(this.leftPos + 120, this.topPos + 178, 22, 18).build();
      guistate.put("button:imagebutton_arrowr", this.imagebutton_arrowr);
      this.addRenderableWidget(this.imagebutton_arrowr);
      this.imagebutton_arrowl = Button.builder(Component.empty(), e -> {
            FlyingStuffMod.PACKET_HANDLER.sendToServer(new St1ButtonMessage(1, this.x, this.y, this.z));
            St1ButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
         }).bounds(this.leftPos - 14, this.topPos + 178, 22, 18).build();
      guistate.put("button:imagebutton_arrowl", this.imagebutton_arrowl);
      this.addRenderableWidget(this.imagebutton_arrowl);
   }

   protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
   }
}


