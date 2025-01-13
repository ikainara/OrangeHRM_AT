package org.ikainara.orangehrm_at.api;

import okhttp3.ResponseBody;
import org.ikainara.orangehrm_at.models.buzz.BuzzFeed;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface OrangeClient {
    @GET("login")
    Call<ResponseBody> getLoginToken();

    @FormUrlEncoded
    @POST("validate")
    Call<ResponseBody> login(@FieldMap Map<String, String> loginData);

    @GET("v2/buzz/feed")
    Call<BuzzFeed> getBuzzFeed(@QueryMap Map<String, String> queryMap);
}
