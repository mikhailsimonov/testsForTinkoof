package ru.tinkoff.qa.utils;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class HttpClient {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final Logger LOGGER = Logger.getLogger(HttpClient.class.getName());
    public static int responseCode;
    public static StringBuffer responseBody = new StringBuffer();

    // HTTP GET request
    public static void sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();
        LOGGER.info("\nSending 'GET' request to URL : " + url);
        LOGGER.info("ResponseHeaders Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        responseBody = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        //print result
        LOGGER.info(responseBody.toString());

    }

    // HTTP POST request
    public static void sendPost(String url, String parameters) throws Exception {

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");


        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(parameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        LOGGER.info("\nSending 'POST' request to URL : " + url);
        LOGGER.info("Post parameters : " + parameters);
        LOGGER.info("ResponseHeaders Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        responseBody = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        //print result
        LOGGER.info(responseBody.toString());

    }

    public static void sendDelete(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is DELETE
        con.setRequestMethod("DELETE");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();
        LOGGER.info("\nSending 'DELETE' request to URL : " + url);
        LOGGER.info("ResponseHeaders Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        responseBody = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        //print result
        LOGGER.info(responseBody.toString());

    }

    public static void sendPut(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is PUT
        con.setRequestMethod("PUT");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        responseCode = con.getResponseCode();
        LOGGER.info("\nSending 'PUT' request to URL : " + url);
        LOGGER.info("ResponseHeaders Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        responseBody = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        //print result
        LOGGER.info(responseBody.toString());

    }

}

