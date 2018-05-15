package br.com.dextra.alfredlancheswebapp.repositories;

import br.com.dextra.alfredlancheswebapp.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> { }
