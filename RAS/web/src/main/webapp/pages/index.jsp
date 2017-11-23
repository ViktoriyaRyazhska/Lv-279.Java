<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<html>
<head>
    <title>Hello world</title>
</head>
<body>

    <h1>Hello world</h1>

    <a href="${contextPath}/showUsers"><button>All users</button></a>
    <a href="${contextPath}/showHistory"><button>All History</button></a>
    <a href="${contextPath}/showItaAcademyById"><button>ItaAcademy</button></a>
    <a href="${contextPath}/allGroupsInf"><button>Information about groups</button></a>
    <a href="${contextPath}/feedback/showFeedbacks"><button>All Feedback</button></a>
    <a href="${contextPath}/feedback/addFeedback"><button>add Feedback</button></a>
    <a href="${contextPath}/group"><button>Add Group</button></a>

</body>
</html>
