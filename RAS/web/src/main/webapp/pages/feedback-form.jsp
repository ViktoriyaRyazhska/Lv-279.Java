<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Feedback</title>
</head>
<body>

<form:form method="post" action="processForm" modelAttribute="feedbackDTO">

    Learning ability:
    <form:select path="learningAbility">
        <form:options items="${learningAbility}" itemValue="id" itemLabel="markName"/>
    </form:select>


    <br><br>


    Overall technical competence:
    <form:select path="overallTechnicalCompetence">
        <form:options items="${overallTechnicalCompetence}" itemValue="id" itemLabel="markName"/>
    </form:select>

    <br><br>


    Passional initiative:
    <form:select path="passionalInitiative">
        <form:options items="${passionalInitiative}" itemValue="id" itemLabel="markName"/>
    </form:select>

    <br><br>


    Team work:
    <form:select path="teamWork">
        <form:options items="${teamWork}" itemValue="id" itemLabel="markName"/>
    </form:select>

    <br><br>

    Getting things done:
    <form:select path="gettingThingsDone">
        <form:options items="${gettingThingsDone}" itemValue="id" itemLabel="markName"/>
    </form:select>

    <br><br>

    Active Communicator:
    <form:select path="activeCommunicator">
        <form:options items="${activeCommunicator}" itemValue="id" itemLabel="markName"/>
    </form:select>

    <br><br>

    Summary: <form:input path="summary"/>

    <br><br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>


