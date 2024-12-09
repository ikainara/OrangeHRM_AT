import annotations.Insert;
import annotations.Navigate;
import annotations.OrangeTest;
import annotations.UseJPWConfig;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UseJPWConfig(OrangeHrmConfig.class)
public class LoginTest {
    @Insert
    LoginPage loginPage;
    @Insert
    HomePage homePage;
    @OrangeTest
    @Navigate(LoginPage.class)
    public void testLoginValidCredentials() {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin123");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).isVisible();
    }

    @OrangeTest
    @Navigate(LoginPage.class)
    public void testLoginInvalidCredentials() {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin1234");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).not().isVisible();
    }
}
