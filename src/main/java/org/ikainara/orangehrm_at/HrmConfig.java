package org.ikainara.orangehrm_at;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:HrmConfig.properties"})
public interface HrmConfig extends Config {
    String browser();
    String url();
    String apiUrl();
    String authUrl();
    @DefaultValue("false")
    boolean headless();
}
