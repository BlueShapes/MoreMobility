package com.sysnote8.moremobility;

import com.mojang.logging.LogUtils;
import com.sysnote8.moremobility.attachment.MMAttachments;
import com.sysnote8.moremobility.engine.MMEngines;
import com.sysnote8.moremobility.frame.MMFrames;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MoreMobility.MODID)
public class MoreMobility {

    public static final String MODID = "moremobility";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @SuppressWarnings("removal")
    public MoreMobility() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        registerAll(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MMConfig.SPEC);
    }

    private void registerAll(IEventBus modEventBus) {
        MMFrames.init();
        MMEngines.init();
        MMAttachments.init();
    }
}
