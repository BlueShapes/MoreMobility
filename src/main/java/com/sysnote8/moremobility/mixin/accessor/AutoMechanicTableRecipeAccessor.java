package com.sysnote8.moremobility.mixin.accessor;

import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(AutoMechanicTableRecipe.class)
public interface AutoMechanicTableRecipeAccessor {
    @Accessor(value = "ingredients", remap = false)
    Set<Ingredient> ingredients();
}
