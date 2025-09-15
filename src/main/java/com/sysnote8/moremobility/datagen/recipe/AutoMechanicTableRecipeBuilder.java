package com.sysnote8.moremobility.datagen.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.foundationgames.automobility.recipe.AutoMechanicTableRecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AutoMechanicTableRecipeBuilder {
    protected final RecipeSerializer<?> type;
    protected final ResourceLocation category;
    protected final int sortNum;
    protected final List<Ingredient> ingredients = new ArrayList<>();
    protected final ResultStack resultStack;

    public AutoMechanicTableRecipeBuilder(RecipeSerializer<?> type, ResourceLocation category, int sortNum, ResultStack resultStack) {
        this.type = type;
        this.category = category;
        this.sortNum = sortNum;
        this.resultStack = resultStack;
    }

    public static AutoMechanicTableRecipeBuilder autoMechanic(ResourceLocation recipeCategory, ResultStack resultStack) {
        return new AutoMechanicTableRecipeBuilder(AutoMechanicTableRecipeSerializer.INSTANCE, recipeCategory, 1, resultStack);
    }

    public static AutoMechanicTableRecipeBuilder autoMechanic(ResourceLocation recipeCategory, ResultStack resultStack, int sortNum) {
        return new AutoMechanicTableRecipeBuilder(AutoMechanicTableRecipeSerializer.INSTANCE, recipeCategory, sortNum, resultStack);
    }

    public AutoMechanicTableRecipeBuilder add(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public void save(Consumer<FinishedRecipe> recipeConsumer, ResourceLocation recipeId) {
        recipeConsumer.accept(new Result(
                recipeId,
                type,
                category,
                sortNum,
                ingredients,
                resultStack
        ));
    }

    public record ResultStack(
            Item item,
            int count,
            @Nullable ResourceLocation component
    ) {
        public static ResultStack from(ItemLike item) {
            return from(item, 1);
        }

        public static ResultStack from(ItemLike item, int count) {
            return from(item, count, null);
        }

        public static ResultStack from(ItemLike item, int count, ResourceLocation component) {
            // validate args
            if(item == null) throw new RuntimeException("item is null");
            if(count < 1) throw new RuntimeException("count must be 1 or more");

            return new ResultStack(
                    item.asItem(),
                    count,
                    component
            );
        }
    }

    public record Result(
            ResourceLocation id,
            RecipeSerializer<?> type,
            ResourceLocation category,
            int sortNum,
            List<Ingredient> ingredients,
            ResultStack resultStack
    ) implements FinishedRecipe {
        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("category", category.toString());
            json.addProperty("sortnum", sortNum);
            json.add("ingredients", serializeIngredients(ingredients));
            json.add("result", serializeResult(resultStack));
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return type;
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return null;
        }

        @SuppressWarnings("deprecation")
        public static JsonElement serializeResult(ResultStack resultStack) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("item", BuiltInRegistries.ITEM.getKey(resultStack.item).toString());
            jsonObject.addProperty("count", resultStack.count);
            if(resultStack.component != null) {
                jsonObject.addProperty("component", resultStack.component.toString());
            }

            return jsonObject;
        }

        public static JsonElement serializeIngredients(List<Ingredient> ingredients) {
            JsonArray array = new JsonArray();
            for(Ingredient ingredient: ingredients) {
                array.add(ingredient.toJson());
            }
            return array;
        }
    }
}
