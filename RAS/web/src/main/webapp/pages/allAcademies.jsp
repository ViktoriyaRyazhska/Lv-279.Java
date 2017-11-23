<%@ page import="ua.softserve.persistence.entity.Academy" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
         language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-condensed table-hover table-bordered table-responsive">
    <thead>
    <tr>
        <th>Group name</th>
        <th>Name For Site</th>
        <th>Direction</th>
        <th>Profile</th>
        <th>Payment Status</th>
        <th>Location</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Status</th>
        <th>Experts</th>
        <th>Students Planned To Graduate</th>
        <th>Students Planned for Enrolment</th>
        <th>Students Actual</th>
        <th>Hired - Not Graduate</th>
        <th>Common Direction</th>
        <th>Interviewer Feedback</th>
    </tr>
    <tr>
        <td>
            <input type="text" class="form-control" placeholder="#">
        </td>
        <td>
            <input id="searchSite" type="text" class="form-control" placeholder="#">
        </td>
        <td>
            <div>
                <form:select id="direction" class="form-control input-sm" path="directions">
                    <form:option value="">Directions</form:option>
                    <form:options items="${directions}"/>
                </form:select>
            </div>
        </td>
        <td>
            <div>
                <form:select id="profile" class="form-control input-sm" path="profileNames">
                    <form:option value="">ProfileNames</form:option>
                    <form:options items="${profileNames}"/>
                </form:select>
            </div>
        </td>
        <td>
            <div>
                <select id="paymentStatus" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td>
            <div>
                <select id="location" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td>
            <div>
                <select id="strartDate" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td>
            <div>
                <select id="endDate" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td>
            <div>
                <select id="status" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td>
            <div>
                <select id="experts" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td><input type="text" class="form-control" name="studentsPlannedToGraduate"></td>
        <td><input type="text" class="form-control" name="studentsPlannedForEnrolment"></td>
        <td><input type="text" class="form-control" name="studentsActual"></td>
        <td><input type="text" class="form-control" name="hiredNotGraduate"></td>
        <td>
            <div>
                <select id="commonDirection" class="form-control input-sm">
                    <%--<form:option value="">ProfileNames</form:option>--%>
                    <%--<form:options items="${profileNames}"/>--%>
                </select>
            </div>
        </td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 0;
    %>
    <c:forEach items="${listA}" var="list">
    <tr id="rows">
        <td>---</td>
        <td id="site">${list.name}</td>
        <td>${list.technologies.name}</td>
        <td>${list.profile.profileName}</td>
        <td>${list.free == 1 ? "Free" : "Paid"}</td>
        <td>${cities[list.city.cityId]}</td>
        <td>
            <%
                List<Academy> startTime = (List<Academy>)request.getAttribute("listA");
                String startDate = startTime.get(i).getStartDate().toString();
                String[] start = startDate.split(" ");
                out.print(start[0]);
            %>
        </td>
        <td>
            <%
                List<Academy> endTime = (List<Academy>)request.getAttribute("listA");
                String endDate = endTime.get(i).getEndDate().toString();
                String[] end = startDate.split(" ");
                out.print(end[0]);
            %>
        </td>
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
    $("input").change(function () {
        $.ajax({
            url: "${contextPath}/searchSite",
            type: "POST",
            contentType: false,
            cache: false,
            processData: false,
            dataType : "json",
            data: ({searchPhrase: $("input[id = 'searchSite']").val()}),
            success: changeList
        });
    });
    function changeList(list) {
        console.log(list);
    }
</script>

</body>
</html>