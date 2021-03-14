<%--
  Created by IntelliJ IDEA.
  User: Mukhametkaly
  Date: 14.03.2021
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Pizza</title>
</head>
<body>
    <a href="/main">Create pizza</a>
    <br>
    <form action="/createpizza" method="post">
    <input type="text" name="name" placeholder="Pizza name">
    <br>
    <input type="text" name="price" placeholder="price">
    <br>
    <input type="submit" value="Submit">

</form action="/createpizza" method="post">


</body>
</html>
