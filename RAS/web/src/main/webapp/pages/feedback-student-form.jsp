<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script
        src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>

<html lang="en">
<head>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-lg-12 well">
        <h4>Add Feedback</h4>
        <div class="row">
            <form:form method="post" action="processFeedbackForm" modelAttribute="feedbackDTO">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Learning ability</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="learningAbility" items="${learningAbility}" itemValue="id"
                                         itemLabel="markName" class="form-control laSelect">
                            </form:select>

                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "laDesc">Learns very quickly, shows significant progress during education time</lable>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Overall technical competence</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="overallTechnicalCompetence" items="${overallTechnicalCompetence}"
                                         itemValue="id"
                                         itemLabel="markName" class="form-control laSelect"/>
                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "otDesc">Technically skilful, good technical background on different levels</lable>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Passional initiative</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="passionalInitiative" items="${passionalInitiative}" itemValue="id"
                                         itemLabel="markName" class="form-control laSelect"/>
                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "piDesc">Highly motivated to grow in chosen direction, shows initiative to get all needed knowledge and information for effective growth</lable>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Team work</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="teamWork" items="${teamWork}" itemValue="id"
                                         itemLabel="markName" class="form-control laSelect"/>
                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "twDesc">Work as team member, cooperates with others to achieve team goals</lable>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Getting things done</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="gettingThingsDone" items="${gettingThingsDone}" itemValue="id"
                                         itemLabel="markName" class="form-control laSelect"/>
                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "gtDesc">Finish tasks in time even if this will take extra efforts</lable>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Active Communicator</lable>
                        </div>
                        <div class="col-sm-3 form-group">
                            <form:select path="activeCommunicator" items="${activeCommunicator}" itemValue="id"
                                         itemLabel="markName" class="form-control laSelect"/>
                        </div>
                        <div class="col-sm-7 form-group">
                            <lable id = "acDesc">Good communication skills. Doesn't be afraid to talk to other students, teachers, experts. Clearly describes his/her point of view. Listening skills are good as well.</lable>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2 form-group">
                            <lable>Summary</lable>
                        </div>
                        <div class="col-sm-10 form-group">
                            <form:input type="text" path="summary" placeholder="Summary"
                                        class="form-control"/>
                        </div>
                    </div>
                    <input type="submit" value="Save Feedback"/>
                </div>
                <form:hidden path="studentId" value="${sId}"/>
                <form:hidden path="isTeacher" value="${isT}"/>

            </form:form>

            <c:forEach items="${indexList}" var="index">
                <input type="hidden" id="mapInput${index}" value="${mapMark[index]}"/>
            </c:forEach>

        </div>

    </div>
</div>
<script>
    $('.laSelect').change(function (e) {
        var val = this.value;
        console.log(val);
        if(val < 5) {
            $('#laDesc').text($("#mapInput"+val).val());
        } else if(val < 9) {
            $('#otDesc').text($("#mapInput"+val).val());
        } else if(val < 12) {
            $('#piDesc').text($("#mapInput"+val).val());
        } else if(val < 16) {
            $('#twDesc').text($("#mapInput"+val).val());
        } else if(val < 19) {
            $('#gtDesc').text($("#mapInput"+val).val());
        } else {
            $('#acDesc').text($("#mapInput"+val).val());
        }
    });
</script>
</body>
</html>


