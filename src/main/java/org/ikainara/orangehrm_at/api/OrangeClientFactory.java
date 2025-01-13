package org.ikainara.orangehrm_at.api;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.aeonbits.owner.ConfigCache;
import org.ikainara.orangehrm_at.HrmConfig;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Slf4j
public class OrangeClientFactory {
    private final static HrmConfig config = ConfigCache.getOrCreate(org.ikainara.orangehrm_at.HrmConfig.class);
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(log::info);
    private static final OrangeCookieJar cookieJar = new OrangeCookieJar();

    static {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static OrangeClient createAuthClient() {
        var loginInterceptor = new LoginInterceptor();
        var okHttpClientBuilder = baseClientBuilder().addInterceptor(loginInterceptor).cookieJar(cookieJar);
        var authClient = new Retrofit.Builder()
                .baseUrl(config.authUrl())
                .client(okHttpClientBuilder.build())
                .build();
        return authClient.create(OrangeClient.class);
    }

    public static OrangeClient createApiClient() {
        var okHttpClientBuilder = baseClientBuilder().cookieJar(cookieJar);
        var apiClient = new Retrofit.Builder()
                .baseUrl(config.apiUrl())
                .client(okHttpClientBuilder.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return apiClient.create(OrangeClient.class);
    }

    private static OkHttpClient.Builder baseClientBuilder() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
    }
}
