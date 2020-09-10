package guru.springframework.spring5reactivemongorecipeapp.services;

import guru.springframework.spring5reactivemongorecipeapp.commands.RecipeCommand;
import guru.springframework.spring5reactivemongorecipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5reactivemongorecipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5reactivemongorecipeapp.domain.Recipe;
import guru.springframework.spring5reactivemongorecipeapp.exceptions.NotFoundException;
import guru.springframework.spring5reactivemongorecipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipeByIdTest() {

        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById("1");

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipeByIdNotFoundTest() {

        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);

        Exception exception = assertThrows(NotFoundException.class, () ->
                recipeService.findById("1"));

        assertEquals("Recipe Not Found. For ID value: 1", exception.getMessage());
    }

    @Test
    public void getRecipeCommandByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyString())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId("1");

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = recipeService.findCommandById("1");

        assertNotNull("Null recipe returned", commandById);
        verify(recipeRepository, times(1)).findById(anyString());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipesTest() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyString());
    }

    @Test
    void testDeleteById() {

        //given
        String idToDelete = "2";

        //when
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type

        //then
        verify(recipeRepository, times(1)).deleteById(anyString());
    }
}