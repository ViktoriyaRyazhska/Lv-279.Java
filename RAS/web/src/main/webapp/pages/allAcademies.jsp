<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
         language="java"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/bs/css/bootstrap.min.css">
    <script type="text/javascript" src="/bs/js/bootstrap.min.js"></script>

    <%--<!-- Latest compiled and minified CSS -->--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<!-- Optional theme -->--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

    <%--<!-- Latest compiled and minified JavaScript -->--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

</head>
<body>

<table class="table table-condensed table-hover table-responsive table-bordered">
    <thead>
    <tr>
        <th>Group name</th>
        <th>Name For Site</th>
        <th>Direction</th>
        <th>Profile</th>
        <th>Payment Status</th>
        <th>Location</th>
        <th>Strart Date</th>
        <th>End Date</th>
        <th>Status</th>
        <th>Experts</th>
        <th>Students Planned To Graduate</th>
        <th>Students Planned for Enrolment</th>
        <th>Students Actual</th>
        <th>Hired - Not Graduate</th>
        <th>Common Direction</th>
        <th>Payment Status</th>
        <th>Interviewer Feedback</th>
    </tr>
    <tr>
        <td>
            <div class="input-group">
                <input type="text" class="form-control" id="searchGroup" name="search" placeholder="Search"/>
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit">
                        <%--<i class="glyphicon glyphicon-search"></i>--%>
                    </button>
                </div>
            </div>
        </td>
        <td>
            <div class="input-group">
                <input type="text" class="form-control" id="searchSite" name="search" placeholder="Search"/>
                <div class="input-group-btn">
                    <button class="btn btn-default" id="searchSiteButton" type="submit">
                        <%--<i class="glyphicon glyphicon-search"></i>--%>
                    </button>
                </div>
            </div>
        </td>
        <td>
            <select name="direction">

            </select>
        </td>
        <td>
            <select name="profile">

            </select>
        </td>
        <td>
            <select name="paymentStatus">

            </select>
        </td>
        <td>
            <select name="location">

            </select>
        </td>
        <td>
            <select name="strartDate">

            </select>
        </td>
        <td>
            <select name="endDate">

            </select>
        </td>
        <td>
            <select name="status"></select>
        </td>
        <td>
            <select name="experts">

            </select>
        </td>
        <td><input type="text" name="studentsPlannedToGraduate"></td>
        <td><input type="text" name="studentsPlannedForEnrolment"></td>
        <td><input type="text" name="studentsActual"></td>
        <td><input type="text" name="hiredNotGraduate"></td>
        <td>
            <select name="commonDirection">

            </select>
        </td>
        <td><input type="text" name="paymentStatus"></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listA}" var="list">
        <tr id="rows">
            <td>---</td>
            <td id="site">${list.name}</td>
            <td>${list.technologies.name}</td>
            <td>---</td>
            <td>${list.free}</td>
            <td>---</td>
            <td>${list.start_date}</td>
            <td>${list.end_date}</td>
            <td>${list.academy_stages.name}</td>
            <td>---</td>
            <td>---</td>
            <td>---</td>
            <td>---</td>
            <td>---</td>
            <td>${list.directions.name}</td>
        </tr>
    </c:forEach>
    </tbody>


</table>

<script>
    $("button").click(function(){
        $.ajax({
            url: "/searchSite",
            type: "POST",
            dataType: "json",
            data: ({searchPhrase: $("#searchSite").val()}),
            success:  changeList
        });
    });
    function changeList(list) {
        console.log(list);
        if ($("tr[id='rows'] td[id='site']").text != "${list.name}"){
            $(this).remove();
        }
    }
</script>

</body>
</html>