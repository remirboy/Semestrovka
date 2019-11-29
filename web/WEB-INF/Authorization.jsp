<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 13.11.2019
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\auth.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.css">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <script type="text/javascript" src="JS\authValid.js"></script>

</head>
<body class="title">
<div>
    <nav class="navbar navbar-dark bg-primary">
        <a class="navbar-brand"> <img src="Images\logo.jpg" width="100	" height="100" alt=""></a>
    </nav>
</div>
<h1 align="center">Authorization </h1>
<form name="registration" action="" method="post" id="form">
    <label for="">Enter your email:</label><input type="email" name="email" placeholder="example@mail.com" id="email" title="Это имя видно другим пользователем" >
    <br>
    <label for="">Enter your password:</label> <input type="password" name="password" id="password"> <br><br>
    <button type="button " class="btn btn-outline-dark btn-sm" onclick="valid(document.getElementById('form'))">Enter</button>
</form>
</div>
</body>
</html>
