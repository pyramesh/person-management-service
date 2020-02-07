package com.ramesh.jwt;

import com.ramesh.exception.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ramesh.Yaleru on 2/1/2020
 */
@Component
@Configuration
public class JWTokenHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String REST_API_CONTEXT_PATH = "/api";
    private static final String SECRETE_TOKEN_KEY = "accessToken";

    @Autowired
    Environment environment;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String pathInfo = request.getRequestURI();
        //TODO: environment is not injecting.please check
        String tokenKey = /*environment.getProperty(SECRETE_TOKEN_KEY);*/"158a483339019a3b61eb7e2eae729fbc47360ee18381dfff9a77045d7f32f996";
        if ((pathInfo.contains(REST_API_CONTEXT_PATH))) {
            String authToken = request.getHeader(SECRETE_TOKEN_KEY);
            if (null != authToken && null != tokenKey && authToken.equals(tokenKey)) {
                return true;
            } else {
                throw new AccessDeniedException();
            }
        }
        return true;
    }

}
