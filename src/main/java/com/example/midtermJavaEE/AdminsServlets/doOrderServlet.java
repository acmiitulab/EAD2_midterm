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

            resp.getWriter().println("<a href=\"/login\" style=\"font-size:30px;\">" + pizzeria.getUser().getUsername() +"</a>" + "<p style=\"text-align: center;\">&nbsp;</p>\n" +
                    "\n" +
                    "<p style=\"text-align: center;\">&nbsp;</p>\n" +
                    "\n" +
                    "<p style=\"text-align: center;\"><span style=\"font-size:28px;\">" + anw + "</span></p>");

        } else {
            resp.getWriter().println("<a href=\"/login\" style=\"font-size:30px;\">" + pizzeria.getUser().getUsername() +"</a>" + "<p style=\"text-align: center;\">&nbsp;</p>\n" +
                    "\n" +
                    "<p style=\"text-align: center;\">&nbsp;</p>\n" +
                    "\n" +
                    "<p style=\"text-align: center;\"><span style=\"font-size:28px;\"> You are not logginned </span></p>");
        }
    }
}
