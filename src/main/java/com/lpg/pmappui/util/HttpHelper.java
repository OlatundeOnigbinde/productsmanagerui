package com.lpg.pmappui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@Service
public class HttpHelper {
    private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    public String sendDeleteRequest(String urlString, Map<String, String> header) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        header.forEach((k, v) -> {
            con.setRequestProperty(k, v);
        });
        con.setDoOutput(true);
        con.setUseCaches(false);

        return run(con, null);
    }

    public String sendGetRequest(String urlString, Map<String, String> header) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        header.forEach((k, v) -> {
            con.setRequestProperty(k, v);
        });
        con.setDoOutput(true);
        con.setUseCaches(false);

        return run(con, null);
    }

    public String send(String message, String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-type", "application/json");
        con.setDoOutput(true);
        con.setUseCaches(false);

        return run(con, message);
    }

    public String send(String message, String urlString, Map<String, String> header) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        header.forEach((k, v) -> {
            con.setRequestProperty(k, v);
        });

        con.setRequestProperty("Content-type", "application/json");

        con.setDoOutput(true);
        con.setUseCaches(false);

        return run(con, message);
    }

    private String run(HttpURLConnection con, String message) throws IOException {
        OutputStreamWriter writer = null;
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            if (message != null) {
                writer = new OutputStreamWriter(con.getOutputStream());
                writer.write(message);
                writer.flush();
            }
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
        return HtmlUtils.htmlUnescape(sb.toString());
    }

}
