<%@ page import="com.example.midtermJavaEE.Pizzeria.Collections.PizzasCollection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Models.Pizza" %><%--
  Created by IntelliJ IDEA.
  User: Mukhametkaly
  Date: 14.03.2021
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        a {
            border: 1px black solid;
            padding-left: 10px;
            padding-right:  10px;
            padding-top: 5px;
            padding-bottom: 5px;
            color: white;
            background-color: black;
            text-decoration-line: none;
            font-weight: bold;
        }
    </style>
    <title>Pizzeria</title>
</head>
<body>
    <br>
    <h1 style="text-align: center;"><span style="font-size:48px;">Welcome to our pizzeria</span></h1>

    <p style="text-align: center;"><span style="font-size:28px;"><a href="/checkorder">Chek your orders</a></span></p>

    <p style="text-align: center;"><br />
        <span style="font-size:28px;"><a href="/makeorder">Make order</a></span></p>

    <p style="text-align: center;"><br />
        <span style="font-size:28px;"><a href="/logout">exit</a></span></p>

    <p style="text-align: center;"><br />
        <span style="font-size:28px;"> <a href="/review.jsp">reviews</a></span></p>

</body>
</html>

