package annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import pages.BasePage;
import extensions.NavigateExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@ExtendWith(NavigateExtension.class)
public @interface Navigate {
    Class <? extends BasePage> value();
}
