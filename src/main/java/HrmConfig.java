import org.aeonbits.owner.Config;

public interface HrmConfig extends Config {
    String browser();
    String url();
    @DefaultValue("false")
    boolean headless();
}
