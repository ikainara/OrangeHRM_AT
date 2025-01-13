package org.ikainara.orangehrm_at.api;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

public class OrangeCookieJar implements CookieJar {
    private List<Cookie> cookies = new ArrayList<>();

    @Override
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> newCookies) {
        for (var cookie : newCookies) {
            cookies.removeIf(existingCookie -> existingCookie.name().equals(cookie.name()));
            cookies.add(cookie);
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return cookies;
    }
}
