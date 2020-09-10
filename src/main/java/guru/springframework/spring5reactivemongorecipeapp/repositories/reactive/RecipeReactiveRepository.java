package guru.springframework.spring5reactivemongorecipeapp.repositories.reactive;

import guru.springframework.spring5reactivemongorecipeapp.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
