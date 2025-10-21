package com.sysnote8.moremobility.integration.emi;

import com.sysnote8.moremobility.mixin.accessor.AutoMechanicTableRecipeAccessor;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AutoMechanicTableEmiRecipe implements EmiRecipe {
    protected final ResourceLocation id;
    protected final List<EmiIngredient> input;
    protected final List<EmiStack> output;

    public AutoMechanicTableEmiRecipe(AutoMechanicTableRecipe recipe) {
        this.id = recipe.getId();
        this.input = ((AutoMechanicTableRecipeAccessor) recipe)
                .ingredients()
                .stream()
                .map(EmiIngredient::of)
                .toList();
        this.output = List.of(EmiStack.of(recipe.getResultItem()));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return MMEMIPlugin.AUTO_MECHANIC_TABLE;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 154;
    }

    @Override
    public int getDisplayHeight() {
        return 37;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, getDisplayWidth() - 18 - 28, 19);
        for (int i = 0; i < 9; i++) {
            widgets.addSlot(i < input.size() ? input.get(i) : EmiStack.EMPTY, 17 * i, 0);
        }

        widgets.addSlot(output.get(0), getDisplayWidth() - 18, 19).recipeContext(this);
    }
}
