package com.lpg.pmappui.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpg.pmappui.config.WebUtils;
import com.lpg.pmappui.dto.UserDTO;
import com.lpg.pmappui.dto.ProductDTO;
import com.lpg.pmappui.util.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@RestController
@Scope("session")
@Slf4j
public class AppController {

    private final WebUtils webUtils;
    private final HttpHelper httpHelper;

    @Value("${app.backend.service.url: http://localhost:8082}")
    private String backendBaseUrl;

    public AppController(WebUtils webUtils, HttpHelper httpHelper) {
        this.webUtils = webUtils;
        this.httpHelper = httpHelper;
    }

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String authenticateUser(@RequestBody UserDTO obj, HttpSession session) throws IOException {
        session.removeAttribute("userInSession");

        String message = mapper.writeValueAsString(obj);
//        log.info(String.format("sending request %s to %s", message, backendBaseUrl+"/user/login"));
        String response = httpHelper.send(message, backendBaseUrl+"/user/login");
//        log.info(String.format("response is  %s", response));
        JsonNode responseObj = mapper.readTree(response);

        if (responseObj.has("code") && responseObj.get("code").intValue() == 0) {
            session.setAttribute("sessionToken", responseObj.get("sessionToken").asText());
            session.setAttribute("fullname", responseObj.get("firstname").asText() + " " + responseObj.get("lastname").asText());
            return "success";
        }else if (responseObj.has("message")) {
            return responseObj.get("message").asText();
        }
        return "Authentication failed, Invalid credentials";
    }

    @GetMapping(value = "/getcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCategories(HttpSession session) throws IOException {

        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/categories"));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product/categories", headers);
        log.info(String.format("response from get categories is  %s", response));

        return response;
    }

    @GetMapping(value = "/getallproducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllProducts(HttpSession session) throws IOException {
        if(session==null || session.getAttribute("sessionToken") == null){
            return null;
        }

        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product"));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product", headers);
        log.info(String.format("response from getallproducts is  %s", response));
//        mapper.readTree(response);
        return response;
    }

    @GetMapping(value = "/getproducts/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProductsByCategory(HttpSession session, @PathVariable("categoryId") Long categoryId) throws IOException {
        if(session==null || session.getAttribute("sessionToken") == null){
            return null;
        }
        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/getproducts/"+categoryId));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product/getproducts/"+categoryId, headers);
        log.info(String.format("response from getproductsbycategories is  %s", response));
        
        return response;
    }

//    @GetMapping(value = "/editproduct/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String prepareUserForEdit(HttpSession session, @PathVariable("id") String id, Model model) throws IOException {
//        if(session==null || session.getAttribute("sessionToken") == null){
//            return "login";
//        }
//        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/"+id));
//        Map<String ,String> headers = new HashMap<>();
//        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
//        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product/"+id, headers);
//        log.info(String.format("response from get product by id is  %s", response));
//        JsonNode responseObj = mapper.readTree(response);
//        model.addAttribute("message",responseObj.get("message"));
//
//        log.info(MessageFormat.format("selected product with id {0} : {1}", id, responseObj));
//        model.addAttribute("selectedProduct", responseObj);
//
//        return "manageproduct";
//    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id, HttpSession session, Model model) throws IOException {
        if(session==null || session.getAttribute("sessionToken") == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/delete/"+id));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendDeleteRequest(backendBaseUrl+"/product/delete/"+id, headers);
        log.info(String.format("response from delete product is  %s", response));
        JsonNode responseObj = mapper.readTree(response);
        model.addAttribute("message",responseObj.get("message"));
        return "success";
    }

    @PostMapping(value = "/saveproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveProduct(@RequestBody ProductDTO obj, HttpSession session) throws IOException {
        if(session==null || session.getAttribute("sessionToken") == null){
            return null;
        }
        String message = mapper.writeValueAsString(obj);
        String url = obj.getProductId() == null? backendBaseUrl+"/product":backendBaseUrl+"/product/edit/"+obj.getProductId();
        log.info(String.format("sending request %s to %s", obj,  url));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.send(message, url, headers);
        log.info(String.format("response is  %s", response));
//        JsonNode responseObj = mapper.readTree(response);

        return response;
    }
}
