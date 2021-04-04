<%--
  Created by IntelliJ IDEA.
  User: Mukhametkaly
  Date: 14.03.2021
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Models.Pizza" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Collections.PizzasCollection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make Order</title>
</head>
<body>
    <h1>Welcome to our pizzeria</h1>
    <form  action="/makeorder" method="post">
        <p><b>Choose pizzas which you want buy </b></p>
        <%
            PizzasCollection pizzasCollection = new PizzasCollection();
            ArrayList<Pizza> menu = pizzasCollection.getPizzas();

            String pr = "";
            for (Pizza i : menu) {
                pr += "<input type=\"checkbox\" name=\"answer\" value=\"" + i.getName() +  " \">" + i.getName() + " price: " + i.getPrice() + "<Br>\n";
            }
            out.print(pr);
        %>
        <input type="submit" value="Submit">
    </form>

</body>
</html>

