<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aruns
  Date: 10/15/2016
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <script src="js/jquery.min.js"></script>
    <script  src="js/core/dropdown.js"></script>
    <script src="js/uikit.js"></script>
</head>
<body>
<%@ include file="navbar.jsp" %>


<c:if test="${dataSuccess == 1}">
    <div class="uk-alert uk-alert-success" data-uk-alert>
        <a href="" class="uk-alert-close uk-close"></a>
        <p>Data has been successfully inserted into Database</p>
    </div>
</c:if>
<c:if test="${dataSuccess ==0}">
    <div class="uk-alert uk-alert-danger" data-uk-alert>
        <a href="" class="uk-alert-close uk-close"></a>
        <p>Data couldn't be inserted. Please try again!</p>
    </div>
</c:if>
<% session.removeAttribute("dataSuccess"); %>
<form class="uk-form uk-form-horizontal" method="post" action="/add">
    <legend>User Information</legend>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> First Name</label>
        <div class="uk-form-controls">
            <input type="text" name="fname" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Last Name</label>
        <div class="uk-form-controls">
            <input type="text" name="lname" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Address</label>
        <div class="uk-form-controls">
            <input type="text" name="address" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Father Name</label>
        <div class="uk-form-controls">
            <input type="text" name="father_name" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Phone no</label>
        <div class="uk-form-controls">
            <input type="text" name="phone" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Grade</label>
        <div class="uk-form-controls">
            <input type="text" name="grade" required>
        </div>
    </div>
    <hr>
    <legend> Login Information </legend>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Username</label>
        <div class="uk-form-controls">
            <input type="text" name="uname" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Password</label>
        <div class="uk-form-controls">
            <input type="text" name="pass" required>
        </div>
    </div>
    <div class="uk-form-row">
        <label class="uk-form-label uk-text-bold"> Role</label>
        <div class="uk-form-controls">
            <select name="role">
                <option value="norole" selected>No Role </option>
                <option value="superuser">Super User </option>
                <option value="student">Student </option>
            </select>
        </div>
    </div>
    <div class="uk-form-row uk-width-1-4 uk-text-center">

        <input type="submit" class="uk-button-success uk-button-large ">

    </div>
</form>
</body>
</html>
