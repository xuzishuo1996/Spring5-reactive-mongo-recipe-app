package guru.springframework.spring5reactivemongorecipeapp.services;

import guru.springframework.spring5reactivemongorecipeapp.commands.RecipeCommand;
import guru.springframework.spring5reactivemongorecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String l);

    RecipeCommand findCommandById(String l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
