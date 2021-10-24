package com.lpg.pmappui.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpg.pmappui.util.HttpHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class RoutesController {

    @Value("${app.backend.service.url: http://localhost:8082}")
    private String backendBaseUrl;


    @Autowired
    private HttpHelper httpHelper;

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        log.info("navigating to welcome page>>>>>>");
        if(session==null || session.getAttribute("sessionToken") == null){
            log.info("Session is invalid>>>>>>");
            return "login";
        }
        log.info("Session is valid>>>>>>");
        initialiseModelFromSessionAttributes(model, session);
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/products")
    public String products(HttpSession session, Model model) {
        log.info("navigating to products page>>>>>>");
        if(isSessionInactive(session)){
            log.info("Session is invalid>>>>>>");
            return "login";
        }
        log.info("Session is valid>>>>>>");
        initialiseModelFromSessionAttributes(model, session);

        model.addAttribute("selectedCategoryId", "");
        return "products";
    }

    @GetMapping("/addproduct")
    public String addproduct(HttpSession session, Model model) {
        if(isSessionInactive(session)){
            log.info("Session is invalid>>>>>>");
            return "login";
        }
        model.addAttribute("selectedCategoryId", "");
        return "manageproduct";
    }

    @GetMapping("/editproduct")
    public String prepareUserForEdit(HttpSession session, @RequestParam(name="ref") String ref, Model model) throws IOException {
        if(isSessionInactive(session)){
            log.info("Session is invalid>>>>>>");
            return "login";
        }
        log.info(String.format("sending get request to %s",  backendBaseUrl+"/product/"+ref));
        Map<String ,String> headers = new HashMap<>();
        headers.put("sessionToken", session.getAttribute("sessionToken").toString());
        String response = httpHelper.sendGetRequest(backendBaseUrl+"/product/"+ref, headers);
        log.info(String.format("response from get product by id is  %s", response));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseObj = mapper.readTree(response);
        model.addAttribute("message",responseObj.get("message"));

        log.info(MessageFormat.format("selected product with id {0} : {1}", ref, responseObj.get("product")));
        model.addAttribute("selectedProduct", responseObj.get("product"));
        model.addAttribute("productId", responseObj.get("product").get("id"));
        model.addAttribute("productName", responseObj.get("product").get("name").textValue());
        model.addAttribute("productDesc", responseObj.get("product").get("description").textValue());
        model.addAttribute("selectedCategoryId", responseObj.get("product").get("category").get("id"));
        model.addAttribute("lastPurchasedDate", responseObj.get("product").get("lastPurchasedDate").textValue());

        return "manageproduct";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionToken");
        session.invalidate();
        return "login";
    }

    private boolean isSessionInactive(HttpSession session){
        if(session==null || session.getAttribute("sessionToken") == null){
            return true;
        }
        return false;
    }

    private void initialiseModelFromSessionAttributes(Model model, HttpSession session){
        model.addAttribute("sessionToken", session.getAttribute("sessionToken"));
        model.addAttribute("fullname", session.getAttribute("fullname"));
    }

}
