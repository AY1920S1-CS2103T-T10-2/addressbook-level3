package dukecooks.logic;

import java.nio.file.Path;

import dukecooks.commons.core.GuiSettings;
import dukecooks.logic.commands.CommandResult;
import dukecooks.logic.commands.exceptions.CommandException;
import dukecooks.logic.parser.exceptions.ParseException;
import dukecooks.model.Model;
import dukecooks.model.dashboard.ReadOnlyDashboard;
import dukecooks.model.dashboard.components.Dashboard;
import dukecooks.model.diary.ReadOnlyDiary;
import dukecooks.model.diary.components.Diary;
import dukecooks.model.health.components.Record;
import dukecooks.model.mealplan.ReadOnlyMealPlanBook;
import dukecooks.model.profile.ReadOnlyUserProfile;
import dukecooks.model.profile.person.Person;
import dukecooks.model.recipe.ReadOnlyRecipeBook;
import dukecooks.model.recipe.components.Recipe;
import dukecooks.model.workout.exercise.ReadOnlyWorkoutPlanner;
import dukecooks.model.workout.exercise.components.Exercise;
import javafx.collections.ObservableList;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns RecipeBook.
     *
     * @see Model#getRecipeBook()
     */
    ReadOnlyRecipeBook getRecipeBook();

    /**
     * Returns MealPlanBook.
     *
     * @see Model#getMealPlanBook()
     */
    ReadOnlyMealPlanBook getMealPlanBook();

    /**
     * Returns TodoRecords.
     *
     * @see Model#getDashboardRecords()
     */
    ReadOnlyDashboard getDashboardRecords();

    /**
     * Returns DiaryRecords.
     *
     * @see Model#getDiaryRecords()
     */
    ReadOnlyDiary getDiaryRecords();

    /**
     * Returns UserProfile.
     *
     * @see Model#getUserProfile()
     */
    ReadOnlyUserProfile getUserProfile();

    /**
     * Returns DukeCooks.
     *
     * @see Model#getWorkoutPlanner()
     */
    ReadOnlyWorkoutPlanner getDukeCooks();

    /** Returns an unmodifiable view of the filtered list of recipes */
    ObservableList<Recipe> getFilteredRecipeList();

    /** Returns an unmodifiable view of the filtered list of diaries */
    ObservableList<Diary> getFilteredDiaryList();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Exercise> getFilteredExerciseList();

    /** Returns an unmodifiable view of the filtered list of records */
    ObservableList<Record> getFilteredRecordList();

    /** Returns an unmodifiable view of the filtered list of dashboards */
    ObservableList<Dashboard> getFilteredDashboardList();

    /**
     * Returns the user prefs' Recipe Book file path.
     */
    Path getRecipesFilePath();

    /**
     * Returns the user prefs' User Profile file path.
     */
    Path getUserProfileFilePath();

    /**
     * Returns the user prefs' Duke Cooks file path.
     */
    Path getDukeCooksFilePath();

    /**
     * Returns the user prefs' Health Records file path.
     */
    Path getHealthRecordsFilePath();

    /**
     * Returns the user prefs' Duke Cooks file path.
     */
    Path getDiaryFilePath();

    /**
     * Returns the user prefs' Dashboard file path.
     */
    Path getDashboardFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
