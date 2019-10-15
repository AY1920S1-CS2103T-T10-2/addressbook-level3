package seedu.address.profile;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path dukeCooksFilePath = Paths.get("data" , "dukecooks.json");
    private Path healthRecordsFilePath = Paths.get("data", "healthrecords.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setDukeCooksFilePath(newUserPrefs.getDukeCooksFilePath());
        setHealthRecordsFilePath(newUserPrefs.getHealthRecordsFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getDukeCooksFilePath() {
        return dukeCooksFilePath;
    }

    public void setDukeCooksFilePath(Path dukeCooksFilePath) {
        requireNonNull(dukeCooksFilePath);
        this.dukeCooksFilePath = dukeCooksFilePath;
    }

    public Path getHealthRecordsFilePath() {
        return healthRecordsFilePath;
    }

    public void setHealthRecordsFilePath(Path healthRecordsFilePath) {
        requireNonNull(healthRecordsFilePath);
        this.healthRecordsFilePath = healthRecordsFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && dukeCooksFilePath.equals(o.dukeCooksFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, dukeCooksFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + dukeCooksFilePath);
        return sb.toString();
    }

}
