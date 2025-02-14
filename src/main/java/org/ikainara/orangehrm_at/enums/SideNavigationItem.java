package org.ikainara.orangehrm_at.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SideNavigationItem {
    ADMIN("Admin"),
    BUZZ("Buzz"),
    CLAIM("Claim"),
    LEAVE("Leave"),
    PIM("PIM");

    private final String displayName;
}
