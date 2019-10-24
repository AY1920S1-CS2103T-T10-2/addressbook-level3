package dukecooks.model.profile.person;

import static dukecooks.testutil.diary.TypicalDiaries.ALL_MEAT;
import static dukecooks.testutil.diary.TypicalDiaries.BOB_DIARY;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dukecooks.logic.commands.CommandTestUtil;
import dukecooks.model.diary.components.Diary;
import dukecooks.testutil.diary.DiaryBuilder;

public class DiaryTest {

    @Test
    public void isSameDiary() {
        // same object -> returns true
        assertTrue(ALL_MEAT.isSameDiary(ALL_MEAT));

        // null -> returns false
        assertFalse(ALL_MEAT.isSameDiary(null));

        // different name -> returns false
        Diary editedDiary = new DiaryBuilder(ALL_MEAT).withName(CommandTestUtil.VALID_NAME_BOB).build();
        assertFalse(ALL_MEAT.isSameDiary(editedDiary));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Diary allMeatCopy = new DiaryBuilder(ALL_MEAT).build();
        assertTrue(ALL_MEAT.equals(allMeatCopy));

        // same object -> returns true
        assertTrue(ALL_MEAT.equals(ALL_MEAT));

        // null -> returns false
        assertFalse(ALL_MEAT.equals(null));

        // different type -> returns false
        assertFalse(ALL_MEAT.equals(5));

        // different diary -> returns false
        assertFalse(ALL_MEAT.equals(BOB_DIARY));

        // different name -> returns false
        Diary editedAllMeat = new DiaryBuilder(ALL_MEAT).withName(CommandTestUtil.VALID_NAME_BOB).build();
        assertFalse(ALL_MEAT.equals(editedAllMeat));
    }
}
