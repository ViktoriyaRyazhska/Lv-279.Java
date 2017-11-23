<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-condensed table-hover table-responsive">
    <thead>
    <tr>
        <th>Student name</th>
        <th>English level</th>
        <th>Training Score</th>
        <th>Teacher Score</th>
        <th>Expert Score</th>
        <th>Current Score</th>
        <th>Test 1</th>
        <th>Test 2</th>
        <th>Test 3</th>
        <th>Test 4</th>
        <th>Test 5</th>
        <th>Entry Score</th>
        <th>Incoming, Test</th>
        <th>Interm. Test 1</th>
        <th>Interm. Test 2</th>
        <th>Final, Base</th>
        <th>Final, Lang</th>
        <th>Test 9</th>
        <th>Test 10</th>
        <th>English grammar</th>
        <th>Interviewer Score</th>
        <th>Student Status</th>
        <th>Person Status</th>
        <th>Approved By</th>
    </tr>
    <tr>
        <td>
            <input type="text" class="form-control" placeholder="#">
        </td>
        <td>
            <input type="text" class="form-control" placeholder="#">
        </td>
        <td>
            <div class="col-3">
                <form:select id="direction" class="form-control input-sm" path="directions">
                    <form:option value="">Directions</form:option>
                    <form:options items="${directions}"/>
                </form:select>
            </div>
        </td>
    </thead>
    <tbody>
    <c:forEach items="${listA}" var="list">
    <tr id="rows">
        <td>---</td>
        <td id="site">${list.name}</td>
        <td>${list.technologies.name}</td>
        <td>${list.profile.profileName}</td>
        <td>${list.free == 1 ? "Free" : "Paid"}</td>
        <td>${cities[list.city.cityId]}</td>
        <td>${list.startDate}</td>
        <td>${list.endDate}</td>
        <td>${list.academyStages.name}</td>
        <td>
            <c:forEach items="${list.experts}" var="expert">
                ${expert.firstname} ${expert.lastname}
            </c:forEach>
        </td>
        <td>${list.studentGroupCount.studentsPlannedToGraduate}</td>
        <td>${list.studentGroupCount.studentsPlannedToEnrollment}</td>
        <td>${list.studentGroupCount.studentsActual}</td>
        <td>---</td>
        <td>${list.directions.name}</td>
        <td>---</td>
    </tr>
    </c:forEach>
    <tbody>
</table>


<script>

</script>

</body>
</html>