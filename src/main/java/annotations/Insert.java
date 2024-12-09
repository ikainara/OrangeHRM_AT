package annotations;

import extensions.InsertExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BasePage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(InsertExtension.class)
public @interface Insert {
}
