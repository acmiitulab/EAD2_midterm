<%@ page import="com.example.midtermJavaEE.Pizzeria.Models.Message" %><%--
  Created by IntelliJ IDEA.
  User: Mukhametkaly
  Date: 25.04.2021
  Time: 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8" />
<title></title>
<style type="text/css">
    .brd {
        border: 4px solid black; /* Параметры границы */
        overflow: scroll;
        height:  80%;
    }

    .input {
        display: inline;
    }

    .message {
        border: 2px solid black;
        margin: 10px;
        font-size: 14px;
    }
</style>
<%@ include file="result.jsp"%>

<div class="brd" >
    <%
        ArrayList<Message> messages =  pizzeria.getMessages();

        for (Message message : messages) {

            out.println("<div class=\"message\">\n" +
                    "\t\t<h1 >" + message.getAuthor() + "</h1>\n" +
                    "\t\t<p>" + message.getMessage() + "<p>\n" +
                    "\t\t</br>\n" +
                    "\t</div>");


        }

    %>

</div>
</br>
<div class="input">
    <form action="/review" method="post">

        <input name="message" placeholder="message" type="text"  height=10px class="messagearea" size="222" />
        <input type="submit" value="Submit"   />

    </form>

</div>
