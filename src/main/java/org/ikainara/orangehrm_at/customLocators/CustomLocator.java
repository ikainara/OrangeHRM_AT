package org.ikainara.orangehrm_at.customLocators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public abstract class CustomLocator {
    private final Page page;
    private final Locator containerLocator;

    public CustomLocator(Locator containerLocator) {
        this.page = containerLocator.page();
        this.containerLocator = containerLocator;
    }
}
