package com.example.midtermJavaEE.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class CreatePizzaFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {



        String name = req.getParameter("name");
        String price = req.getParameter("price");
        Double doubPrice = Double.parseDouble(price);
        if (name.equals("")) {
            if (doubPrice != 0.0) {
                filterChain.doFilter(req, resp);
            }
            else resp.getWriter().println("Please enter price");
        } else
            resp.getWriter().println("Please enter name");



    }

    public void destroy() {

    }
}
