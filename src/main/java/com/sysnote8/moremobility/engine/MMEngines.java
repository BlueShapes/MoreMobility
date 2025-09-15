package com.sysnote8.moremobility.engine;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.AutomobileEngine;
import io.github.foundationgames.automobility.sound.AutomobilitySounds;

public class MMEngines {
    public static final AutomobileEngine NETHERITE = register(
            new AutomobileEngine(
                    MoreMobility.id("netherite"),
                    1.0f,
                    1.1f,
                    AutomobilitySounds.DIAMOND_ENGINE::require,
                    new AutomobileEngine.EngineModel(
                            Automobility.rl("textures/entity/automobile/engine/netherite.png"), MoreMobility.id("engine_netherite"),
                            new AutomobileEngine.ExhaustPos(3, 3.8f, -7.6f, 40, 0),
                            new AutomobileEngine.ExhaustPos(-3, 3.8f, -7.6f, 40, 0),
                            new AutomobileEngine.ExhaustPos(0.0f, 6.5f, -5.35f, 40, 0),
                            new AutomobileEngine.ExhaustPos(4, 7.075f, -4.95f, 40, 0),
                            new AutomobileEngine.ExhaustPos(-4, 7.075f, -4.95f, 40, 0)
                    )
            )
    );

    private static AutomobileEngine register(AutomobileEngine engineData) {
        return AutomobileEngine.REGISTRY.register(engineData);
    }

    public static void init() {
    }
}
