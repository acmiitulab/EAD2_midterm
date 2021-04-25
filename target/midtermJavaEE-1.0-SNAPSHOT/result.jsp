<%@ page import ="java.util.*" %>
<%@ page import="com.example.midtermJavaEE.Pizzeria.Pizzeria" %>
<!DOCTYPE html>
<html>
<body>
    <br>
    <%! Pizzeria pizzeria = new Pizzeria(); %>

    <%

        String tok1 = (String) session.getAttribute("token");
        if (tok1 != null ) {
            int token1 = Integer.parseInt(tok1);
            pizzeria.auth(token1);
            if (pizzeria.getUser() != null) {
                out.println("<a href=\"/login\" style=\"font-size:30px;\">" + pizzeria.getUser().getUsername() +"</a>");
            }
        } else
            out.println("<a href=\"/login\" style=\"font-size:30px;\"> Not logined </a>");

    %>
</body>
</html>

