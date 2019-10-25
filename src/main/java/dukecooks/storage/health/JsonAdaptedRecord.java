package dukecooks.storage.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dukecooks.commons.exceptions.IllegalValueException;
import dukecooks.model.health.components.Record;
import dukecooks.model.health.components.Timestamp;
import dukecooks.model.health.components.Type;
import dukecooks.model.health.components.Value;

/**
 * Jackson-friendly version of {@link Record}.
 */
class JsonAdaptedRecord {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Record's %s field is missing!";

    private final String type;
    private final String value;
    private final String timestamp;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedRecord(@JsonProperty("type") String type,
                             @JsonProperty("value") String value,
                             @JsonProperty("timestamp") String timestamp) {
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    /**
     * Converts a given {@code Record} into this class for Jackson use.
     */
    public JsonAdaptedRecord(Record source) {
        type = source.getType().type;
        value = String.valueOf(source.getValue().value);
        timestamp = source.getTimestamp().timestamp;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Record} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Record toModelType() throws IllegalValueException {

        if (type == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Type.class.getSimpleName()));
        }
        if (!Type.isValidType(type)) {
            throw new IllegalValueException(Type.MESSAGE_CONSTRAINTS);
        }
        final Type modelType = new Type(type);

        if (value == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Value.class.getSimpleName()));
        }
        if (!Value.isValidNumber(value)) {
            throw new IllegalValueException(Value.MESSAGE_CONSTRAINTS);
        }
        final Value modelValue = new Value(value);

        if (timestamp == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Timestamp.class.getSimpleName()));
        }
        if (!Timestamp.isValidDateTime(timestamp)) {
            throw new IllegalValueException(Timestamp.MESSAGE_CONSTRAINTS);
        }
        final Timestamp modelTimestamp = new Timestamp(timestamp);

        return new Record(modelType, modelValue, modelTimestamp);
    }

}
