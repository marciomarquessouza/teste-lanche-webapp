package br.com.dextra.alfredlancheswebapp.services;

import br.com.dextra.alfredlancheswebapp.models.Recipe;

public interface RecipeService {

    Iterable<Recipe> listAllRecipes();

    Recipe getRecipeById(Integer id);

    Recipe saveRecipe(Recipe recipe);

    void deleteRecipe(Recipe recipe);
}
