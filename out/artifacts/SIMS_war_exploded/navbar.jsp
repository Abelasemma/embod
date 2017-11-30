<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/uikit.css"  rel="stylesheet"/>
    <link type="text/css" href="CSS/uikit.almost-flat.css" rel="stylesheet">
    <script type="text/javascript" src="js/core/dropdown.js"></script>


</head>
<body>

<nav class="uk-navbar">
    <a href="home.jsp" class="uk-navbar-brand">SIMS</a>
    <ul class="uk-navbar-nav">
        <li class="uk-active"><a href="/display">Home</a></li>
        <li><a href="/add.jsp">Add</a></li>

    </ul>
    <div class="uk-navbar-content uk-navbar-flip">

        <form method="get" action="/search" class="uk-form uk-margin-remove uk-display-inline-block">
            <input type="text"  name="q" placeholder="Enter Keyword.....">
            <input type="submit" class="uk-button" value="Search">
        </form>
        <div class="uk-navbar-content uk-navbar-flip">
            <a class="uk-text-middle uk-text-bold  uk-text-success" href="/display"> ${user.username} </a>
        </div>
        <div class="uk-navbar-content uk-navbar-flip">
            <form method="post" action="/logout"  class="uk-form uk-margin-remove uk-display-inline-block">
                <input type="submit" class="uk-button" value="Logout"/>
            </form>
        </div>

    </div>

</nav>

<br/>



</body>
</html>