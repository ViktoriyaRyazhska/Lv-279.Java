<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html lang="en">
<head>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bs/css/addGroup.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h4 align="center"><strong>Add Group</strong></h4>
    <div class="col-lg-12 well" id="form-test">
        <div class="row">
            <form:form method="post" action="${contextPath}/group/addGroup" modelAttribute="academyDTO" id="test-form">
                <div class="col-sm-12" id="form-div">
                    <ul class="col-sm-6 form-group" id="UL_left_column">
                        <li>
                            <div class="row">
                                <div class="col-sm-6 form-group" name="group-name-select">
                                    <label> Group Name:</label>
                                    <form:input type="text" path="grName" placeholder="Lv-279.Java"
                                                class="form-control"/>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label> Site for Name:</label>

                                    <form:input type="text" path="nameForSite" placeholder="Site for Name"
                                                class="form-control"/>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label> Status:</label>
                                    <form:select path="academyStages" items="${academyStages}" itemValue="stageId"
                                                 itemLabel="name" class="form-control"/>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label> Location:</label>
                                    <form:select path="cityNames" items="${cityNames}" itemValue="itemId"
                                                 itemLabel="trasnlation" class="form-control"/>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label> Start Date:</label>
                                    <form:input type="date" path="startDate" class="form-control"/>
                                </div>
                                <div class="col-sm-6 form-group">
                                    <label> End Date:</label>
                                    <form:input type="date" path="endDate" class="form-control"/>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="row">
                                <div class="col-sm-6">
                                    <form:radiobutton path="payment" value="0" id="payment-free"/>
                                    <label for="payment-free">Open Group</label>
                                </div>
                                <div class="col-sm-7">
                                    <form:radiobutton path="payment" value="1" id="payment-paid"/>
                                    <label for="payment-paid">Founded by SoftServe</label>
                                </div>
                            </div>
                        </li>
                    </ul>

                    <ul class="col-sm-6 form-group" id="UL_right_column">

                        <li>
                            <div class="form-group">
                                <label> Common Direction:</label>
                                <form:select path="direction" items="${direction}" itemValue="directionId"
                                             itemLabel="name"
                                             class="form-control"/>
                            </div>
                        </li>

                        <li>
                            <div class="row">
                                <div class="col-sm-6 form-group">
                                    <label> Direction:</label>
                                    <form:select path="technologie" items="${technologie}" itemValue="technologyId"
                                                 itemLabel="name" class="form-control"/>
                                </div>

                                <div class="col-sm-6 form-group">
                                    <label> Profile:</label>
                                    <form:select path="profile" items="${profile}" itemValue="profileId"
                                                 itemLabel="profileName"
                                                 class="form-control"/>
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="row">
                                <div class="col-sm-4">
                                    <label> Students Planned to Graduate:</label>
                                    <form:input type="number" path="studentsPlannedToGraduate"
                                                placeholder="Planned to Graduate" class="form-control"/>
                                </div>
                                <div class="col-sm-4">
                                    <label> Students Planned to Enrollment:</label>
                                    <form:input type="number" path="studentsPlannedToEnrollment"
                                                placeholder="Students Planned to Enrollment" class="form-control"/>
                                </div>

                                <div class="col-sm-4" id="testqwe">
                                    <label>Students Actual:</label>
                                    <form:input type="number" path="studentsActual"
                                                placeholder="Students Count Actual"
                                                class="form-control"/>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div>
                </div>
                <div align="center">
                    <input type="submit" value="Save Group" class="btn btn-primary" />
                </div>
            </form:form>

        </div>

    </div>
</div>


<script>
    //    $(".payment-select").click(function(){
    //        console.log('click');
    //    });

    $().button('toggle');


    //$().button('toggle');
</script>

</body>

</html>


