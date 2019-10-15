package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Food;

/**
 * Adds a person to Duke Cooks.
 */
public class AddFoodCommand extends Command {

    public static final String COMMAND_WORD = "addfood";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a food to Duke Cooks. "
            + "Parameters: "
            + PREFIX_FOOD + "FOODNAME ";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_FOOD = "This food already exists in Duke Cooks";

    private final Food toAdd;

    /**
     * Creates an AddFood to add the specified {@code Food}
     */
    public AddFoodCommand(Food food) {
        requireNonNull(food);
        toAdd = food;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasFood(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_FOOD);
        }

        model.addFood(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFoodCommand // instanceof handles nulls
                && toAdd.equals(((AddFoodCommand) other).toAdd));
    }
}
