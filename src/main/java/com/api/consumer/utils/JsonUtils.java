package com.api.consumer.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JsonUtils {

    private static final String CONTENT = "content";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        //mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static byte[] toJson(Object object) throws IOException {

        return mapper.writeValueAsBytes(object);

    }

    public static <T> T toObject(String json, Class<T> classType) throws IOException {

        return mapper.readValue(json, classType);

    }

    public static <T> List<T> toListInContainer(String json, Class<T> classType) throws IOException, JSONException {

        if (json == null || json.isEmpty()) {
            return Collections.emptyList();
        }

        JSONObject jsonObject = new JSONObject(json);
        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, classType);

        return mapper.readValue(jsonObject.get(CONTENT).toString(), listType);

    }


    public static <T> List<T> toListOfObjects(String json, Class<T> classType) throws IOException {

        if (json == null || json.isEmpty()) {
            return Collections.emptyList();
        }

        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, classType);

        return mapper.readValue(json, listType);

    }

}

