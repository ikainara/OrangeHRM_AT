package org.ikainara.orangehrm_at.extensions;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import org.ikainara.orangehrm_at.annotations.OrangeTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AddAllureTagExtension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        var testMethod = context.getRequiredTestMethod();
        var value = testMethod.getAnnotation(OrangeTest.class);
        if(value != null) {
            if(!value.value().isEmpty() && !testMethod.isAnnotationPresent(Tag.class)) {
                Allure.getLifecycle().updateTestCase(testResult -> {
                    testResult.getLabels().add(new Label().setName("tag").setValue(value.value()));
                });
            }
        }
    }
}
