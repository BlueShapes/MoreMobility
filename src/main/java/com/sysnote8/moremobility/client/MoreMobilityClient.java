package com.sysnote8.moremobility.client;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.automobile.render.AutomobileModels;
import io.github.foundationgames.automobility.forge.vendored.jsonem.JsonEM;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber(modid = MoreMobility.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoreMobilityClient {
    private static final Logger logger = LoggerFactory.getLogger(MoreMobility.MODID + "-client");

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        logger.info("HELLO FROM CLIENT SETUP");
        logger.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
//        JsonEM.registerModelLayer(AdvancedHarvesterFrontModel.MODEL_LAYER);
        AutomobileModels.register(
                MoreMobility.id("frontatt_harvester_advanced"),
                AdvancedHarvesterFrontModel::new
        );

        // register netherite engine models
        AutomobileModels.register(
                MoreMobility.id("engine_netherite"),
                NetheriteEngineModel::new
        );
        JsonEM.registerModelLayer(NetheriteEngineModel.MODEL_LAYER);
    }
}
