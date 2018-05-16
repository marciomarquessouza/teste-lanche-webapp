package br.com.dextra.alfredlancheswebapp.controllers;

import br.com.dextra.alfredlancheswebapp.message.Response;
import br.com.dextra.alfredlancheswebapp.models.Recipe;
import br.com.dextra.alfredlancheswebapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe/api/")
public class RecipeRestWebController {
    
    private RecipeService recipeService;
    
    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(value = "/save")
    public Response postRecipe(@RequestBody Recipe recipe) {

        recipeService.saveRecipe(recipe);
        Response response = new Response("Done", recipe);
        return response;
    }

    @GetMapping(value = "/all")
    public Response getAllRecipe() {
        Response response = new Response("Done", recipeService.listAllRecipes());
        return response;
    }

    @GetMapping(value = "/view")
    public Response getRecipe(@RequestBody Integer id) {

        Response response = new Response("Done", recipeService.getRecipeById(id));
        return response;
    }

    @DeleteMapping(value = "/remove")
    public Response deleteRecipe(@RequestBody Recipe recipe) {

        recipeService.deleteRecipe(recipe);
        Response response = new Response("Done", recipeService.listAllRecipes());
        return response;

    }
    
}
