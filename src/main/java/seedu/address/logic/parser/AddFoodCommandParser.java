package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddFoodCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Food;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddFoodCommandParser implements Parser<AddFoodCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddFoodCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_FOOD, PREFIX_TIMES);

        if (!arePrefixesPresent(argMultimap, PREFIX_FOOD)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddFoodCommand.MESSAGE_USAGE));
        }

        String name = ParserUtil.parseFood(argMultimap.getValue(PREFIX_FOOD).get());
        int times = ParserUtil.parseTimes(argMultimap.getValue(PREFIX_TIMES).get());

        Food food = new Food(name, times);

        return new AddFoodCommand(food);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
