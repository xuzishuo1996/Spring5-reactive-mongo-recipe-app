package guru.springframework.spring5reactivemongorecipeapp.services;

import guru.springframework.spring5reactivemongorecipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
