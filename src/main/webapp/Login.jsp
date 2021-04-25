<%@ page import="com.example.midtermJavaEE.Pizzeria.Collections.PizzasCollection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Models.Pizza" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <p><span style="font-size:28px;"><a href="/registration">Registration</a></span></p>


    <form action="/login" method="post">
        <p style="text-align: center;"><span style="font-size:16px;"><input name="username" placeholder="login" type="text" /></span></p>

        <p style="text-align: center;"><br />
            <input name="password" placeholder="password" type="password" /></p>

        <p style="text-align: center;"><br />
            <input type="submit" value="Submit" /></p>
    </form>




</body>
</html>
