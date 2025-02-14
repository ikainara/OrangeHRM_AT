package org.ikainara.orangehrm_at.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.ikainara.orangehrm_at.interfaces.SideNavigation;

@Getter
public class BasePage implements SideNavigation {
    private final Page page;

    public BasePage(Page page) {
        this.page = page;
    }
}
