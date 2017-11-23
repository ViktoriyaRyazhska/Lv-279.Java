<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Students Feedback</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="/bs/css/bootstrap.min.css">--%>
</head>
<body>
<table  class="table table-condensed table-hover table-responsive table-bordered table-striped">
    <caption><h1>Feedbacks</h1></caption>
    <tr>
        <th>Student name</th>
        <th>Add feedback</th>
        <th>Learning ability</th>
        <th>Overall technical competence</th>
        <th>Passional initiative</th>
        <th>Team work</th>
        <th>Getting things done</th>
        <th>Active Communicator</th>
        <th>Summary</th>
        <th>Learning ability</th>
        <th>Overall technical competence</th>
        <th>Passional initiative</th>
        <th>Team work</th>
        <th>Getting things done</th>
        <th>Active Communicator</th>
        <th>Summary</th>
    </tr>
    <c:forEach items="${students}" var="student">
    <tr id="rows">
        <th>${student.firstName} ${student.lastName}</th>

        <td>
            <!-- display the update link -->
            <a href="${updateLink}">Teacher Feedback</a>
            |
            <a href="${deleteLink}">Expert Feedback</a>
        </td>

        <td>${student.teacherFeedback.learningAbility.markName}</td>
        <td>${student.teacherFeedback.overallTechnicalCompetence.markName}</td>
        <td>${student.teacherFeedback.passionalInitiative.markName}</td>
        <td>${student.teacherFeedback.teamWork.markName}</td>
        <td>${student.teacherFeedback.gettingThingsDone.markName}</td>
        <td>${student.teacherFeedback.activeCommunicator.markName}</td>
        <td>${student.teacherFeedback.summary}</td>
        <td>${student.expertFeedback.learningAbility.markName}</td>
        <td>${student.expertFeedback.overallTechnicalCompetence.markName}</td>
        <td>${student.expertFeedback.passionalInitiative.markName}</td>
        <td>${student.expertFeedback.teamWork.markName}</td>
        <td>${student.expertFeedback.gettingThingsDone.markName}</td>
        <td>${student.expertFeedback.activeCommunicator.markName}</td>
        <td>${student.expertFeedback.summary}</td>
    </tr>
    </c:forEach>
</table>


<script>

</script>

</body>
</html>