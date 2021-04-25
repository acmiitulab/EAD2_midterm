package com.example.midtermJavaEE;

import com.example.midtermJavaEE.Pizzeria.Pizzeria;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Review extends HttpServlet {

    Pizzeria pizzeria = new Pizzeria();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        System.out.println(message);

        HttpSession session = req.getSession();
        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null)
                pizzeria.writeMessage(message);
        }

        req.getRequestDispatcher("review.jsp").forward(req, resp);

    }

}
