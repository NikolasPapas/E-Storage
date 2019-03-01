package com.eStorage.api.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogOutHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String LOG_OUT_URL = "/";


    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onLogOut(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String redirectUrl = LOG_OUT_URL;
        redirectStrategy.sendRedirect(request, response, redirectUrl);

    }

}
