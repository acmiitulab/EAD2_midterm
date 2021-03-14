<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
    <br>
    <%
        Cookie[] cookies = ((HttpServletRequest)request).getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("logined")) {
               if (cookie.getValue().equals("true"))  {
                   response.getWriter().println("Welcome");
               }
            }
        }

    %>
</body>
</html>
