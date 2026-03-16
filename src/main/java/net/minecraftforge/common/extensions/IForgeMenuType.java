package net.minecraftforge.common.extensions;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.network.IContainerFactory;

public interface IForgeMenuType<T> {
   static <T extends AbstractContainerMenu> MenuType<T> create(IContainerFactory<T> factory) {
      return net.neoforged.neoforge.common.extensions.IMenuTypeExtension.create(factory);
   }
}

