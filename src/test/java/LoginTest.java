import org.ikainara.orangehrm_at.annotations.Navigate;
import org.ikainara.orangehrm_at.annotations.OrangeTest;
import org.ikainara.jpw.annotations.Insert;
import org.ikainara.jpw.annotations.UseJPWConfig;
import org.ikainara.orangehrm_at.pages.HomePage;
import org.ikainara.orangehrm_at.pages.LoginPage;
import org.junit.jupiter.api.Tag;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UseJPWConfig(OrangeHrmConfig.class)
public class LoginTest {
    @Insert
    LoginPage loginPage;
    @Insert
    HomePage homePage;
    @OrangeTest
    @Navigate(LoginPage.class)
    @Tag("HRM-001")
    public void testLoginValidCredentials() {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin123");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).isVisible();
    }

    @OrangeTest("HRM-002")
    @Tag("HRM-003")
    @Navigate(LoginPage.class)
    public void testLoginInvalidCredentials() {
        loginPage.usernameInput().fill("Admin");
        loginPage.passwordInput().fill("admin1234");
        loginPage.loginButton().click();
        assertThat(homePage.userMenuLocator()).not().isVisible();
    }
}
