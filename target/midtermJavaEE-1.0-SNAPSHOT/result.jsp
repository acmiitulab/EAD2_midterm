<%@ page import ="java.util.*" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Pizzeria" %>
<!DOCTYPE html>
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
</head>
<body>
    <br>
    <%! Pizzeria pizzeria = new Pizzeria(); %>

    <%

        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                out.println("<a href=\"/login\" style=\"font-size:30px;\">" + pizzeria.getUser().getUsername() +"</a><br><br>");
            }
        } else
            out.println("<a href=\"/login\" style=\"font-size:30px;\"> Not logined </a><br><br>");

    %>
</body>
</html>

