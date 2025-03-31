package org.ikainara.orangehrm_at.api;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.aeonbits.owner.ConfigCache;
import org.ikainara.orangehrm_at.HrmConfig;
import org.ikainara.orangehrm_at.api.customResponseConverter.CustomConverterFactory;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

@Slf4j
public class OrangeClientFactory {
    private final HrmConfig config = ConfigCache.getOrCreate(org.ikainara.orangehrm_at.HrmConfig.class);
    private static final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(log::info);
    private OkHttpClient.Builder okHttpClientBuilder;

    static {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public OrangeClient createAuthClient() {
        var loginInterceptor = new LoginInterceptor();
        var cookieJar = new OrangeCookieJar();
        okHttpClientBuilder = baseClientBuilder();
        okHttpClientBuilder.addInterceptor(loginInterceptor).cookieJar(cookieJar);
        var authClient = new Retrofit.Builder()
                .baseUrl(config.authUrl())
                .client(okHttpClientBuilder.build())
                .build();
        return authClient.create(OrangeClient.class);
    }

    public OrangeClient createApiClient() {
        var apiClient = new Retrofit.Builder()
                .baseUrl(config.apiUrl())
                .client(okHttpClientBuilder.build())
                .addConverterFactory(CustomConverterFactory.create())
                .build();
        return apiClient.create(OrangeClient.class);
    }

    private OkHttpClient.Builder baseClientBuilder() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);
    }
}
