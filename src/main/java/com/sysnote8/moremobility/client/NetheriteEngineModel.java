package com.sysnote8.moremobility.client;

import io.github.foundationgames.automobility.Automobility;
import io.github.foundationgames.automobility.automobile.render.BaseModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class NetheriteEngineModel extends BaseModel {
    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Automobility.rl("automobile/engine/netherite"), "main");

    public NetheriteEngineModel(EntityRendererProvider.Context ctx) {
        this(RenderType::entityCutout, ctx, MODEL_LAYER);
    }

    public NetheriteEngineModel(Function<ResourceLocation, RenderType> layerFactory, EntityRendererProvider.Context ctx, ModelLayerLocation layer) {
        super(layerFactory, ctx, layer);
    }
}

