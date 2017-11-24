<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
</head>
<body>
<caption><h1>Feedback</h1></caption>
<table class="table table-condensed table-hover table-responsive table-bordered table-striped">
    <tr>
        <th>Learning ability</th>
        <th>Overall technical competence</th>
        <th>Passional initiative</th>
        <th>Team work</th>
        <th>Getting things done</th>
        <th>Active Communicator</th>
        <th>Summary</th>
    </tr>
    <c:forEach items="${allFeedback}" var="feedback">
        <tr>
            <td>${feedback.learningAbility.markName}</td>
            <td>${feedback.overallTechnicalCompetence.markName}</td>
            <td>${feedback.passionalInitiative.markName}</td>
            <td>${feedback.teamWork.markName}</td>
            <td>${feedback.gettingThingsDone.markName}</td>
            <td>${feedback.activeCommunicator.markName}</td>
            <td>${feedback.summary}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

