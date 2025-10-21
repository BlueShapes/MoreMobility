package com.sysnote8.moremobility.integration.jei;

import com.sysnote8.moremobility.MoreMobility;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class MMJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = MoreMobility.id("jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoMechanicTableJeiCategory());
    }
}
