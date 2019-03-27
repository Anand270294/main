package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.ModuleTaken;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableLimit {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate moduleTaken(s).";

    private final List<JsonAdaptedModuleTaken> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableLimit} with the given persons.
     */
    @JsonCreator
    public JsonSerializableLimit(@JsonProperty("persons") List<JsonAdaptedModuleTaken> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableLimit}.
     */
    public JsonSerializableLimit(ReadOnlyAddressBook source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedModuleTaken::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public AddressBook toModelType() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();
        for (JsonAdaptedModuleTaken jsonAdaptedModuleTaken : persons) {
            ModuleTaken moduleTaken = jsonAdaptedModuleTaken.toModelType();
            if (addressBook.hasPerson(moduleTaken)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            addressBook.addPerson(moduleTaken);
        }
        return addressBook;
    }

}
