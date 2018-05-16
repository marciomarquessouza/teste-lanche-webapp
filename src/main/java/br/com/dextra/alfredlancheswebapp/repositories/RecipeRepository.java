package br.com.dextra.alfredlancheswebapp.repositories;

import br.com.dextra.alfredlancheswebapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> { }
