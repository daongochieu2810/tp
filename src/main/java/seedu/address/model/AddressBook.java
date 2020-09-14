package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.UniqueRecipeList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameRecipe comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueRecipeList Recipes;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        Recipes = new UniqueRecipeList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Recipes in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the Recipe list with {@code Recipes}.
     * {@code Recipes} must not contain duplicate Recipes.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.Recipes.setRecipes(recipes);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setRecipes(newData.getRecipeList());
    }

    //// Recipe-level operations

    /**
     * Returns true if a Recipe with the same identity as {@code Recipe} exists in the address book.
     */
    public boolean hasRecipe(Recipe recipe) {
        requireNonNull(recipe);
        return Recipes.contains(recipe);
    }

    /**
     * Adds a Recipe to the address book.
     * The Recipe must not already exist in the address book.
     */
    public void addRecipe(Recipe p) {
        Recipes.add(p);
    }

    /**
     * Replaces the given Recipe {@code target} in the list with {@code editedRecipe}.
     * {@code target} must exist in the address book.
     * The Recipe identity of {@code editedRecipe} must not be the same as another existing Recipe in the address book.
     */
    public void setRecipe(Recipe target, Recipe editedRecipe) {
        requireNonNull(editedRecipe);

        Recipes.setRecipe(target, editedRecipe);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeRecipe(Recipe key) {
        Recipes.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return Recipes.asUnmodifiableObservableList().size() + " Recipes";
        // TODO: refine later
    }

    @Override
    public ObservableList<Recipe> getRecipeList() {
        return Recipes.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && Recipes.equals(((AddressBook) other).Recipes));
    }

    @Override
    public int hashCode() {
        return Recipes.hashCode();
    }
}
