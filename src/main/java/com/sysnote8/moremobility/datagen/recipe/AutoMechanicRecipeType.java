package com.sysnote8.moremobility.datagen.recipe;

import io.github.foundationgames.automobility.automobile.AutomobileComponent;
import io.github.foundationgames.automobility.automobile.AutomobileEngine;
import io.github.foundationgames.automobility.automobile.AutomobileFrame;
import io.github.foundationgames.automobility.automobile.AutomobileWheel;
import io.github.foundationgames.automobility.automobile.attachment.FrontAttachmentType;
import io.github.foundationgames.automobility.automobile.attachment.RearAttachmentType;
import io.github.foundationgames.automobility.item.AutomobileComponentItem;
import io.github.foundationgames.automobility.item.AutomobilityItems;
import io.github.foundationgames.automobility.util.Eventual;
import net.minecraft.resources.ResourceLocation;

public class AutoMechanicRecipeType<T extends AutomobileComponent<T>> {
    public static final AutoMechanicRecipeType<FrontAttachmentType<?>> FRONT_ATTACHMENT = new AutoMechanicRecipeType<>(MMRecipeCategories.ATTACHMENTS, AutomobilityItems.FRONT_ATTACHMENT);
    public static final AutoMechanicRecipeType<RearAttachmentType<?>> REAR_ATTACHMENT = new AutoMechanicRecipeType<>(MMRecipeCategories.ATTACHMENTS, AutomobilityItems.REAR_ATTACHMENT);
    public static final AutoMechanicRecipeType<AutomobileEngine> ENGINE = new AutoMechanicRecipeType<>(MMRecipeCategories.ENGINES, AutomobilityItems.AUTOMOBILE_ENGINE);
    public static final AutoMechanicRecipeType<AutomobileFrame> FRAME = new AutoMechanicRecipeType<>(MMRecipeCategories.FRAMES, AutomobilityItems.AUTOMOBILE_FRAME);
    public static final AutoMechanicRecipeType<AutomobileWheel> WHEEL = new AutoMechanicRecipeType<>(MMRecipeCategories.WHEELS, AutomobilityItems.AUTOMOBILE_WHEEL);

    private final ResourceLocation recipeCategory;
    private final Eventual<? extends AutomobileComponentItem<T>> eventual;

    public AutoMechanicRecipeType(ResourceLocation recipeCategory, Eventual<? extends AutomobileComponentItem<T>> eventual) {
        this.recipeCategory = recipeCategory;
        this.eventual = eventual;
    }

    public ResourceLocation getRecipeCategory() {
        return recipeCategory;
    }

    public Eventual<? extends AutomobileComponentItem<T>> getEventual() {
        return eventual;
    }
}
