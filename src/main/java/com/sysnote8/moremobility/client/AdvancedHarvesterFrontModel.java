package com.sysnote8.moremobility.client;

import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.attachment.front.FrontAttachment;
import io.github.foundationgames.automobility.automobile.render.attachment.front.FrontAttachmentRenderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class AdvancedHarvesterFrontModel extends FrontAttachmentRenderModel {
    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Automobility.rl("automobile/front_attachment/harvester"), "main");

    private final @Nullable ModelPart roller;

    public AdvancedHarvesterFrontModel(EntityRendererProvider.Context ctx) {
        super(RenderType::entityCutout, ctx, MODEL_LAYER);

        if (this.ground != null) {
            this.roller = this.ground.getChild("roller");
            this.roller.offsetScale(new Vector3f(1.5f, 1.0f, 1.0f));
        } else {
            this.roller = null;
        }
    }

    @Override
    public void setRenderState(@Nullable FrontAttachment attachment, float groundHeight, float tickDelta) {
        super.setRenderState(attachment, groundHeight, tickDelta);

        if (this.roller != null) {
            if (attachment != null) {
                this.roller.setRotation((float) Math.toRadians(attachment.automobile().getWheelAngle(tickDelta)), 0, 0);
            } else {
                this.roller.setRotation(0, 0, 0);
            }
        }
    }
}
