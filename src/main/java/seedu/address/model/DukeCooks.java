package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.person.Food;
import seedu.address.model.person.UniqueFoodList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class DukeCooks implements ReadOnlyDukeCooks {

    private final UniqueFoodList foods;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        foods = new UniqueFoodList();
    }

    public DukeCooks() {}

    /**
     * Creates a DukeCooks using the Persons in the {@code toBeCopied}
     */
    public DukeCooks(ReadOnlyDukeCooks toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setFoods(List<Food> foods) {
        this.foods.setFoods(foods);
    }

    /**
     * Resets the existing data of this {@code DukeCooks} with {@code newData}.
     */
    public void resetData(ReadOnlyDukeCooks newData) {
        requireNonNull(newData);

        setFoods(newData.getFoodList());
    }

    //// person-level operations

    /**
     * Returns true if a food with the same identity as {@code food} exists in Duke Cooks.
     */
    public boolean hasFood(Food food) {
        requireNonNull(food);
        return foods.contains(food);
    }


    /**
     * Adds a person to Duke Cooks.
     * The person must not already exist in Duke Cooks.
     */
    public void addFood(Food f) {
        foods.add(f);
    }


    /**
     * Replaces the given food {@code target} in the list with {@code editedFood}.
     * {@code target} must exist in Duke Cooks.
     * The food identity of {@code editedPerson} must not be the same as another existing food in Duke Cooks.
     */
    public void setFood(Food target, Food editedFood) {
        requireNonNull(editedFood);

        foods.setFood(target, editedFood);
    }

    /**
     * Removes {@code key} from this {@code DukeCooks}.
     * {@code key} must exist in Duke Cooks.
     */
    public void removeFood(Food key) {
        foods.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return foods.asUnmodifiableObservableList().size() + " foods";
        // TODO: refine later
    }

    @Override
    public ObservableList<Food> getFoodList() {
        return foods.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DukeCooks // instanceof handles nulls
                && foods.equals(((DukeCooks) other).foods));
    }

    @Override
    public int hashCode() {
        return foods.hashCode();
    }
}
