<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/TRIGER/employee.css">
    <link rel="stylesheet" href="/TRIGER/bootstrap.css">
</head>
<body>
<c:url var="firstUrl" value="/pages-1-${role}" />
<c:url var="lastUrl" value="/pages-${deploymentLog.totalPages}-${role}" />
<c:url var="prevUrl" value="/pages-${currentIndex - 1}-${role}" />
<c:url var="nextUrl" value="/pages-${currentIndex + 1}-${role}" />
<div class="offset6">
    <a href="/pages-1-Teacher">Teachers</a>
    <a href="/pages-1-Expert">Expert</a>
    <a href="/pages-1-Interviewer">Interviewer</a>

    <div>
        <form action="/pages-1-${role}-search" method="get">
            <input type="text" name="texttosearch">
            <%--<input type="search" name="">--%>
            <button>Search</button>
        </form>
    </div>
    <form action="include-${role}" method="post">
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
                <c:url var="pageUrl" value="/pages-${i}-${role}" />
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
</div>

</body>
</html>
