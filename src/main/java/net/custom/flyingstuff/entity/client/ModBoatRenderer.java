package net.custom.flyingstuff.entity.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import java.util.stream.Stream;
import net.custom.flyingstuff.entity.ModBoatEntity;
import net.custom.flyingstuff.entity.ModChestBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class ModBoatRenderer extends BoatRenderer {
   private final Map<ModBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

   public ModBoatRenderer(Context pContext, boolean pChestBoat) {
      super(pContext, pChestBoat);
      this.boatResources = Stream.of(ModBoatEntity.Type.values())
         .collect(
            ImmutableMap.toImmutableMap(
               type -> type,
               type -> Pair.of(ResourceLocation.fromNamespaceAndPath("flying_stuff", getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, type, pChestBoat))
            )
         );
   }

   private static String getTextureLocation(ModBoatEntity.Type pType, boolean pChestBoat) {
      return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
   }

   private ListModel<Boat> createBoatModel(Context pContext, ModBoatEntity.Type pType, boolean pChestBoat) {
      ModelLayerLocation modellayerlocation = pChestBoat ? createChestBoatModelName(pType) : createBoatModelName(pType);
      ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
      return (ListModel<Boat>)(pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart));
   }

   public static ModelLayerLocation createBoatModelName(ModBoatEntity.Type pType) {
      return createLocation("boat/" + pType.getName(), "main");
   }

   public static ModelLayerLocation createChestBoatModelName(ModBoatEntity.Type pType) {
      return createLocation("chest_boat/" + pType.getName(), "main");
   }

   private static ModelLayerLocation createLocation(String pPath, String pModel) {
      return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("flying_stuff", pPath), pModel);
   }

   public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
      if (boat instanceof ModBoatEntity modBoat) {
         return this.boatResources.get(modBoat.getModVariant());
      } else {
         return boat instanceof ModChestBoatEntity modChestBoatEntity ? this.boatResources.get(modChestBoatEntity.getModVariant()) : null;
      }
   }
}

