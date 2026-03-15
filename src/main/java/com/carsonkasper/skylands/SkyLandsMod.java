package com.carsonkasper.skylands;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SkyLandsMod.MODID)
public final class SkyLandsMod {
    public static final String MODID = "flying_stuff";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SkyLandsMod(IEventBus modEventBus, ModContainer modContainer) {
        SkyLandsBlocks.BLOCKS.register(modEventBus);
        SkyLandsBlocks.ITEMS.register(modEventBus);
        SkyLandsFluids.FLUID_TYPES.register(modEventBus);
        SkyLandsFluids.FLUIDS.register(modEventBus);
        SkyLandsFeatures.FEATURES.register(modEventBus);
        SkyLandsCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }
}
