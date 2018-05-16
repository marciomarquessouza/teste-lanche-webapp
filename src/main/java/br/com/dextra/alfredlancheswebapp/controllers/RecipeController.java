package br.com.dextra.alfredlancheswebapp.controllers;

import br.com.dextra.alfredlancheswebapp.models.Recipe;
import br.com.dextra.alfredlancheswebapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RecipeController {
    
    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "recipe/new", method = RequestMethod.POST)
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "admintemplate/pages/recipeform";
    }

    @RequestMapping(value = "recipe", method = RequestMethod.POST)
    public String saveRecipe(Recipe recipe) {
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }

    @RequestMapping(value = "recipe/{id}", method = RequestMethod.GET)
    public String showRecipe(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "recipeshow";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String list(Model model){

        model.addAttribute("recipes", recipeService.listAllRecipes());
        return  "admintemplate/pages/recipes";
    }

    @RequestMapping("recipe/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        return "admintemplate/pages/recipeshow";
    }

    @RequestMapping(value = "recipe/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        recipeService.deleteRecipe(recipeService.getRecipeById(id));
        return "redirect:/recipes";
    }
}
