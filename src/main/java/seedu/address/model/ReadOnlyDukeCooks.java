package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.exercise.Exercise;

/**
 * Unmodifiable view of Duke Cooks
 */
public interface ReadOnlyDukeCooks {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Exercise> getExerciseList();

}
