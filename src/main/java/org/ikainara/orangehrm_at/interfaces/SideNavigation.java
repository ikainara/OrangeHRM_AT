package org.ikainara.orangehrm_at.interfaces;

import com.microsoft.playwright.Page;
import org.ikainara.orangehrm_at.enums.SideNavigationItem;

public interface SideNavigation {
    Page page();

    default void navigateToBuzz() {
        navigateTo(SideNavigationItem.BUZZ);
    }

    default void navigateToPIM() {
        navigateTo(SideNavigationItem.PIM);
    }

    private void navigateTo(SideNavigationItem item) {
        page().locator(".oxd-sidepanel").locator(".oxd-main-menu").
                locator(String.format("li:has-text('%s')", item.getDisplayName())).click();
    }
}
