<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Assign to Group</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="/bs/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/bs/css/employee.css">
</head>
<body>
<c:url var="firstUrl" value="/group-${groupId}/pages-1-${role}" />
<c:url var="lastUrl" value="/group-${groupId}/pages-${deploymentLog.totalPages}-${role}" />
<c:url var="prevUrl" value="/group-${groupId}/pages-${currentIndex - 1}-${role}" />
<c:url var="nextUrl" value="/group-${groupId}/pages-${currentIndex + 1}-${role}" />
<div class="container">
    <div class="col-lg-6 well">
        <div class="customcontainer">
        <%--<a href="/group-${groupId}/pages-1-Teacher">Teachers</a>--%>
        <%--<a href="/group-${groupId}/pages-1-Expert">Expert</a>--%>
        <%--<a href="/group-${groupId}/pages-1-Interviewer">Interviewer</a>--%>

            <a href="/group-${groupId}/pages-1-Teacher"><button class="btn btn-primary changeposition">Teachers</button></a>
            <a href="/group-${groupId}/pages-1-Expert"><button class="btn btn-primary changeposition">Experts</button></a>
            <a href="/group-${groupId}/pages-1-Interviewer"><button class="btn btn-primary changeposition">Interviewers</button></a>


        <div class="moveinputs">
            <form action="/group-${groupId}/pages-1-${role}-search" method="get">
                <div class="col-sm-5 form-group">
                    <input class="form-control" type="text" name="firstname" value="${modelfirstname}" placeholder="First Name">
                </div>
                <div class="col-sm-5 form-group">
                    <input class="form-control" type="text" name="lastname" value="${modellastname}" placeholder="Last Name">
                </div>

                <button class="btn btn-primary">Search</button><br>
            </form>
        </div>

        <c:choose>
            <c:when test="${deploymentLog.numberOfElements==0}">
                    <h3 class="alert-danger" align="center">Invalid input, try again!</h3>
                <a href="/group-${groupId}/pages-1-${role}">Back to list</a>
            </c:when>
            <c:otherwise>
                <div class="formwithinputs">
                    <form action="/group-${groupId}/include-${role}" method="post">
                        <c:forEach items="${allEmployees}" var="employee">
                            <ul class="marker1 list-group">
                                <li class="list-group-item">${employee.firstname}</li>
                            </ul>
                            <ul class="marker2 list-group">
                                <li class="list-group-item">${employee.lastname} </li>
                            </ul>
                            <ul class="marker3 list-group">
                                <li class="list-group-item"><input type="checkbox" name="arr" value="${employee.employee_id}"></li>
                            </ul>
                        </c:forEach>
                        <button class="custombtn btn btn-primary">Assign</button>
                    </form>
                </div>
                <div align="center">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${currentIndex == 1}">
                                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                <li class="disabled"><a href="#">&lt;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                <li><a href="${prevUrl}">&lt;</a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                            <c:url var="pageUrl" value="/group-${groupId}/pages-${i}-${role}" />
                            <c:choose>
                                <c:when test="${i == currentIndex}">
                                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${currentIndex == deploymentLog.totalPages}">
                                <li class="disabled"><a href="#">&gt;</a></li>
                                <li class="disabled"><a href="#">&gt;&gt;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${nextUrl}">&gt;</a></li>
                                <li><a href="${lastUrl}">&gt;&gt;</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
                <a href="/group-${groupId}">Back to group</a>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
</div>
<%--<a href="/group-${groupId}/pages-1-Teacher"><button class="btn btn-primary">Assign to group</button></a>--%>
</body>
</html>
