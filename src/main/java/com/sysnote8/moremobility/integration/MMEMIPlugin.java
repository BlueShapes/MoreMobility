package com.sysnote8.moremobility.integration;

import com.sysnote8.moremobility.MoreMobility;
import com.sysnote8.moremobility.mixin.accessor.AutoMechanicTableRecipeAccessor;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import io.github.foundationgames.automobility.block.AutomobilityBlocks;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

@EmiEntrypoint
public class MMEMIPlugin implements EmiPlugin {
    private static final Logger logger = LoggerFactory.getLogger("moremobility-emi");

    public static final ResourceLocation AUTO_MECHANIC_TEXTURE_ID = MoreMobility.id("textures/gui/emi/simplified_auto_mechanic.png");
    public static final EmiTexture AUTO_MECHANIC = new EmiTexture(AUTO_MECHANIC_TEXTURE_ID, 0, 0, 16,16,16,16,16,16);
    public static final EmiStack AUTO_MECHANIC_TABLE_STACK = EmiStack.of(AutomobilityBlocks.AUTO_MECHANIC_TABLE.require().asItem());

    public static final EmiRecipeCategory AUTO_MECHANIC_TABLE = new EmiRecipeCategory(
            MoreMobility.id("auto_mechanic_table"),
            AUTO_MECHANIC_TABLE_STACK,
            AUTO_MECHANIC
    );

    @Override
    public void register(EmiRegistry registry) {
        logger.info("Registering EMI Plugin....");
        registry.addCategory(AUTO_MECHANIC_TABLE);
        registry.addWorkstation(AUTO_MECHANIC_TABLE, AUTO_MECHANIC_TABLE_STACK);

        RecipeManager recipeManager = registry.getRecipeManager();

        for(AutoMechanicTableRecipe recipe: recipeManager.getAllRecipesFor(AutoMechanicTableRecipe.TYPE)) {
            registry.addRecipe(new AutoMechanicTableEmiRecipe(recipe));
        }
        logger.info("EMI registration completed.");
    }
}
