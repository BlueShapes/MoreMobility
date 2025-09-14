package com.sysnote8.moremobility.frame;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.AutomobileFrame;
import io.github.foundationgames.automobility.automobile.WheelBase;

public class MMFrames {
    public static final AutomobileFrame SILVER = register(
            new AutomobileFrame(
                    MoreMobility.id("silver"),
                    0.15f,
                    rickshawFrame("quartz")
            )
    );
    public static final AutomobileFrame RACE_SHOPPING_CART = register(
            new AutomobileFrame(
                    MoreMobility.id("race_shopping_cart"),
                    0.01f,
                    new AutomobileFrame.FrameModel(
                            Automobility.rl("textures/entity/automobile/frame/shopping_cart.png"),
                            Automobility.rl("frame_shopping_cart"),
                            WheelBase.basic(17, 12.05f),
                            25,
                            11,
                            7,
                            17,
                            11,
                            11
                    )
            )
    );

    private static AutomobileFrame register(AutomobileFrame entry) {
        return AutomobileFrame.REGISTRY.register(entry);
    }

    public static void init() {
    }

    private static AutomobileFrame.FrameModel rickshawFrame(String prefix) {
        return
                new AutomobileFrame.FrameModel(
                        Automobility.rl("textures/entity/automobile/frame/" + prefix + "_rickshaw.png"),
                        Automobility.rl("frame_rickshaw"),
                        new WheelBase(
                                new WheelBase.WheelPos(-11, -7.5f, 1, 0, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(-11, 7.5f, 1, 180, WheelBase.WheelEnd.BACK, WheelBase.WheelSide.RIGHT),
                                new WheelBase.WheelPos(11, -0.1f, 1, 0, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.LEFT),
                                new WheelBase.WheelPos(11, 0.1f, 1, 180, WheelBase.WheelEnd.FRONT, WheelBase.WheelSide.RIGHT)
                        ),
                        26,
                        2.5f,
                        13,
                        3,
                        17.5f,
                        14.5f
                );
    }
}
