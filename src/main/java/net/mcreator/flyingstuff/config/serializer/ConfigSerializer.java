package net.mcreator.flyingstuff.config.serializer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.neoforged.fml.loading.FMLPaths;

public abstract class ConfigSerializer {
   private final File configFile;
   private final String extension;

   public ConfigSerializer(String configFileName, String extension) {
      this.extension = extension;
      extension = "." + extension;
      this.configFile = FMLPaths.CONFIGDIR.get().resolve(configFileName.endsWith(extension) ? configFileName : configFileName + extension).toFile();
   }

   protected File getConfigFile() {
      return this.configFile;
   }

   public abstract void serialize(Map<String, Object> var1);

   public abstract Map<String, Object> deserialize();

   protected void createConfigFile() {
      try {
         this.getConfigFile().createNewFile();
      } catch (IOException var2) {
      }
   }

   public String getMessage() {
      return "Loaded " + this.extension.toUpperCase() + " config file " + this.getConfigFile().toPath();
   }
}
