<html>
    <head>
        <title>User</title>
    <body>
        <div align="center">
        <form action = "${pageContext.request.contextPath}/boo" method="post">
            <p align="center">Login</p>
            <input type="text" name = "login"/>
            <p align ="center">Password</p>
            <input type="password" name="password">
            <p align="center">E-mail</p>
            <input type="text" name="email">
            <br><br>
            <input type="radio" name="gender" value="Male">Male</input>
            <input type="radio" name="gender" value="Female">Female</input>
            <br><br>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
    </head>
</html>
