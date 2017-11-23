<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-lg-12 well">
        <div class="row">
            <h4>Add Group</h4>
            <form:form method="post" action="/addGroup" modelAttribute="academyDTO">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:input type="text" path="grName" placeholder="Group Name"
                                        class="form-control"/>
                        </div>
                        <div class="col-sm-6 form-group">
                            <form:input type="text" path="nameForSite" placeholder="Site for Name"
                                        class="form-control"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:select path="academyStages" items="${academyStages}" itemValue="stageId"
                                         itemLabel="name" class="form-control"/>
                        </div>
                        <div class="col-sm-6 form-group">
                            <form:select path="cityNames" items="${cityNames}" itemValue="itemId"
                                         itemLabel="trasnlation" class="form-control"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:input type="date" path="startDate" class="form-control"/>
                        </div>
                        <div class="col-sm-6 form-group">
                            <form:input type="date" path="endDate" class="form-control"/>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:radiobutton path="payment" value="0" id="payment-free" autocomplete="off"/>
                            <label class="btn btn-primary active" for="payment-free">Open Group</label>
                            <form:radiobutton path="payment" value="1" id="payment-paid"/>
                            <label class="btn btn-primary" for="payment-paid">Founded by SoftServe</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:select path="direction" items="${direction}" itemValue="directionId"
                                         itemLabel="name"
                                         class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:select path="technologie" items="${technologie}" itemValue="technologyId"
                                         itemLabel="name" class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <form:select path="profile" items="${profile}" itemValue="profileId"
                                         itemLabel="profileName"
                                         class="form-control"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-1 form-group">
                            <form:input type="number" path="studentsPlannedToGraduate"
                                        placeholder="Planned to Graduate" class="form-control"/>
                        </div>
                        <div class="col-sm-1 form-group">
                            <form:input type="number" path="studentsPlannedToEnrollment"
                                        placeholder="Students Planned to Enrollment" class="form-control"/>
                        </div>
                        <div class="col-sm-1 form-group">
                            <form:input type="number" path="studentsActual" placeholder="Students Count Actual"
                                        class="form-control"/>
                        </div>
                    </div>
                    <input type="submit" value="Save Group"/>
                </div>
            </form:form>
        </div>

    </div>
</div>


<script>

</script>
</body>
</html>


