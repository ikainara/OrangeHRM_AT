package org.ikainara.orangehrm_at.annotations;

import org.ikainara.orangehrm_at.extensions.AddAllureTagExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ikainara.orangehrm_at.extensions.PageParameterResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtendWith({PageParameterResolver.class, AddAllureTagExtension.class})
@Tag("Orange")
@Test
public @interface OrangeTest {
    String value() default "";
}
