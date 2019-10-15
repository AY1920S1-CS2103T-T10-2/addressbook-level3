package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.person.Food;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Food> PREDICATE_SHOW_ALL_FOODS = unused -> true;


    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' DukeCooks file path.
     */
    Path getDukeCooksFilePath();

    /**
     * Sets the user prefs' Duke Cooks file path.
     */
    void setDukeCooksFilePath(Path dukeCooksFilePath);

    /**
     * Replaces Duke Cooks data with the data in {@code dukeCooks}.
     */
    void setDukeCooks(ReadOnlyDukeCooks dukeCooks);

    /** Returns DukeCooks */
    ReadOnlyDukeCooks getDukeCooks();


    /**
     * Returns true if a food with the same identity as {@code food} exists in Duke Cooks.
     */
    boolean hasFood(Food food);


    /**
     * Adds the given food.
     * {@code food} must not already exist in Duke Cooks.
     */
    void addFood(Food food);


    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Food> getFilteredFoodList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Food> predicate);
}
