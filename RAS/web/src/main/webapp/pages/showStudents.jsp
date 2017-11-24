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

    <title>Show students of group</title>

    <link href="/bs/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bs/css/students.css" rel="stylesheet">
</head>

<body>
<div class="container">

    <div class="page-header">
        <h2>Group Information</h2>
        <form method="get" action="${contextPath}/students" name="selectAcademyForm" class="form-inline">
            <label>
                Please choose group.
                <select name='academyId' class="form-control">
                    <option value="" ${academyId == null ? 'selected' : ''}>-</option>
                    <option value="796" ${academyId != null ? 'selected' : ''}>796</option>
                </select>
            </label>
            <button type="submit" class="btn btn-default">Search</button>
            <c:if test="${academyId != null}">
                <a href="${contextPath}/students/${academyId}/add" class="btn btn-default">Add Student</a>
                <a href="${contextPath}/group-${academyId}/pages-1-Teacher" class="btn btn-primary">Assign to group</a>
            </c:if>
        </form>
    </div>
    <c:if test="${academyId != null}">
    <form method="post" action="${contextPath}/students/${academyId}" name="deleteStudents" class="form-inline">
        <div class="page-header">
           <button type="submit" class="btn btn-default">Reject checked</button>

        </div>


    <div id="show-students-table">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Reject student</th>
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
                    <th>Final, Base</th>
                    <th>Final, Lang</th>
                    <th>Test 9</th>
                    <th>Test 10</th>
                    <th>English grammar</th>
                    <th>Interviewer Score</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr id="rows">
                        <td>
                            <label>
                                <input type="checkbox" name="checked${student.studentId}"/>
                            </label>
                        </td>
                        <td>${student.fullName} </td>
                        <td>${student.englishLevel}</td>
                        <td>${student.trainingScore}</td>
                        <td>${student.teacherScore}</td>
                        <td>${student.expertScore}</td>
                        <td>${student.current}</td>
                        <td>${student.test1}</td>
                        <td>${student.test2}</td>
                        <td>${student.test3}</td>
                        <td>${student.test4}</td>
                        <td>${student.test5}</td>
                        <td>${student.entryScore}</td>
                        <td>${student.finalBase}</td>
                        <td>${student.finalLang}</td>
                        <td>${student.test9}</td>
                        <td>${student.test10}</td>
                        <td>${student.englishGrammar}</td>
                        <td>${student.interviewerScore}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    </form>
</div>

