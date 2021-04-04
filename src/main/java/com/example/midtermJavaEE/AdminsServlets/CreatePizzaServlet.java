package com.example.midtermJavaEE.AdminsServlets;

import com.example.midtermJavaEE.Pizzeria.Models.Pizza;
import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class CreatePizzaServlet extends HttpServlet {

    Pizzeria pizzeria = new Pizzeria();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                String pizzaname = req.getParameter("name");
                Double price = Double.parseDouble(req.getParameter("price"));
                pizzeria.getPizzasCollection().insert(new Pizza(pizzaname, price));
                resp.getWriter().println("Pizza created!");
            }
        } else
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                req.getRequestDispatcher("AddPizza.jsp").forward(req, resp);
            }
        } else
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}
