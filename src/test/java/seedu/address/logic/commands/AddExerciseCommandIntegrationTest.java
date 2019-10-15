package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalExercises.getTypicalDukeCooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.WorkoutPlannerUserPrefs;
import seedu.address.model.exercise.Exercise;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddExerciseCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalDukeCooks(), new WorkoutPlannerUserPrefs());
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Exercise exerciseInList = model.getDukeCooks().getExerciseList().get(0);
        assertCommandFailure(new AddExerciseCommand(exerciseInList), model, AddExerciseCommand
                .MESSAGE_DUPLICATE_PERSON);
    }

}
