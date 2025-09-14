package com.sysnote8.moremobility.engine;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.AutomobileEngine;
import io.github.foundationgames.automobility.sound.AutomobilitySounds;

public class MMEngines {
    private static AutomobileEngine register(AutomobileEngine engineData) {
        return AutomobileEngine.REGISTRY.register(engineData);
    }

    public static final AutomobileEngine NETHERITE = register(
            new AutomobileEngine(
                    MoreMobility.id("netherite"),
                    1.0f,
                    1.1f,
                    AutomobilitySounds.DIAMOND_ENGINE::require,
                    new AutomobileEngine.EngineModel(
                            Automobility.rl("textures/entity/automobile/engine/stone.png"), Automobility.rl("engine_stone"),
                            new AutomobileEngine.ExhaustPos(0, 7f, -8.3f, 50, 0)
                    )
            )
    );

    public static void init() {}
}
