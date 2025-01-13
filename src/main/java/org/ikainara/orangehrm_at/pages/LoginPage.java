package org.ikainara.orangehrm_at.pages;

import org.ikainara.orangehrm_at.annotations.Url;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.ikainara.orangehrm_at.users.User;

@Getter
@Url("/")
public class LoginPage extends BasePage {
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        super(page);
        usernameInput = page.locator("[name=username]");
        passwordInput = page.locator("[name=password]");
        loginButton = page.locator("button[type=submit]");
    }

    public void fillPageFields(User user) {
        usernameInput.fill(user.getUsername());
        passwordInput.fill(user.getPassword());
    }
}
