package com.cefothe.judge.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The LogoutSuccessHandler decide what to do if the user logged out successfully,
 * by default it will redirect to the login page URL, because we don’t
 * have that I did override it to return an HTTP response with the 20 OK code.
 *
 * Created by Stefan Angelov - Delta Source Bulgaria on 2/12/17.
 */
@Component
public class HttpLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().flush();
    }
}
