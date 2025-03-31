package org.ikainara.orangehrm_at.api.customResponseConverter;

import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;

public class CustomRequestBodyConverter <T> implements Converter<T, RequestBody> {
    private final ObjectWriter adapter;
    private final MediaType mediaType;

    CustomRequestBodyConverter(ObjectWriter adapter, MediaType mediaType) {
        this.adapter = adapter;
        this.mediaType = mediaType;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        byte[] bytes = adapter.writeValueAsBytes(value);
        return RequestBody.create(mediaType, bytes);
    }
}
