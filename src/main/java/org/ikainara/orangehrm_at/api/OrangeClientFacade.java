package org.ikainara.orangehrm_at.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.ikainara.orangehrm_at.models.buzz.BuzzFeed;
import org.ikainara.orangehrm_at.users.User;
import org.jsoup.Jsoup;
import retrofit2.Response;

import java.util.Map;

public class OrangeClientFacade {
    OrangeClient authClient;
    @SneakyThrows
    private String getToken() {
        authClient = OrangeClientFactory.createAuthClient();
        var response = authClient.getLoginToken().execute();
        assert response.isSuccessful();
        var doc = Jsoup.parse(response.body().string());
        var token = doc.select("#app auth-login").attr(":token");
        return token.substring(1, token.length()-1);
    }

    @SneakyThrows
    private OrangeClient authenticate(User user) {
        var request = new ObjectMapper().convertValue(user, Map.class);
        request.put("_token", getToken());
        var response = authClient.login(request).execute();
        assert response.isSuccessful() : response.errorBody().string();
        return OrangeClientFactory.createApiClient();
    }

    @SneakyThrows
    public Response<BuzzFeed> getBuzzFeed(User user) {
        var client = authenticate(user);
        return client.getBuzzFeed(defaultQueryMap()).execute();
    }

    private Map<String, String> defaultQueryMap() {
        return Map.of("limit","10",
                "offset","0",
                "sortOrder","DESC",
                "sortField","share.createdAtUtc");
    }


}
