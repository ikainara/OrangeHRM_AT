package org.ikainara.orangehrm_at.api.customResponseConverter;

import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Converter;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CustomResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final ObjectReader adapter;

    CustomResponseBodyConverter(ObjectReader adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            var responseBodyString = normalizeResponse(value.string());
            return adapter.readValue(new ByteArrayInputStream(responseBodyString.getBytes()));
        } finally {
            value.close();
        }
    }

    private String normalizeResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);

        updateJson(jsonResponse, "data");
        updateJson(jsonResponse, "meta");

        return jsonResponse.toString();
    }

    private void updateJson(JSONObject jsonResponse, String jsonEntryName) {
        Object data = jsonResponse.get(jsonEntryName);
        if (data instanceof JSONObject) { // If it's a JSONObject, wrap it in a JSONArray
            JSONArray dataArray = new JSONArray();
            dataArray.put(data);
            jsonResponse.put(jsonEntryName, dataArray);
        }
    }
}


