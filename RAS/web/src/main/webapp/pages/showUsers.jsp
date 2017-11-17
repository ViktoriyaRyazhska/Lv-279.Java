<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
</head>
<body>

    <c:forEach items="${allUsers}" var="user">
        <p>${user.firstName} - ${user.lastName} - ${user.email} - ${user.phone} - ${user.userName}</p>
    </c:forEach>

</body>
</html>