<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta charset="UTF-8">--%>
<%--<title>Add Feedback</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<form:form method="post" action="processForm" modelAttribute="feedbackDTO">--%>

<%--Learning ability:--%>


<%--<br><br>--%>


<%--Overall technical competence:--%>


<%--<br><br>--%>


<%--Passional initiative:--%>


<%--<br><br>--%>


<%--Team work:--%>


<%--<br><br>--%>

<%--Getting things done:--%>


<%--<br><br>--%>

<%--Active Communicator:--%>


<%--<br><br>--%>

<%--Summary: <form:input path="summary"/>--%>

<%--<br><br>--%>

<%--<input type="submit" value="Submit"/>--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>


<html lang="en">
<head>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-lg-12 well">
        <div class="row">
            <h4>Add Feedback</h4>
            <form:form method="post" action="processForm" modelAttribute="feedbackDTO">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Learning ability
                            <form:select path="learningAbility" items="${learningAbility}" itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Overall technical competence
                            <form:select path="overallTechnicalCompetence" items="${overallTechnicalCompetence}"
                                         itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Passional initiative
                            <form:select path="passionalInitiative" items="${passionalInitiative}" itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Team work
                            <form:select path="teamWork" items="${teamWork}" itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Getting things done
                            <form:select path="gettingThingsDone" items="${gettingThingsDone}" itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Active Communicator
                            <form:select path="activeCommunicator" items="${activeCommunicator}" itemValue="id"
                                         itemLabel="markName" class="form-control"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            Summary
                            <form:input type="text" path="summary" placeholder="Summary"
                                        class="form-control"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:radiobutton path="proficient" value="0" id="teacher"/>
                            <label class="btn btn-primary active" for="teacher">Teacher</label>
                            <form:radiobutton path="proficient" value="1" id="expert" autocomplete="off"/>
                            <label class="btn btn-primary" for="expert">Expert</label>
                        </div>
                    </div>
                    <input type="submit" value="Save Feedback"/>
                </div>
            </form:form>
        </div>

    </div>
</div>


<script>

</script>
</body>
</html>


