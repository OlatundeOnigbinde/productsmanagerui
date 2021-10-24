package com.lpg.pmappui.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lpg.pmappui.dto.RefDTO;
import com.lpg.pmappui.util.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class DashboardController {

    private final HttpHelper httpHelper;

    @Value("${app.backend.service.url: http://localhost:8082}")
    private String backendBaseUrl;

    public DashboardController(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @GetMapping(value = "/getproductscount", produces = MediaType.APPLICATION_JSON_VALUE)
    public RefDTO getProductsCount(HttpSession session) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product"));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product", headers);
        log.info(String.format("response is  %s", response));
        JsonNode responseObj = mapper.readTree(response);

        if (responseObj.has("code") && responseObj.get("code").intValue() == 0) {
            ArrayNode items = (ArrayNode) responseObj.get("productsList");
            return new RefDTO("Products", ""+items.size());

        }else if (responseObj.has("message")) {
            return new RefDTO("Products", "0");
        }
        return new RefDTO("Products", "0");
    }

    @GetMapping(value = "/getcategoriescount", produces = MediaType.APPLICATION_JSON_VALUE)
    public RefDTO getCategoriesCount(HttpSession session) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/categories"));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product/categories", headers);
        log.info(String.format("response is  %s", response));
        JsonNode responseObj = mapper.readTree(response);

        if (responseObj.has("code") && responseObj.get("code").intValue() == 0) {
            ArrayNode items = (ArrayNode) responseObj.get("categoryList");
            return new RefDTO("Categories", ""+items.size());

        }else if (responseObj.has("message")) {
            return new RefDTO("Categories", "0");
        }
        return new RefDTO("Categories", "0");
    }

}
