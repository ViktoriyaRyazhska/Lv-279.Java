<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <style>
        table {
            width: 100%; /* Ширина таблицы */
            background: white; /* Цвет фона таблицы */
            color: black; /* Цвет текста */
            border-spacing: 1px; /* Расстояние между ячейками */
        }
        th {
            background: lightskyblue; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */

        }
        td{
            background: ghostwhite; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
            text-align: center;

        }
    </style>
    </head>
<body>
<table >
    <caption><h1>History</h1></caption>
    <tr>
        <th>Group name</th>
        <th>Name for site</th>
        <th>Location</th>
        <th>Start Date</th>
        <th>End Date</th>
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

