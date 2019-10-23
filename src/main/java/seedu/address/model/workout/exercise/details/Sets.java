package seedu.address.model.workout.exercise.details;

import static java.util.Objects.requireNonNull;

/**
 * Represents the number of Sets of an exercise in Workout Planner.
 * Guarantees: immutable;
 */

public class Sets<Integer> extends ExerciseDetail {

    public Sets(int sets) {
        requireNonNull(sets);
        super.magnitude = sets;
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[Number of sets: ")
                .append(getMagnitude())
                .append("]");
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Sets)) {
            return false;
        }

        Sets otherSets = (Sets) other;
        return otherSets.getMagnitude().equals(getMagnitude());
    }

    @Override
    public int hashCode() {
        return magnitude.hashCode();
    }
}
