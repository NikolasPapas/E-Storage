package com.eStorage.api.security;

import com.eStorage.api.entitys.user.EnumUserRole;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component("myAccessDeniedHandler")
public class DeniedPageHandler implements AccessDeniedHandler {
/*
    public static final Logger LOG = Logger.getLogger(CustomAccessDeniedHandler.class);
*/
private static final String USER_HOME_PAGE_URL = "/owner/Home";
    private static final String ADMIN_HOME_PAGE_URL = "/admin/home";

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exc) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


       if(auth.getAuthorities()
               .stream()
               .anyMatch(a -> ((GrantedAuthority) a).getAuthority().equals(EnumUserRole.ADMIN.name()))){
           //response.sendRedirect(request.getContextPath() + "/LogOut");
           response.sendRedirect(request.getContextPath() + ADMIN_HOME_PAGE_URL);
       }else if(auth.getAuthorities()
               .stream()
               .anyMatch(a -> ((GrantedAuthority) a).getAuthority().equals(EnumUserRole.USER.name()))){
           response.sendRedirect(request.getContextPath() + "/logOut");
//           response.sendRedirect(request.getContextPath() + USER_HOME_PAGE_URL);
       }else {
           response.sendRedirect(request.getContextPath() + "/");
       }

    }
}
