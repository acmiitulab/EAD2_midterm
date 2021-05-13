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
    <title>Title</title>
</head>
<body>
    <p><span style="font-size:28px;"><a href="/login">Login</a></span></p>

    <p><span style="font-size:28px;">
    <a href="/index.jsp">Main page</a></span></p>

    <form action="/registration" method="post">
        <p style="text-align: center;"><input name="username" placeholder="login" type="text" style="size: 20px;" /></p>

        <p style="text-align: center;"><br />
            <input name="password" placeholder="password" type="password" /></p>

        <p style="text-align: center;"><br />
            <input name="confirmPassword" placeholder="password" type="password" /></p>

        <p style="text-align: center;"><br />
            <input type="submit" value="Submit" /></p>
    </form>


</body>
</html>

