<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="/mycss/main.css">
    </head>
<body>
<caption><h1>Feedback</h1></caption>
<table >
<tr>
    <th>User name</th>
    <th>Learning ability</th>
    <th>Overall technical competence</th>
    <th>Passional initiative</th>
    <th>Team work</th>`
    <th>Getting things done</th>
    <th>Active Communicator</th>
    <th>Summary</th>
</tr>

<c:forEach items="${allFeedback}" var="feedback">
    <tr>
        <td>${feedback.itaAcademy.user.firstName} ${feedback.itaAcademy.user.lastName}</td>
        <td>${feedback.learningAbility.markName}</td>
        <td>${feedback.overallTechnicalCompetence.markName}</td>
        <td>${feedback.passionalInitiative.markName}</td>
        <td>${feedback.teamWork.markName}</td>
        <td>${feedback.gettingThingsDone.markName}</td>
        <td>${feedback.activeCommunicator.markName}</td>
        <td></td>
    </tr>
</c:forEach>
</table>

</body>
</html>

