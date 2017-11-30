<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aruns
  Date: 10/15/2016
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search for ${query}</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<c:if test="${size == 0}" >
    <div class="uk-alert uk-alert-success" data-uk-alert>
        <a href="" class="uk-alert-close uk-close"></a>
        <p>Sorry! No data found for given query. PLease try again!</p>
    </div>
</c:if>
<c:if test="${size != 0}" >
<table class="uk-table uk-table-hover">
    <h4 class="uk-text-large uk-text-primary"> Result for: ${query} </h4>
    <hr>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th>Father Name</th>
        <th>Phone</th>
        <th>Grade</th>
        <th>Username</th>
        <th>Role</th>
    </tr>
    <c:forEach var="stu" items="${slist}">

        <tr>
            <td>${stu.id}</td>    
            <td>${stu.fname}</td>
            <td>${stu.lname}</td>
            <td>${stu.address}</td>
            <td>${stu.fathername}</td>
            <td>${stu.phoneno}</td>
            <td>${stu.grade}</td>
            <td>${stu.user.username}</td>
            <td>${stu.user.role}</td>

            <td><a href="/edit?id=${stu.id}" class=" uk-icon-pencil"  data-uk-tooltip="{pos:'top'}" title="Edit" ></a>
                <a  href="/delete?id=${stu.id}" class="uk-icon-close"  data-uk-tooltip="{pos:'top'}" title="Delete"></a>
            </td>

        </tr>


    </c:forEach>
</table>
</c:if>
</body>
</html>
