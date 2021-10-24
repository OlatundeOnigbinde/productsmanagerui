package com.lpg.pmappui.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtils {
    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getClientIp() {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

    public String getUserInSession(){
        String userInContext = "";
        if(request != null){
            userInContext = ""+request.getSession().getAttribute("userInSession");
        }
        return userInContext;
    }

}
