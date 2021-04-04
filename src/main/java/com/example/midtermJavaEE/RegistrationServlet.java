package com.example.midtermJavaEE;

import com.example.midtermJavaEE.Pizzeria.Models.User;
import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        Pizzeria pizzeria = new Pizzeria();
        if (password.equals(confirmPassword)) {
            if ( password.charAt(0) <= 'Z' && password.charAt(0) >= 'A' ) {
                if (!username.equals("")) {
                    pizzeria.getUsersCollection().insert( new User(username, password, false));
                    resp.getWriter().println("User successful created");
                } else
                    resp.getWriter().println("Please enter username");
            } else
                resp.getWriter().println("Password should contain uppercase");


        } else
            resp.getWriter().println("Password and confirm password are not equal");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Registration.jsp").forward(req, resp);
    }
}

