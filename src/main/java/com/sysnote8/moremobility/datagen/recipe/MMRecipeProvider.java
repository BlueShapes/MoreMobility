package com.sysnote8.moremobility.datagen.recipe;

import com.sysnote8.moremobility.MoreMobility;
import com.sysnote8.moremobility.attachment.AdvancedCropHarvesterAttachment;
import com.sysnote8.moremobility.attachment.MMAttachments;
import com.sysnote8.moremobility.engine.MMEngines;
import com.sysnote8.moremobility.frame.MMFrames;
import io.github.foundationgames.automobility.automobile.AutomobileComponent;
import io.github.foundationgames.automobility.automobile.AutomobileEngine;
import io.github.foundationgames.automobility.automobile.AutomobileFrame;
import io.github.foundationgames.automobility.automobile.attachment.BaseAttachment;
import io.github.foundationgames.automobility.automobile.attachment.FrontAttachmentType;
import io.github.foundationgames.automobility.item.AutomobilityItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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

        // front attachments
        frontAttachment(MMAttachments.ADVANCED_CROP_HARVESTER, 1, 9990001)
                .add(Ingredient.of(Tags.Items.RODS))
                .add(Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS))
                .add(Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD))
                .add(Ingredient.of(Tags.Items.STORAGE_BLOCKS_COPPER))
                .add(Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD))
                .add(Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS))
                .add(Ingredient.of(Tags.Items.RODS))
                .save(writer, attachmentId("advanced_crop_harvester"));

        // engines
        engine(MMEngines.NETHERITE,1,9990001)
                .add(Ingredient.of(Tags.Items.INGOTS_NETHERITE))
                .add(Ingredient.of(Items.FURNACE))
                .add(Ingredient.of(Items.REDSTONE_BLOCK))
                .add(Ingredient.of(Items.OBSIDIAN))
                .add(Ingredient.of(Tags.Items.INGOTS_NETHERITE))
                .save(writer, engineId("netherite"));

        // frames
        frame(MMFrames.SILVER, 1, 9990001)
                .add(Ingredient.of(Items.REDSTONE))
                .add(Ingredient.of(Tags.Items.INGOTS_GOLD))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .add(Ingredient.of(Tags.Items.GEMS_QUARTZ))
                .add(Ingredient.of(Tags.Items.LEATHER))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .save(writer, frameId("silver"));

        frame(MMFrames.RACE_SHOPPING_CART, 1, 9990002)
                .add(Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .add(Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON))
                .add(Ingredient.of(Tags.Items.INGOTS_COPPER))
                .add(Ingredient.of(Tags.Items.INGOTS_IRON))
                .save(writer, frameId("race_shopping_cart"));

        logger.info("recipe generated!");
    }

    public static AutoMechanicTableRecipeBuilder frontAttachment(FrontAttachmentType<?> attachment, int count, int sortNum) {
        return autoMechanicTable(
                AutoMechanicRecipeType.FRONT_ATTACHMENT,
                attachment,
                count,
                sortNum
        );
    }

    public static AutoMechanicTableRecipeBuilder engine(AutomobileEngine engine, int count, int sortNum) {
        return autoMechanicTable(
                AutoMechanicRecipeType.ENGINE,
                engine,
                count,
                sortNum
        );
    }

    public static AutoMechanicTableRecipeBuilder frame(AutomobileFrame frame, int count, int sortNum) {
        return autoMechanicTable(
                AutoMechanicRecipeType.FRAME,
                frame,
                count,
                sortNum
        );
    }

    public static <T extends AutomobileComponent<T>> AutoMechanicTableRecipeBuilder autoMechanicTable(AutoMechanicRecipeType<T> recipeType, T data, int count, int sortNum) {
        return AutoMechanicTableRecipeBuilder.autoMechanic(recipeType.getRecipeCategory(), AutoMechanicTableRecipeBuilder.ResultStack.from(
                recipeType.getEventual().require(),
                count,
                data.getId()
        ), sortNum);
    }

    public static ResourceLocation attachmentId(String path) {
        return MoreMobility.id("attachment/" + path);
    }

    public static ResourceLocation engineId(String path) {
        return MoreMobility.id("engine/" + path);
    }

    public static ResourceLocation frameId(String path) {
        return MoreMobility.id("frame/" + path);
    }
}
