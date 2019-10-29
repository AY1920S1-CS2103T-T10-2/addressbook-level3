package dukecooks.model.workout;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import dukecooks.model.workout.exercise.components.Exercise;
import dukecooks.model.workout.exercise.components.Intensity;
import dukecooks.model.workout.exercise.components.MuscleType;
import dukecooks.model.workout.exercise.details.ExerciseDetail;
import dukecooks.model.workout.history.WorkoutHistory;

/**
 * Represents a Workout in the WorkoutPlanner.
 */
public class Workout {

    private WorkoutName name;
    private ArrayList<Exercise> exercises;
    private ArrayList<Set<ExerciseDetail>> exercisesDetails;
    private ArrayList<MuscleType> musclesTrained;
    private Intensity averageIntensity;
    private WorkoutHistory history;

    public Workout(WorkoutName name){
        this.name = name;
        exercises = new ArrayList<>();
        exercisesDetails = new ArrayList<>();
        musclesTrained = new ArrayList<>();
        averageIntensity = Intensity.LOW;
        history = new WorkoutHistory(new ArrayList<>());
    }

    public Workout(WorkoutName name, ArrayList<Exercise> exercises, ArrayList<Set<ExerciseDetail>> exercisesDetails,
                   ArrayList<MuscleType> musclesTrained, Intensity averageIntensity, WorkoutHistory history) {
        this.name = name;
        this.exercises = exercises;
        this.exercisesDetails = exercisesDetails;
        this.musclesTrained = musclesTrained;
        this.averageIntensity = averageIntensity;
        this.history = history;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public ArrayList<MuscleType> getMusclesTrained() {
        return musclesTrained;
    }

    public ArrayList<Set<ExerciseDetail>> getExercisesDetails() {
        return exercisesDetails;
    }

    public Intensity getAverageIntensity() {
        return averageIntensity;
    }

    public WorkoutName getName() {
        return name;
    }

    public WorkoutHistory getHistory() {
        return history;
    }

    /**
     * Returns true if both exercises of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two exercises.
     */
    public boolean isSameWorkout(Workout otherWorkout) {
        if (otherWorkout == this) {
            return true;
        }

        return otherWorkout != null
                && otherWorkout.getName().equals(getName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Workout)) {
            return false;
        }

        Workout otherWorkout = (Workout) other;
        return otherWorkout.getName().equals(getName())
                && otherWorkout.getMusclesTrained().equals(getMusclesTrained())
                && otherWorkout.getAverageIntensity().equals(getAverageIntensity())
                && otherWorkout.getExercisesDetails().equals(getExercisesDetails())
                && otherWorkout.getExercises().equals(getExercises())
                && otherWorkout.getHistory().equals(getHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, exercises, exercisesDetails, musclesTrained, averageIntensity, history);
    }
}
