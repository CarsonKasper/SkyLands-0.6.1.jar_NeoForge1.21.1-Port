package net.custom.flyingstuff.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodTypes {
   public static final WoodType GOLDEN_LEAVES = WoodType.register(new WoodType("flying_stuff:golden_leaves", BlockSetType.OAK));
   public static final WoodType GLACIATED = WoodType.register(new WoodType("flying_stuff:glaciated", BlockSetType.OAK));
   public static final WoodType LAVIC = WoodType.register(new WoodType("flying_stuff:lavic", BlockSetType.OAK));
   public static final WoodType INKY = WoodType.register(new WoodType("flying_stuff:inky", BlockSetType.OAK));
}

