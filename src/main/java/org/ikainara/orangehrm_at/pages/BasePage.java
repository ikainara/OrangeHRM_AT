package org.ikainara.orangehrm_at.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class BasePage {
    private final Page page;

    public BasePage(Page page) {
        this.page = page;
    }
}
