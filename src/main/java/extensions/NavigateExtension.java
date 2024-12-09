package extensions;

import annotations.Navigate;
import annotations.Url;
import org.junit.jupiter.api.extension.*;
import parameterResolvers.PwPageParameterResolver;
import utils.AnnotationUtils;

public class NavigateExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        var annotatedElement = AnnotationUtils.getAnnotatedElement(context, Navigate.class);
        if (annotatedElement != null) {
            var pageClass = annotatedElement.getAnnotation(Navigate.class).value();
            String url;

            try {
                url = pageClass.getAnnotation(Url.class).value();
            } catch (Exception e) {
                throw new ExtensionContextException("Class '" + pageClass.getName() + "' is not annotated with @Url annotation to navigate to");
            }

            PwPageParameterResolver.getPage(context).navigate(url);
        }
    }
}
