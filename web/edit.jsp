<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aruns
  Date: 10/15/2016
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <script src="js/jquery.min.js"></script>
    <script  src="js/core/dropdown.js"></script>
    <script src="js/uikit.js"></script>
</head>
<body>
<%@ include file="navbar.jsp" %>

<c:forEach var="stu" items="${edit}">
<form class="uk-form uk-form-horizontal" method="post" action="/edit">
    <legend>User Information</legend>

    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> First Name</label>
        <div class="uk-form-controls">
            <input type="text" name="fname" value="${stu.fname}" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Last Name</label>
        <div class="uk-form-controls">
            <input type="text" name="lname" value="${stu.lname}" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Address</label>
        <div class="uk-form-controls">
            <input type="text" name="address" value="${stu.address}" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Father Name</label>
        <div class="uk-form-controls">
            <input type="text" name="father_name" value="${stu.fathername}" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Phone no</label>
        <div class="uk-form-controls">
            <input type="text" name="phone"  value="${stu.phoneno}"required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Grade</label>
        <div class="uk-form-controls">
            <input type="text" name="grade"  value="${stu.grade}"required>
        </div>
    </div>
    <hr>
    <input type="hidden" name="id" value="${stu.id}">
    <div class="uk-form-row uk-width-1-4 uk-text-center">

        <input type="SUBMIT" class="uk-button-success uk-button-large ">

    </div>
</form>
    </c:forEach>
<body>

</body>
</html>
