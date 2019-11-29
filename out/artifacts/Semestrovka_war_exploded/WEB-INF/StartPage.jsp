<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 13.11.2019
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AUTO_FAN</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
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
<%--            <form class="form-inline">--%>
<%--                <button class="btn btn-outline-dark btn-sm" type="button">Регистрация</button>--%>
<%--                <button class="btn btn-outline-dark btn-sm" type="button">Войти</button>--%>
<%--            </form>--%>
        </div>
    </nav>
</div>
<div class="main">
    <!-- <div id="begin" class="begin">
        <div id="logo"><h1><p align="center">AUTO_FAN</p> </h1></div>
        <div id = "auth">
            <p align="right"><a href="file:///C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\Authentication.html" target="_blank"> Вход</a></p>
            <p align="right"><a href="file:///C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\Регистрация.html" target="_blank"> Регистрация</a></p>
        </div>
    </div> -->
    <!-- <div id="navigation" align="left">
        Навигация:
        <ul>
            <li> <a href="file:///C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\country.html" target="_blank">По странам</a></li>
            <li><a href="file:///C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\country.html" target="_blank">По годам</a> </li>
            <li> <a href="file:///C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\bodywork.html" target="_blank">По кузову</a></li>
        </ul>
    </div> -->
    <div id="navigation" align="left">
        Navigation:
       <ul>

        <li> <a href="itemList" target="_blank">Items List</a></li>
        <li> <a href="itemSearch" target="_blank">Item Search</a></li>
    </ul>
    </div>
    <div id="main">
        <a  class="title">Are you like cars?Then you're at the right place. Here you can find information about cars. You can search them by manufacturer, by class. You can write an interesting article on automotive topics, send a photo of an unusual car. You can comment on the articles of other users, correct their errors, inaccuracies.
            <li>Rules:<ul>Don't be rude</ul><ul>Do not insult cars and their manufacturers</ul><ul>Do not use profanity</ul><ul>To write correctly</ul><ul>Criticism should be constructive</ul></li>
            For violation of the rules ban
        </a>
    </div>

    <div id="Author">
        <h2>Where find<abbr title="Remir Ziatdinov"><a href="#Author"> the author </a></abbr></h2>
        <p><a href="file:///C:/Users/Ремир/Desktop/Папка/Универ/ИКТ/HTML/Image.html" target="_blank" class="href">Photo of author</a></p><p><a href="mailto:remirboy@yandex.ru" target="_blank" class="href">Почта</a></p>
        <p><a href="https://vk.com/rmr_z" target="_blank" class="href">VK</a></p>
        <p ><a href="https://www.instagram.com/remirka_ziatdinov/" class="href">Instagram</a></p>
        <address class="address"><big>Russia,Tatarstan,Kazan</big> </address>
    </div>
</div>

</body>
</html>
