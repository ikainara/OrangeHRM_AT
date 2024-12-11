package org.ikainara.orangehrm_at.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class HomePage extends BasePage {
private final Locator userMenuLocator;
    public HomePage(Page page) {
        super(page);
        userMenuLocator = page.locator(".oxd-topbar-header-userarea");
    }
}
