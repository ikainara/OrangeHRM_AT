package org.ikainara.orangehrm_at.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("Admin", 1),
    ESS("ESS", 2);
    private final String displayName;
    private final int roleId;

    public static UserRole getById(int roleId) {
        return Arrays.stream(values()).filter(r->r.roleId == roleId).findFirst().orElseThrow();
    }
}
