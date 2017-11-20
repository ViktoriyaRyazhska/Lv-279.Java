<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
</head>
<body>

    <h1>Hello world</h1>
    <a href="/showUsers">All users</a>
    <form action="/addUser" method="post">
        <input type="text" name="userName">Name
        <input type="submit" value="Save">
    </form>

</body>
</html>