package org.ikainara.orangehrm_at;

import com.github.javafaker.Faker;
import lombok.Getter;

public class FakerFactory {
    private static final Faker faker = new Faker();

    public static Faker getFaker() {
        return faker;
    }
}
