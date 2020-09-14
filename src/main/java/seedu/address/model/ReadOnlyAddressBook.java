package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.recipe.Recipe;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the Recipes list.
     * This list will not contain any duplicate Recipes.
     */
    ObservableList<Recipe> getRecipeList();

}
