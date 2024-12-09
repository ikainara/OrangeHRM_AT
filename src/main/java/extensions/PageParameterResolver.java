package extensions;

import com.microsoft.playwright.Page;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import pages.BasePage;
import parameterResolvers.PwPageParameterResolver;

public class PageParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var parameterType = parameterContext.getParameter().getType();
        return BasePage.class.isAssignableFrom(parameterType);
    }

    @Override
    @SneakyThrows
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var page = PwPageParameterResolver.getPage(extensionContext);
        var constructor = parameterContext.getParameter().getType().getConstructor(Page.class);
        return constructor.newInstance(page);
    }
}