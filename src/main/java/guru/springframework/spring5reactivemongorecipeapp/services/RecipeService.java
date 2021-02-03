package guru.springframework.spring5reactivemongorecipeapp.services;

import guru.springframework.spring5reactivemongorecipeapp.commands.RecipeCommand;
import guru.springframework.spring5reactivemongorecipeapp.domain.Recipe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface RecipeService {

    Flux<Recipe> getRecipes();

    Mono<Recipe> findById(String l);

    Mono<RecipeCommand> findCommandById(String l);

    Mono<RecipeCommand> saveRecipeCommand(RecipeCommand command);

    Mono<Void> deleteById(String idToDelete);
}
