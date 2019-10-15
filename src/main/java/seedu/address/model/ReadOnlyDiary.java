package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.diary.Diary;

/**
 * Unmodifiable view of Duke Cooks
 */
public interface ReadOnlyDiary {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate diaries.
     */
    ObservableList<Diary> getDiaryList();

}
