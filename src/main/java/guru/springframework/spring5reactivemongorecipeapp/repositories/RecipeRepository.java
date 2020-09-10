package guru.springframework.spring5reactivemongorecipeapp.repositories;

import guru.springframework.spring5reactivemongorecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
