package com.sysnote8.moremobility.integration.jei;

import com.sysnote8.moremobility.MoreMobility;
import com.sysnote8.moremobility.integration.SharedTexture;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.common.gui.elements.DrawableResource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class AutoMechanicTableJeiCategory extends AbstractRecipeCategory<AutoMechanicTableRecipe> {
    /**
     * @since 15.20.0
     */
    public AutoMechanicTableJeiCategory() {
        super(
                RecipeType.create(MoreMobility.MODID, "auto_mechanic_table", AutoMechanicTableRecipe.class),
                Component.literal("aaa"),
                new DrawableResource(SharedTexture.AUTO_MECHANIC_TEXTURE_ID, 0, 0, 16, 16, 0, 0, 0, 0, 16, 16),
                9,
                1
        );
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull AutoMechanicTableRecipe recipe, @NotNull IFocusGroup focuses) {
        recipe.getIngredients().forEach(ingredient -> builder.addInputSlot(0, 0).addIngredients(Ingredient.of(ingredient.getItems())));
        builder.addOutputSlot().addItemStack(recipe.getResultItem());
    }
}
