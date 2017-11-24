<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Add Student to Group</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bs/css/students.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <form method="post" action="${contextPath}/students/${academyId}/add" name="addStudents" class="form-inline">
        <div class="page-header">
            <h2>Add Student to Group</h2>
            <p>Please, select students.</p>
            <button type="submit" class="btn btn-default">Submit</button>

        </div>

        <div id="add-students-table">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Choose</th>
                    <th>#</th>
                    <th>Student Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student" varStatus="status">
                    <tr id="rows">
                        <td>
                            <label>
                                <input type="checkbox" name="checked${student.id}"/>
                            </label>
                        </td>
                        <td>${student.id}</td>
                        <td>${student.fullName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>

