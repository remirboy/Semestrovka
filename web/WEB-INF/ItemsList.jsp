<%@ page import="DB.DAO.ItemDAO" %>
<%@ page import="DB.model.Car" %><%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 28.11.2019
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of cars</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\logo.css">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\enter.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<div>
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
<div id="main">
    <h5>Items in AUTOFAN. The first item in list are more new.</h5>
   <%
    ItemDAO itemDAO = new ItemDAO();
      out.println(itemDAO.ItemListGET());
   %>
</div>
</body>
</html>
