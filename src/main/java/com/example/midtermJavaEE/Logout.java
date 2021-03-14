package com.example.midtermJavaEE;

import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Logout extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("token");

        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}
