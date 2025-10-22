package com.sysnote8.moremobility.integration.jei;

import com.sysnote8.moremobility.mixin.accessor.AutoMechanicTableRecipeAccessor;
import io.github.foundationgames.automobility.block.AutomobilityBlocks;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class AutoMechanicTableJeiCategory extends AbstractRecipeCategory<AutoMechanicTableRecipe> {
    private final IGuiHelper guiHelper;

    public AutoMechanicTableJeiCategory(IGuiHelper guiHelper) {
        super(
                MMJEIPlugin.AUTO_MECHANIC_TYPE,
                AutomobilityBlocks.AUTO_MECHANIC_TABLE.require().getName(),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(AutomobilityBlocks.AUTO_MECHANIC_TABLE.require())),
                164,
                44
        );
        this.guiHelper = guiHelper;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull AutoMechanicTableRecipe recipe, @NotNull IFocusGroup focuses) {
        Ingredient[] ingredients = ((AutoMechanicTableRecipeAccessor) recipe).ingredients().toArray(new Ingredient[0]);
        for (int i = 0; i < ingredients.length; i++) {
            builder.addInputSlot(i * 18, 0).setStandardSlotBackground().addIngredients(ingredients[i]);
        }
        builder.addOutputSlot(getWidth() - 20, 24).setOutputSlotBackground().addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(@NotNull AutoMechanicTableRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        IDrawableStatic recipeArrow = guiHelper.getRecipeArrow();
        recipeArrow.draw(guiGraphics, getWidth() - recipeArrow.getWidth() - 28, getHeight() - 21);
    }
}
