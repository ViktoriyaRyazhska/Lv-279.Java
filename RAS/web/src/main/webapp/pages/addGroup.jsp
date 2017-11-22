<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<div class="container">


    <form:form method="post" action="/addGroup" modelAttribute="academyDTO" >
        <table>
            <tr>
                <td><form:input type="text" path="grName" placeholder="Group Name"/></td>
            </tr>
            <tr>
                <td><form:input type="text" path="nameForSite" placeholder="Site for Name"/></td>
            </tr>
            <tr>
                <td><form:select path="academyStages" items="${academyStages}" itemValue="stageId"
                                 itemLabel="name"/>Status</td>
            </tr>
            <tr>
                <td><form:input type="date" path="startDate"/></td>
            </tr>
            <tr>
                <td><form:input type="date" path="endDate"/></td>
            </tr>
            <tr>
                <td><form:select path="cityNames" items="${cityNames}" itemValue="itemId"
                                 itemLabel="trasnlation"/></td>
            </tr>

            <tr>
                <td>
                    <div class="payment-class">
                    <form:radiobutton path="payment" value="0" id="payment-free"/>
                    <label for="payment-free">Open Group</label>
                    <form:radiobutton path="payment" value="1" id="payment-paid"/>
                    <label for="payment-paid">Founded by SoftServe</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td><form:select path="direction" items="${direction}" itemValue="directionId" itemLabel="name"/></td>
            </tr>
            <tr>
                <td><form:select path="technologie" items="${technologie}" itemValue="technologyId"
                                 itemLabel="name"/></td>
            </tr>
            <tr>
                <td><form:select path="profile" items="${profile}" itemValue="profileId" itemLabel="profileName"/></td>
            </tr>
            <tr>
                <td><form:input type="number" path="studentsPlannedToGraduate" placeholder="Planned to Graduate"/></td>
                <td><form:input type="number" path="studentsPlannedToEnrollment" placeholder="Students Planned to Enrollment"/></td>
                <td><form:input type="number" path="studentsActual" placeholder="Students Count Actual"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save Group"/></td>
            </tr>
        </table>
    </form:form>
</div>


</body>
</html>


