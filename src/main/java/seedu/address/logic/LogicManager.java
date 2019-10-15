package seedu.address.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.DukeCooksParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.profile.Model;
import seedu.address.profile.ReadOnlyUserProfile;
import seedu.address.profile.person.Person;
import seedu.address.profile.records.Record;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final DukeCooksParser dukeCooksParser;

    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        dukeCooksParser = new DukeCooksParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = dukeCooksParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveUserProfile(model.getUserProfile());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        try {
            storage.saveHealthRecords(model.getHealthRecords());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyUserProfile getUserProfile() {
        return model.getUserProfile();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public ObservableList<Record> getFilteredRecordList() {
        return model.getFilteredRecordList();
    }

    @Override
    public Path getUserProfileFilePath() {
        return model.getUserProfileFilePath();
    }

    @Override
    public Path getHealthRecordsFilePath() {
        return model.getHealthRecordsFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
