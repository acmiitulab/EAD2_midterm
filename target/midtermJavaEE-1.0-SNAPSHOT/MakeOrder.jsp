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
<%@ include file="result.jsp"%>
<p style="text-align: center;"><strong><span style="font-size:34px;">Welcome to our pizzeria</span></strong></p>
<br>
    <form  action="/makeorder" method="post">

        <p style="text-align: center;"><strong><span style="font-size:28px;">Choose pizzas which you want buy</span></strong></p>
        <br>

        <%
            PizzasCollection pizzasCollection = new PizzasCollection();
            ArrayList<Pizza> menu = pizzasCollection.getPizzas();

            String pr = "";
            for (Pizza i : menu) {
                pr += "<p style=\"text-align: center;\"><input type=\"checkbox\" name=\"answer\" value=\"" + i.getName() +  " \" ><span style=\"font-size:26px;\">" + i.getName() + " price: " + i.getPrice() + "</span></p><Br>\n";
            }
            out.println(pr);
        %>
        <p style="text-align: center;"><span style="font-size:26px;">​</span><br />
            <input type="submit" value="Submit" /></p>

    </form>

</body>
</html>

