package com.sysnote8.moremobility.attachment;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.attachment.FrontAttachmentType;
import io.github.foundationgames.automobility.automobile.attachment.front.FrontAttachment;

public class MMAttachments {
    private static <T extends FrontAttachment> FrontAttachmentType<T> register(FrontAttachmentType<T> entry) {
        FrontAttachmentType.REGISTRY.register(entry);
        return entry; // for type hint correctly
    }

    public static final FrontAttachmentType<AdvancedCropHarvesterAttachment> ADVANCED_CROP_HARVESTER = register(new FrontAttachmentType<>(
            MoreMobility.id("advanced_crop_harvester"),
            AdvancedCropHarvesterAttachment::new,
            new FrontAttachmentType.FrontAttachmentModel(Automobility.rl("textures/entity/automobile/front_attachment/crop_harvester.png"), MoreMobility.id("frontatt_harvester_advanced"), 0.83f)
    ));

    public static void init() {}
}
