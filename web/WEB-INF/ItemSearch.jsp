<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 29.11.2019
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css\logo.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\cards.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <a class="navbar-brand"> <img src="Images\logo.jpg" width="100	" height="100" alt=""></a>
    <div id="auth">
        <%
            if(request.getSession().getAttribute("user") == null) { %>
        <%@include file="includes/head_not_logined.jsp" %>

        <%  }
        else { %>
        <%@include file="includes/head_logined.jsp" %>
        <%    }
        %>
    </div>
</nav>
</div>
<form method="post" action="itemGet">
<div class="input-group">
    <button class="btn btn-outline-secondary" type="submit"  id="button-addon1">Search</button>
    <input  type="text" class="form-control" placeholder="" name="item_name" aria-label="Example text with button addon" aria-describedby="button-addon1">
</div>
</form>
</body>
</html>
