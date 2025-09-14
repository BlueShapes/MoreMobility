package com.sysnote8.moremobility;

import com.mojang.logging.LogUtils;
import com.sysnote8.moremobility.attachment.MMAttachments;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoreMobility.MODID)
public class MoreMobility {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "moremobility";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @SuppressWarnings("removal")
    public MoreMobility() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerAll(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void registerAll(IEventBus modEventBus) {
        MMFrames.init();
        MMEngines.init();
        MMAttachments.init();
    }
}
