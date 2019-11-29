<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 12.11.2019
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\reg.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <script type="text/javascript" src="JS\regValid.js"></script>
<%--    <script type="text/javascript">--%>
<%--        function valid(form){--%>
<%--            var fail=false;--%>
<%--            var email = form.email.value;--%>
<%--            var pass = form.password.value;--%>
<%--            var Repass = form.Repassword.value;--%>
<%--            var checkbox = form.checkbox.value;--%>
<%--            console.log(checkbox)--%>
<%--            if (email=='') {--%>
<%--                fail="Введите свой email";--%>
<%--            }--%>
<%--            else if (pass==''||pass==' ') {--%>
<%--                fail="Придумайте пароль";--%>
<%--            }--%>
<%--            else if (Repass!=pass) {--%>
<%--                fail="Пароли не совпадают";--%>
<%--            }--%>
<%--            else if (checkbox=='') {--%>
<%--                fail = "Подтвердите согласие на обработку персональных данных";--%>
<%--            }--%>
<%--            if (fail) {--%>
<%--                alert(fail);--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body class="title">
<div>
    <nav class="navbar navbar-dark bg-primary">
        <a class="navbar-brand"> <img src="Images\logo.jpg" width="100	" height="100" alt=""></a>
    </nav>
</div>
<div id="registration">
    <h1 align="center">Registration </h1>
    <form name="registration" action="" method="post" id="form">
        <label for="">Enter email:</label><input type="email" name="email" placeholder="example@mail.com" id="email" title="Это адрес вашей электронной почты" >
        <br>
        <label for="password">Enter password</label> <input type="password" name="password" id="password"> <br>
        <label for="password">Enter password again</label> <input type="password" name="Repassword" id="Repassword"> <br>
        <label for="">Role:
            <select name="role" id="role">
                <option name="role">Admin</option>
                <option name="role">User</option>
                <option name="role">Moderator</option>
            </select>
        </label><br>
        <label>I am familiar with the rules of the site, I agree to the processing of personal data<input type="checkbox" id="checkbox" name="checkbox"></label>
        <label><input type="checkbox" checked="checked" name="remember" /> Remember me</label>
        <div class="btn-group" role="group" arealabel="Basic">
            <button method="post"  type="submit" class="btn btn-outline-dark btn-sm" onclick="valid(document.getElementById('form'))">Create profile</button>
            <button method="post"  type="submit" class="btn btn-outline-dark btn-sm">Delete my entered data</button></div>
    </form>
</div>

</body>
</html>
