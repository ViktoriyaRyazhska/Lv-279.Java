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


    <form name="addGroupForm" method="post" action="/addGroup">
        <table>
            <tr>
                <td><input type="text" name="grName" placeholder="Group Name"/></td>
            </tr>
            <tr>
                <td><input type="text" placeholder="Site for Name"/></td>
            </tr>
            <tr>
                <td><form:select path="academyStages" items="${academyStages}" itemValue="stage_id"
                                 itemLabel="name"/></td>
            </tr>
            <tr>
                <td><input type="date" name="start-date"></td>
            </tr>
            <tr>
                <td><input type="date" name="end-date"></td>
            </tr>
            <tr>
                <td><form:select path="cityNames" items="${cityNames}" itemValue="translation_id"
                                 itemLabel="trasnlation"/></td>
            </tr>

            <tr>
                <td>
                    <div class="payment-class">
                    <input type="radio" name="payment" value="0" id="payment-free"/>
                    <label for="payment-free">Open Group</label>
                    <input type="radio" name="payment" value="1" id="payment-paid"/>
                    <label for="payment-paid">Founded by SoftServe</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td><form:select path="direction" items="${direction}" itemValue="direction_id" itemLabel="name"/></td>
            </tr>
            <tr>
                <td><form:select path="technologie" items="${technologie}" itemValue="technology_id"
                                 itemLabel="name"/></td>
            </tr>
            <tr>
                <td><form:select path="profile" items="${profile}" itemValue="profileId" itemLabel="profileName"/></td>
            </tr>
            <tr>
                <td><input type="text" placeholder="Planned to Graduate"/></td>
                <td><input type="text" placeholder="Students Planned to Enrollment"/></td>
                <td><input type="text" placeholder="Students Count Actual"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save Group"/></td>
            </tr>
        </table>
    </form>

    <%--</form:form>--%>


    <%--<form>--%>

    <%--<div class="row">--%>

    <%--<div class="group-name-class">--%>
    <%--<input type="text" placeholder="Group Name"/>--%>
    <%--</div>--%>
    <%--<div class="group-name-class">--%>
    <%--<input type="text" placeholder="Name for Site"/>--%>
    <%--</div>--%>

    <%--<!-- statys -->--%>
    <%--<div class="status-class">--%>
    <%--&lt;%&ndash;<form:select path="academyStages" items="${academyStages}" itemValue="stage_id" itemLabel="name"/>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--<!-- Location -->--%>
    <%--<div class="location-class">--%>
    <%--&lt;%&ndash;<form:select path="cityNames" items="${cityNames}" itemValue="translation_id" itemLabel="trasnlation"/>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--<!-- start date -->--%>
    <%--<div class="start-date-class">--%>
    <%--<input type="date" name="start-date">--%>
    <%--</div>--%>
    <%--<!-- end date -->--%>
    <%--<div class="end-date-class">--%>
    <%--<input type="date" name="end-date">--%>
    <%--</div>--%>

    <%--<div class="payment-class">--%>
    <%--<input type="radio" name="payment" value="0" id="payment-free"/>--%>
    <%--<label for="payment-free">Open Group</label>--%>
    <%--<input type="radio" name="payment" value="1" id="payment-paid"/>--%>
    <%--<label for="payment-paid">Founded by SoftServe</label>--%>
    <%--</div>--%>

    <%--<!-- Comon direction -->--%>
    <%--<div class="comon-direction-class">--%>
    <%--<form:select path="direction" items="${direction}" itemValue="direction_id" itemLabel="name"/>--%>
    <%--</div>--%>

    <%--<!-- direction -->--%>
    <%--<div class="direction-class">--%>
    <%--<form:select path="technologie" items="${technologie}" itemValue="technology_id" itemLabel="name"/>--%>
    <%--</div>--%>

    <%--<!-- Profile -->--%>
    <%--<div class="profile-class">--%>
    <%--<form:select path="profile" items="${profile}" itemValue="profileId" itemLabel="profileName"/>--%>
    <%--</div>--%>

    <%--<div class="student-count-class">--%>
    <%--<input type="text" placeholder="Students planned to graduate"/>--%>
    <%--<input type="text" placeholder="Students planned for enrolment"/>--%>
    <%--<input type="text" placeholder="Students count actual"/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</form>--%>
</div>


</body>
</html>


