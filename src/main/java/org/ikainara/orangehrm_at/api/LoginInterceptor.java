package org.ikainara.orangehrm_at.api;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;

import java.io.IOException;

public class LoginInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if(chain.request().url().toString().endsWith("validate")) {
            var response = chain.proceed(chain.request());
            assert response.isSuccessful();
            var responseHtml = Jsoup.parse(response.peekBody(Long.MAX_VALUE).string());
            var error = responseHtml.select("#app auth-login").attr(":error");
            if(!error.isEmpty()) {
                return response.newBuilder().code(400).body(ResponseBody.create(response.body().contentType(),error))
                        .build();
            }
            return response;
        }
        return chain.proceed(chain.request());
    }
}
