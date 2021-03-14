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

public class chekOrder extends HttpServlet {
    Pizzeria pizzeria = new Pizzeria();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
               ArrayList<Order> orders = pizzeria.getOrdersCollection().getOrdersByUsername(pizzeria.getUser().getUsername());

               if (orders.size() == 0) {
                   resp.getWriter().println("You dont have any orders");
               } else {
                   String str = "Your order(s):";
                   for (Order i : orders) {
                       str += i.getId() + " ";
                       for ( String pizza : i.getPizzas()) {
                           str += pizza + " ";
                       }
                       str += i.getPrice() + " ";
                       if (i.isDone()) {
                           str += "is done!";
                       }
                       str += "\n";
                    }
                   resp.getWriter().println(str);
               }

            }
        } else
            req.getRequestDispatcher("Login.jsp").forward(req, resp);

    }
}