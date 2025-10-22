package com.sysnote8.moremobility.integration.jei;

import com.sysnote8.moremobility.MoreMobility;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class MMJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = MoreMobility.id("jei_plugin");
    public static RecipeType<AutoMechanicTableRecipe> AUTO_MECHANIC_TYPE = RecipeType.create(MoreMobility.MODID, "auto_mechanic", AutoMechanicTableRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AutoMechanicTableJeiCategory());
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        ClientLevel world = Minecraft.getInstance().level;
        if (world == null) return;
        registration.addRecipes(AUTO_MECHANIC_TYPE, world.getRecipeManager().getAllRecipesFor(AutoMechanicTableRecipe.TYPE));
    }
}
