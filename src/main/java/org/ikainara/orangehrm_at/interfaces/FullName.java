package org.ikainara.orangehrm_at.interfaces;

public interface FullName {
    String getFirstName();
    String getMiddleName();
    String getLastName();

    default String getFullName() {
        return getFirstName() + (getMiddleName() == null ? "" : getMiddleName()) + getLastName();
    }
}
