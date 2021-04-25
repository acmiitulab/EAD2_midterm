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
    <%@ include file="result.jsp"%>
    <br>
    <form action="/createpizza" method="post">
        <p style="text-align: center;"><span style="font-size:28px;"><input name="name" placeholder="Pizza name" type="text" /></span></p>

        <p style="text-align: center;"><br />
            <span style="font-size:28px;"><input name="price" placeholder="price" type="text" /></span></p>

        <p style="text-align: center;"><br />
            <span style="font-size:28px;"><input type="submit" value="Submit" />&nbsp;</span></p>
    </form>



</body>
</html>
