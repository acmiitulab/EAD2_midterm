package com.example.midtermJavaEE.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ResponseRegisterFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {
            if ( password.charAt(0) <= 'Z' && password.charAt(0) >= 'A' ) {
                if (!username.equals("")) {
                    filterChain.doFilter(req, resp);
                } else
                    resp.getWriter().println("Please enter username");
            } else
                resp.getWriter().println("Password should contain uppercase");


        } else
             resp.getWriter().println("Password and confirm password are not equal");
    }

}