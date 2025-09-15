package com.sysnote8.moremobility.datagen.recipe;

import com.sysnote8.moremobility.MoreMobility;
import com.sysnote8.moremobility.engine.MMEngines;
import io.github.foundationgames.automobility.item.AutomobilityItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class MMRecipeProvider extends RecipeProvider {
    private static final Logger logger = LoggerFactory.getLogger(MMRecipeProvider.class);

    public MMRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        logger.info("generating recipes...");
        engineRecipe(AutoMechanicTableRecipeBuilder.ResultStack.from(
                AutomobilityItems.AUTOMOBILE_ENGINE.require(),
                1,
                MMEngines.NETHERITE.getId()
        ), 4)
                .add(Ingredient.of(Tags.Items.INGOTS_NETHERITE))
                .add(Ingredient.of(Items.FURNACE))
                .add(Ingredient.of(Items.REDSTONE_BLOCK))
                .add(Ingredient.of(Items.OBSIDIAN))
                .add(Ingredient.of(Tags.Items.INGOTS_NETHERITE))
                .save(writer, MoreMobility.id("netherite_engine"));
        logger.info("recipe generated!");
    }

    public static AutoMechanicTableRecipeBuilder attachmentRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack) {
        return engineRecipe(resultStack, 1);
    }

    public static AutoMechanicTableRecipeBuilder attachmentRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack, int sortNum) {
        return AutoMechanicTableRecipeBuilder.autoMechanic(MMRecipeCategories.ATTACHMENTS, resultStack, sortNum);
    }

    public static AutoMechanicTableRecipeBuilder engineRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack) {
        return engineRecipe(resultStack, 1);
    }

    public static AutoMechanicTableRecipeBuilder engineRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack, int sortNum) {
        return AutoMechanicTableRecipeBuilder.autoMechanic(MMRecipeCategories.ENGINES, resultStack, sortNum);
    }

    public static AutoMechanicTableRecipeBuilder frameRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack) {
        return engineRecipe(resultStack, 1);
    }

    public static AutoMechanicTableRecipeBuilder frameRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack, int sortNum) {
        return AutoMechanicTableRecipeBuilder.autoMechanic(MMRecipeCategories.FRAMES, resultStack, sortNum);
    }

    public static AutoMechanicTableRecipeBuilder wheelRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack) {
        return engineRecipe(resultStack, 1);
    }

    public static AutoMechanicTableRecipeBuilder wheelRecipe(AutoMechanicTableRecipeBuilder.ResultStack resultStack, int sortNum) {
        return AutoMechanicTableRecipeBuilder.autoMechanic(MMRecipeCategories.WHEELS, resultStack, sortNum);
    }
}
