package br.com.dextra.alfredlancheswebapp.services;

import br.com.dextra.alfredlancheswebapp.models.ItemRecipe;
import br.com.dextra.alfredlancheswebapp.models.Recipe;
import br.com.dextra.alfredlancheswebapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviços CRUD das Receitas
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> listAllRecipes() {

        Iterable<Recipe> recipes = recipeRepository.findAll();

        recipes.forEach(item->item.setAmount(sumReciepeItem(item)));

        return recipes;
    }

    @Override
    public Recipe getRecipeById(Integer id) {

        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setAmount(sumReciepeItem(recipe));
        return recipe;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    public Double sumReciepeItem(Recipe recipe) {

        Double total = 0d;

        for (ItemRecipe itemRecipe : recipe.getItemRecipes() ) {
            total += itemRecipe.getQuantity() * itemRecipe.getItem().getPrice();
        }

        return total;

    }
}
