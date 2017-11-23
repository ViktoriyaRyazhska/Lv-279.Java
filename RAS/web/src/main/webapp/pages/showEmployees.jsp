<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/TRIGER/employee.css">
    <link rel="stylesheet" href="/TRIGER/bootstrap.css">
</head>
<body>
<c:url var="firstUrl" value="/group-${groupId}/pages-1-${role}" />
<c:url var="lastUrl" value="/group-${groupId}/pages-${deploymentLog.totalPages}-${role}" />
<c:url var="prevUrl" value="/group-${groupId}/pages-${currentIndex - 1}-${role}" />
<c:url var="nextUrl" value="/group-${groupId}/pages-${currentIndex + 1}-${role}" />
<div class="offset6">

    <a href="/group-${groupId}/pages-1-Teacher">Teachers</a>
    <a href="/group-${groupId}/pages-1-Expert">Expert</a>
    <a href="/group-${groupId}/pages-1-Interviewer">Interviewer</a>

    <div>
        <form action="/group-${groupId}/pages-1-${role}-search" method="get">
            <input type="text" name="firstname" value="${modelfirstname}">
            <input type="text" name="lastname" value="${modellastname}">
            <button>Search</button>
        </form>
    </div>
    <c:choose>
        <c:when test="${deploymentLog.numberOfElements==0 or deploymentLog.numberOfElements==null}">
            <h3>Invalid input, try again!</h3>
            <a href="/group-${groupId}/pages-1-${role}">Back to list</a>
        </c:when>
        <c:otherwise>
            <form action="/group-${groupId}/include-${role}" method="post">
                <c:forEach items="${allEmployees}" var="employee">
                    <div class="categorycontent">
                            ${employee.firstname} ${employee.lastname} <input type="checkbox" name="arr" value="${employee.employee_id}">
                    </div>
                </c:forEach>
                <button>Add</button>
            </form>
            <div class="pagination">
                <ul>
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
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
