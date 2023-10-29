package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Specialisation {
    
    public static final String MESSAGE_CONSTRAINTS =
            "Specialisations should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String specialisationName;

    /**
     * Constructs a {@code Specialisation}.
     *
     * @param specialisationName A valid specialisation name.
     */
    public Specialisation(String specialisationName) {
        requireNonNull(specialisationName);
        checkArgument(isValidSpecialisationName(specialisationName), MESSAGE_CONSTRAINTS);
        this.specialisationName = specialisationName;
    }

    /**
     * Returns true if a given string is a valid specialisation name.
     */
    public static boolean isValidSpecialisationName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return specialisationName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Specialisation)) {
            return false;
        }

        Specialisation otherSpecialisation = (Specialisation) other;
        return specialisationName.equals(otherSpecialisation.specialisationName);
    }

    @Override
    public int hashCode() {
        return specialisationName.hashCode();
    }
}
