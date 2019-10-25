package dukecooks.logic.parser.health;

import static dukecooks.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static dukecooks.logic.parser.CliSyntax.PREFIX_DATETIME;
import static dukecooks.logic.parser.CliSyntax.PREFIX_TYPE;
import static dukecooks.logic.parser.CliSyntax.PREFIX_VALUE;

import java.util.stream.Stream;

import dukecooks.logic.commands.health.AddHealthCommand;
import dukecooks.logic.parser.ArgumentMultimap;
import dukecooks.logic.parser.ArgumentTokenizer;
import dukecooks.logic.parser.Parser;
import dukecooks.logic.parser.ParserUtil;
import dukecooks.logic.parser.Prefix;
import dukecooks.logic.parser.exceptions.ParseException;
import dukecooks.model.health.components.Record;
import dukecooks.model.health.components.Timestamp;
import dukecooks.model.health.components.Type;
import dukecooks.model.health.components.Value;

/**
 * Parses input arguments and creates a new AddHealthCommand object
 */
public class AddHealthCommandParser implements Parser<AddHealthCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddHealthCommand
     * and returns an AddHealthCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddHealthCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TYPE, PREFIX_VALUE, PREFIX_DATETIME);

        if (!arePrefixesPresent(argMultimap, PREFIX_TYPE, PREFIX_VALUE, PREFIX_DATETIME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddHealthCommand.MESSAGE_USAGE));
        }

        Type type = ParserUtil.parseType(argMultimap.getValue(PREFIX_TYPE).get());
        Value value = ParserUtil.parseValue(argMultimap.getValue(PREFIX_VALUE).get());
        Timestamp timestamp = ParserUtil.parseTimestamp(argMultimap.getValue(PREFIX_DATETIME).get());

        Record record = new Record(type, value, timestamp);

        return new AddHealthCommand(record);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
