package ru.tinkoff.qa.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.tinkoff.qa.model.ResponseHeaders;

public class JsonConstructor {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static ResponseHeaders headersOfResponse(StringBuffer responseHeaders){
        return GSON.fromJson(String.valueOf(responseHeaders), ResponseHeaders.class);
    }
}
