<%--
  Created by IntelliJ IDEA.
  User: andrii
  Date: 20.11.17
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ita Academy</title>
</head>
<body>


<c:forEach items="${list}" var="itaAcademy">
    <p>${itaAcademy.itAcademyId} - ${itaAcademy.academy.academyId} - ${itaAcademy.user.id} - ${itaAcademy.itaAcademyStatus}</p>
</c:forEach>

</body>
</html>