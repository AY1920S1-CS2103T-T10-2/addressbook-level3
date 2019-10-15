package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.person.Food;

/**
 * Unmodifiable view of Duke Cooks
 */
public interface ReadOnlyDukeCooks {

    /**
     * Returns an unmodifiable view of the foods list.
     * This list will not contain any duplicate foods.
     */
    ObservableList<Food> getFoodList();

}
