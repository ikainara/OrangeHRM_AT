package org.ikainara.orangehrm_at.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.ikainara.orangehrm_at.interfaces.LoginUser;
import org.ikainara.orangehrm_at.models.ApiResponse;
import org.ikainara.orangehrm_at.models.buzz.ApiBuzz;
import org.ikainara.orangehrm_at.models.employee.ApiEmployee;
import org.ikainara.orangehrm_at.models.user.ApiUser;
import org.ikainara.orangehrm_at.models.user.PostUser;
import org.jsoup.Jsoup;
import retrofit2.Response;

import java.util.Map;

public class OrangeClientFacade {
    OrangeClient authClient;
    OrangeClient apiClient;
    OrangeClientFactory clientFactory = new OrangeClientFactory();

    private String authenticatedUsername = "";

    @SneakyThrows
    public Response<ApiResponse<ApiBuzz>> getBuzzFeed(LoginUser user) {
        var client = authenticate(user);
        return client.getBuzzFeed(defaultQueryMap()).execute();
    }

    @SneakyThrows
    public Response<ApiResponse<ApiUser>> getUsers(LoginUser user) {
        var client = authenticate(user);
        return client.getUsers(defaultQueryMap()).execute();
    }

    @SneakyThrows
    public Response<ApiResponse<ApiEmployee>> createEmployee(LoginUser createBy, ApiEmployee employee) {
        var client = authenticate(createBy);
        return client.createEmployee(employee).execute();
    }

    @SneakyThrows
    public Response<ApiResponse<ApiUser>> createUser(LoginUser createBy, PostUser userToCreate) {
        var client = authenticate(createBy);
        return client.createUser(userToCreate).execute();
    }

    @SneakyThrows
    private String getToken() {
        authClient = clientFactory.createAuthClient();
        var response = authClient.getLoginToken().execute();
        assert response.isSuccessful();
        var doc = Jsoup.parse(response.body().string());
        var token = doc.select("#app auth-login").attr(":token");
        return token.substring(1, token.length()-1);
    }

    @SneakyThrows
    private OrangeClient authenticate(LoginUser user) {
        if(!authenticatedUsername.equals(user.getUsername())) {
            var request = new ObjectMapper().convertValue(user, Map.class);
            request.put("_token", getToken());
            var response = authClient.login(request).execute();
            assert response.isSuccessful() : response.errorBody().string();
            apiClient = clientFactory.createApiClient();
            authenticatedUsername = user.getUsername();
        }
        return apiClient;
    }

    private Map<String, String> defaultQueryMap() {
        return Map.of("limit","10",
                "offset","0"
                /*"sortOrder","DESC",
                "sortField","share.createdAtUtc"*/);
    }
}
