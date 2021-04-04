package com.example.midtermJavaEE.AdminsServlets;

import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class doOrderServlet extends HttpServlet {

    Pizzeria pizzeria = new Pizzeria();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String tok = (String) session.getAttribute("token");
        int token = Integer.parseInt(tok);
        pizzeria.auth(token);

        if (pizzeria.getUser() != null) {
            String anw = pizzeria.doOrder();

            resp.getWriter().println(anw);

        } else {
            resp.getWriter().println("You are not logginned" + tok);
        }
    }
}
