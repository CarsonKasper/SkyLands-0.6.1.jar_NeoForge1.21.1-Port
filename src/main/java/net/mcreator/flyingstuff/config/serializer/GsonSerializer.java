package net.mcreator.flyingstuff.config.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GsonSerializer extends ConfigSerializer {
   private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
   private static final String extension = "json";

   public GsonSerializer(String configFileName) {
      super(configFileName, "json");
   }

   @Override
   public void serialize(Map<String, Object> entries) {
      try (FileWriter writer = new FileWriter(this.getConfigFile())) {
         gson.toJson(entries, writer);
      } catch (IOException var7) {
         var7.printStackTrace();
      }
   }

   @Override
   public Map<String, Object> deserialize() {
      try {
         Map var2;
         try (FileReader reader = new FileReader(this.getConfigFile())) {
            var2 = (Map)gson.fromJson(reader, (new TypeToken<Map<String, Object>>() {}).getType());
         }

         return var2;
      } catch (IOException var6) {
         this.createConfigFile();
         return null;
      }
   }
}
