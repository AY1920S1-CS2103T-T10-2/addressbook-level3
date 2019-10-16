package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_DIARY;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddDiaryCommand;
import seedu.address.logic.commands.DeleteDiaryCommand;
import seedu.address.logic.commands.EditDiaryCommand;
import seedu.address.logic.commands.EditDiaryCommand.EditDiaryDescriptor;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.diary.Diary;
import seedu.address.testutil.DiaryBuilder;
import seedu.address.testutil.DiaryUtil;
import seedu.address.testutil.EditDiaryDescriptorBuilder;


public class DiaryRecordsParserTest {

    private final DukeCooksParser parser = new DukeCooksParser();

    @Test
    public void parseCommand_add() throws Exception {
        Diary diary = new DiaryBuilder().build();
        AddDiaryCommand command = (AddDiaryCommand) parser.parseCommand(DiaryUtil.getAddCommand(diary));
        assertEquals(new AddDiaryCommand(diary), command);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        DeleteDiaryCommand command = (DeleteDiaryCommand) parser.parseCommand(
                DeleteDiaryCommand.COMMAND_WORD + " " + INDEX_FIRST_DIARY.getOneBased());
        assertEquals(new DeleteDiaryCommand(INDEX_FIRST_DIARY), command);
    }

    @Test
    public void parseCommand_edit() throws Exception {
        Diary diary = new DiaryBuilder().build();
        EditDiaryDescriptor descriptor = new EditDiaryDescriptorBuilder(diary).build();
        EditDiaryCommand command = (EditDiaryCommand) parser.parseCommand(EditDiaryCommand.COMMAND_WORD + " "
                + INDEX_FIRST_DIARY.getOneBased() + " " + DiaryUtil.getEditDiaryDescriptorDetails(descriptor));
        assertEquals(new EditDiaryCommand(INDEX_FIRST_DIARY, descriptor), command);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
            -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}
