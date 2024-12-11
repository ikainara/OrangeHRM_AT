package org.ikainara.orangehrm_at.extensions;

import org.ikainara.orangehrm_at.annotations.Navigate;
import org.ikainara.orangehrm_at.annotations.Url;
import org.ikainara.jpw.parameterResolvers.PwPageParameterResolver;
import org.ikainara.jpw.utils.AnnotationUtils;
import org.junit.jupiter.api.extension.*;

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
