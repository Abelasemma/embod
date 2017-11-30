<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aruns
  Date: 10/4/2016
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SIMS</title>
    <link type="text/css" href="CSS/uikit.css"  rel="stylesheet"/>
    <link type="text/css" href="CSS/uikit.almost-flat.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script  src="js/core/dropdown.js"></script>
    <script src="js/uikit.js"></script>
  </head>
  <body>
  <c:if test="${logout ==1}">
    <div class="uk-alert uk-alert-success" data-uk-alert>
      <a href="" class="uk-alert-close uk-close"></a>
      <p>You have been logged out!</p>
    </div>
  </c:if>
    <div id="login">

      <form  class="uk-form uk-text-center uk-width-1-1" method="post" action="/login">
        <h3 class="uk-article-title"> Welcome to SIMS v1.1 (BETA)</h3>
        <hr class="uk-article-divider">
        <input type="text" name="uname" placeholder="Username" />
        <br/>
        <input type="text" name="pass" placeholder="Password" />
        <br/>
        <br/>
        <input type="submit" value="Login" />
      </form>
    </div>
  </body>
</html>
