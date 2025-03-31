package org.ikainara.orangehrm_at.api.customResponseConverter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class CustomConverterFactory extends Converter.Factory {
    private static final MediaType DEFAULT_MEDIA_TYPE =
            MediaType.get("application/json; charset=UTF-8");

    private final ObjectMapper mapper;
    private final MediaType mediaType;

    public CustomConverterFactory(ObjectMapper mapper, MediaType mediaType) {
        this.mapper = mapper;
        this.mediaType = mediaType;
    }

    public static CustomConverterFactory create () {
        return new CustomConverterFactory(new ObjectMapper(), DEFAULT_MEDIA_TYPE);
    }

    public static CustomConverterFactory create (ObjectMapper mapper) {
        if (mapper == null) throw new NullPointerException("mapper == null");
        return new CustomConverterFactory(mapper, DEFAULT_MEDIA_TYPE);
    }

    public static CustomConverterFactory create (ObjectMapper mapper, MediaType mediaType) {
        if (mapper == null) throw new NullPointerException("mapper == null");
        if (mediaType == null) throw new NullPointerException("mediaType == null");
        return new CustomConverterFactory(mapper, mediaType);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type, Annotation[] annotations, Retrofit retrofit) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectReader reader = mapper.readerFor(javaType);
        return new CustomResponseBodyConverter<>(reader);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(
            Type type,
            Annotation[] parameterAnnotations,
            Annotation[] methodAnnotations,
            Retrofit retrofit) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectWriter writer = mapper.writerFor(javaType);
        return new CustomRequestBodyConverter<>(writer, mediaType);
    }
}
