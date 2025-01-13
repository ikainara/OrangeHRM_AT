package org.ikainara.orangehrm_at;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import org.aeonbits.owner.ConfigCache;

public class OrangeHrmConfig implements OptionsFactory {
    private final HrmConfig config = ConfigCache.getOrCreate(HrmConfig.class);
    @Override
    public Options getOptions() {
        Options options = new Options();
        options.setLaunchOptions(new BrowserType.LaunchOptions().setHeadless(config.headless()));
        options.setContextOptions(new Browser.NewContextOptions().setBaseURL(config.url()));
        options.setBrowserName(config.browser());
        return options;
    }
}
