import annotations.Navigate;
import annotations.OrangeTest;
import annotations.UseJPWConfig;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UseJPWConfig(OrangeHrmConfig.class)
public class LoginTest {
    @OrangeTest
    @Navigate(LoginPage.class)
    public void testLoginValidCredentials(LoginPage loginPage, HomePage homePage) {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin123");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).isVisible();
    }

    @OrangeTest
    @Navigate(LoginPage.class)
    public void testLoginInvalidCredentials(LoginPage loginPage, HomePage homePage) {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin1234");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).not().isVisible();
    }
}
