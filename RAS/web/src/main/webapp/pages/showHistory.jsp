<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <%--<style>
        table {
            width: 100%;
            background: white;
            color: black;
            border-spacing: 1px
        }
        th {
            background: lightskyblue;
            padding: 5px;

        }
        td{
            background: ghostwhite;
            padding: 5px;
            text-align: center;

        }
    </style>--%>
    </head>
<body>
<table class="table table-condensed table-hover table-responsive table-bordered table-striped">
    <caption><h1>History</h1></caption>
    <tr>
        <th>Group name</th>
        <th>Name for site</th>
        <th>Location</th>
        <th>Start Date</th>
        <th>End Date</th>`
        <th>Status</th>
        <th>Common Direction</th>
        <th>Modify Date</th>
        <th>Modify by</th>
    </tr>

    <c:forEach items="${allHistory}" var="history">
        <tr>
            <td>${history.academyName}</td>
            <td>${history.nameForSite}</td>
            <td>${history.location}</td>
            <td>${history.sartDate}</td>
            <td>${history.endDate}</td>
            <td>${history.stage}</td>
            <td>${history.direction}</td>
            <td>${history.modifyDate}</td>
            <td>${history.modifyBy}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

