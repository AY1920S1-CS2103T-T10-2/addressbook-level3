package dukecooks.logic.commands.profile;

import static java.util.Objects.requireNonNull;

import dukecooks.logic.commands.AddCommand;
import dukecooks.model.Model;
import dukecooks.logic.commands.CommandResult;
import dukecooks.logic.commands.exceptions.CommandException;
import dukecooks.model.profile.person.Person;

/**
 * Adds a person to Duke Cooks.
 */
public class AddProfileCommand extends AddCommand {

    public static final String VARIANT_WORD = "profile";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to Duke Cooks. ";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";

    private final Person toAdd;

    /**
     * Creates an AddProfileCommand to add the specified {@code Person}
     */
    public AddProfileCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddProfileCommand // instanceof handles nulls
                && toAdd.equals(((AddProfileCommand) other).toAdd));
    }
}
