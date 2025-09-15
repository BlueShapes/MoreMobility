package com.sysnote8.moremobility.datagen;

import com.sysnote8.moremobility.datagen.recipe.MMRecipeProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MMDataGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MMDataGenerator.class);

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        logger.info("Generating data... includeServer: {}", event.includeServer());
        event.getGenerator().<MMRecipeProvider>addProvider(
                event.includeServer(),
                MMRecipeProvider::new
        );
    }
}
