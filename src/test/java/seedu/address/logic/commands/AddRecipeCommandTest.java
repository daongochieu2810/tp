package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.recipe.Recipe;
import seedu.address.testutil.RecipeBuilder;
import seedu.address.testutil.TypicalIndexes;
import seedu.address.testutil.TypicalRecipes;


public class AddRecipeCommandTest {
    private Model model = new ModelManager(TypicalRecipes.getTypicalAddressBook(), new UserPrefs());
    @Test
    void execute_addRecipeUnfilteredList_success() {
        Recipe firstRecipe = model.getFilteredRecipeList().get(TypicalIndexes.INDEX_FIRST_RECIPE.getZeroBased());
        Recipe editedRecipe = new RecipeBuilder(firstRecipe).withName("HIEU").build();
        AddRecipeCommand addRecipeCommand = new AddRecipeCommand(new Recipe(editedRecipe.getName()));
        String expectedMsg = String.format(AddRecipeCommand.MESSAGE_SUCCESS, editedRecipe);
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setRecipe(firstRecipe, editedRecipe);

        CommandTestUtil.assertCommandSuccess(addRecipeCommand, model, expectedMsg, model);
    }

}