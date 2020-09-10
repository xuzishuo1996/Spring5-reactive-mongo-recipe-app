package guru.springframework.spring5reactivemongorecipeapp.services;

import guru.springframework.spring5reactivemongorecipeapp.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
