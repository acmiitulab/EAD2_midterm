package com.example.midtermJavaEE;
import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


public class Login extends HttpServlet {

    Pizzeria pizzeria = new Pizzeria();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        pizzeria.login(username, password);

        if (pizzeria.getUser() == null) {
            resp.getWriter().println("Invalid login, or password!");
        } else {
            int tok = pizzeria.createToken(username);
            String token = Integer.toString(tok);
            if (pizzeria.getUser().isAdmin()) {
                req.getSession().setAttribute("token", token);
                req.getRequestDispatcher("AdminPage.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("token", token);
                req.getRequestDispatcher("UserPage.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                if (pizzeria.getUser().isAdmin())
                    req.getRequestDispatcher("AdminPage.jsp").forward(req, resp);
                else
                    req.getRequestDispatcher("UserPage.jsp").forward(req, resp);
            }
        } else
             req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}
