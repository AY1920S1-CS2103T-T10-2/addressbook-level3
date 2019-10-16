package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.diary.Page;
import seedu.address.model.diary.Title;

/**
 * Jackson-friendly version of {@link Page}.
 */
class JsonAdaptedPage {

    private final String pageTitle;

    /**
     * Constructs a {@code JsonAdaptedPage} with the given {@code pageTitle}.
     */
    @JsonCreator
    public JsonAdaptedPage(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * Converts a given {@code Page} into this class for Jackson use.
     */
    public JsonAdaptedPage(Page source) {
        pageTitle = source.getTitle().toString();
    }

    @JsonValue
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * Converts this Jackson-friendly adapted Page object into the model's {@code Page} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted Page.
     */
    public Page toModelType() throws IllegalValueException {
        if (!Title.isValidTitle(pageTitle)) {
            throw new IllegalValueException(Title.MESSAGE_CONSTRAINTS);
        }
        return new Page(new Title(pageTitle));
    }

}
