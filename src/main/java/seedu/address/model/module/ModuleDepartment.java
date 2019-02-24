package seedu.address.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ModuleDepartment {
    public static final String MESSAGE_CONSTRAINTS =
            "Must consist of at least 1 word and cannot begin with whitespace";
    public static final String VALIDATION_REGEX  = "[^\\s].*";
    public final String department;

    public ModuleDepartment(String moduleDepartment) {
        requireNonNull(moduleDepartment);
        checkArgument(isValidModuleDepartment(moduleDepartment), MESSAGE_CONSTRAINTS);
        department = moduleDepartment;
    }

    public boolean isValidModuleDepartment(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String toString() {
        return department;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ModuleDepartment// instanceof handles nulls
                && department.equals(((ModuleDepartment) other).department)); // state check
    }

    @Override
    public int hashCode() {
        return department.hashCode();
    }
}
