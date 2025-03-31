package org.ikainara.orangehrm_at;

import com.github.javafaker.Faker;

public class OhrmFaker {
    private Faker faker;

    public OhrmFaker(Faker faker) {
        this.faker = faker;
    }

    public String getDefaultPassword() {
        return "Passw0rd!";
    }
}
