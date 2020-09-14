package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.recipe.Recipe;

/**
 * A utility class containing a list of {@code Recipe} objects to be used in tests.
 */
public class TypicalRecipes {

    public static final Recipe ALICE = new RecipeBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withTags("friends").build();
    public static final Recipe BENSON = new RecipeBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com")
            .withTags("owesMoney", "friends").build();
    public static final Recipe CARL = new RecipeBuilder().withName("Carl Kurz")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Recipe DANIEL = new RecipeBuilder().withName("Daniel Meier")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Recipe ELLE = new RecipeBuilder().withName("Elle Meyer")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Recipe FIONA = new RecipeBuilder().withName("Fiona Kunz")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Recipe GEORGE = new RecipeBuilder().withName("George Best")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Recipe HOON = new RecipeBuilder().withName("Hoon Meier")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Recipe IDA = new RecipeBuilder().withName("Ida Mueller")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Recipe's details found in {@code CommandTestUtil}
    public static final Recipe AMY = new RecipeBuilder().withName(VALID_NAME_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Recipe BOB = new RecipeBuilder().withName(VALID_NAME_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalRecipes() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical Recipes.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Recipe recipe : getTypicalRecipes()) {
            ab.addRecipe(recipe);
        }
        return ab;
    }

    public static List<Recipe> getTypicalRecipes() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
