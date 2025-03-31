package org.ikainara.orangehrm_at.api;

import okhttp3.ResponseBody;
import org.ikainara.orangehrm_at.models.ApiResponse;
import org.ikainara.orangehrm_at.models.buzz.ApiBuzz;
import org.ikainara.orangehrm_at.models.employee.ApiEmployee;
import org.ikainara.orangehrm_at.models.user.ApiUser;
import org.ikainara.orangehrm_at.models.user.PostUser;
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
    Call<ApiResponse<ApiBuzz>> getBuzzFeed(@QueryMap Map<String, String> queryMap);

    @GET("v2/admin/users")
    Call<ApiResponse<ApiUser>> getUsers(@QueryMap Map<String, String> queryMap);

    @POST("v2/admin/users")
    Call<ApiResponse<ApiUser>> createUser(@Body PostUser apiUser);

    @POST("v2/pim/employees")
    Call<ApiResponse<ApiEmployee>> createEmployee(@Body ApiEmployee employee);
}
