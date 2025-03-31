package org.ikainara.orangehrm_at.extensions.com.github.javafaker.Faker;

import com.github.javafaker.Faker;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.ikainara.orangehrm_at.OhrmFaker;

@Extension
public class FakerExtensions {
    public static OhrmFaker ohrmFaker(@This Faker faker) {
        return new OhrmFaker(faker);
    }
}
