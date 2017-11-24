<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <tr>
        <td>${feedbackDTO.learningAbility.markName}</td>
        <td>${feedbackDTO.overallTechnicalCompetence.markName}</td>
        <td>${feedbackDTO.passionalInitiative.markName}</td>
        <td>${feedbackDTO.teamWork.markName}</td>
        <td>${feedbackDTO.gettingThingsDone.markName}</td>
        <td>${feedbackDTO.activeCommunicator.markName}</td>
        <td>${feedbackDTO.summary}</td>
        <td></td>
    </tr>
        <tr>
            <td>${feedbackDTO.learningAbility.description}</td>
            <td>${feedbackDTO.overallTechnicalCompetence.description}</td>
            <td>${feedbackDTO.passionalInitiative.description}</td>
            <td>${feedbackDTO.teamWork.description}</td>
            <td>${feedbackDTO.gettingThingsDone.description}</td>
            <td>${feedbackDTO.activeCommunicator.description}</td>
            <td></td>
        </tr>
</table>

</body>
</html>
