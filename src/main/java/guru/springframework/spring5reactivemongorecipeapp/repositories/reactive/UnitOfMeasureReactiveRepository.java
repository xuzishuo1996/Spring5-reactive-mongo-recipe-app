package guru.springframework.spring5reactivemongorecipeapp.repositories.reactive;

import guru.springframework.spring5reactivemongorecipeapp.domain.UnitOfMeasure;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {
}
