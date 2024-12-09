package extensions;

import annotations.Insert;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import pages.BasePage;
import parameterResolvers.PwPageParameterResolver;

public class InsertExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        var requiredTestClass = context.getRequiredTestInstance();
        var fields = context.getRequiredTestClass().getDeclaredFields();
        for (var field : fields) {
            if(field.isAnnotationPresent(Insert.class)) {
                if(BasePage.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    var page = PwPageParameterResolver.getPage(context);
                    var fieldValue = field.getType().getConstructor(Page.class).newInstance(page);
                    field.set(requiredTestClass, fieldValue);
                }
            }
        }
    }
}
