package ru.tinkoff.qa.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * util for get property
 */
public class Props {

    private String url;
    private String headers;
    private String anything;
    private String redirects;
    static Properties property = new Properties();

    public static void initializeProps() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/tests.properties");
            property.load(fis);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

    public String getUrl() {

        url = property.getProperty("httpbin.basicUrl");
        return url;
    }

    public String getHeaders() {

        headers = property.getProperty("httpbin.headers");
        return headers;
    }

    public String getAnything() {

        anything = property.getProperty("httpbin.anything");
        return anything;
    }

    public String getRedirects() {

        redirects = property.getProperty("httpbin.redirects");
        return redirects;
    }

}
