package org.ikainara.orangehrm_at.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class DashboardPage extends BasePage {
private final Locator userMenuLocator;
    public DashboardPage(Page page) {
        super(page);
        userMenuLocator = page.locator(".oxd-topbar-header-userarea");
    }
}
