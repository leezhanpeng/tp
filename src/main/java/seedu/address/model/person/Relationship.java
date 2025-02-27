package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Arrays;

/**
 * Represents a Person's relationship in the contact list.
 * Guarantees: immutable; is valid as declared in {@link #isValidRelationship(String)}
 */
public class Relationship {

    public static final String MESSAGE_CONSTRAINTS =
            "Relationship should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the Relationship must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String relationship;

    /**
     * Constructs a {@code Relationship}.
     *
     * @param relationship A valid relationship.
     */
    public Relationship(String relationship) {
        requireNonNull(relationship);
        checkArgument(isValidRelationship(relationship), MESSAGE_CONSTRAINTS);
        this.relationship = relationship;
    }

    /**
     * Returns true if a given string is a valid relationship.
     */
    public static boolean isValidRelationship(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given array of strings contains all valid relationships.
     */
    public static boolean isValidRelationship(String[] test) {
        return Arrays.stream(test).allMatch(s -> s.matches(VALIDATION_REGEX));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Relationship)) {
            return false;
        }

        Relationship otherRelationship = (Relationship) other;
        return relationship.equals(otherRelationship.relationship);
    }

    @Override
    public int hashCode() {
        return relationship.hashCode();
    }

    @Override
    public String toString() {
        return relationship;
    }
}
