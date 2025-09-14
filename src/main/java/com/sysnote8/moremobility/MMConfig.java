package com.sysnote8.moremobility;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MoreMobility.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MMConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.BooleanValue OFFROAD_SLOWNESS = BUILDER.comment("Apply slow effect when driving on non-paved road").define("offroadSlowness", true);
    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static boolean offroadSlowness;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        offroadSlowness = OFFROAD_SLOWNESS.get();
    }
}
