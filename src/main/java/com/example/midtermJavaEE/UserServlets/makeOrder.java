package com.example.midtermJavaEE.UserServlets;

import com.example.midtermJavaEE.Pizzeria.Models.Order;
import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class makeOrder extends HttpServlet {
    Pizzeria pizzeria = new Pizzeria();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                req.getRequestDispatcher("MakeOrder.jsp").forward(req, resp);
            }
        } else
            req.getRequestDispatcher("Login.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {

                String[] pizzas = req.getParameterValues("answer");
                ArrayList<String> pizzanames = new ArrayList<>();
                for (String i : pizzas) {
                    pizzanames.add(i);
                    System.out.println(i);
                }
                pizzeria.MakeOrder(pizzanames);
                resp.getWriter().println("Your order in doing, please wait");

            }
        } else
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}