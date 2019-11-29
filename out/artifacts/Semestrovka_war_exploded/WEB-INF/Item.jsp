<%@ page import="DB.DAO.CarDAO" %>
<%@ page import="DB.model.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.model.Item" %>
<%@ page import="DB.DAO.ItemDAO" %><%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 28.11.2019
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.min.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="css\item.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
</head>
<body>
<div>
    <nav class="navbar navbar-dark bg-primary">
        <a class="navbar-brand"> <img src="Images\logo.jpg" width="100	" height="100" alt=""></a>
        <div id="auth">
            <%if(request.getSession().getAttribute("user") == null) { %>
            <%@include file="includes/head_not_logined.jsp" %>
            <%  }
            else { %>
            <%@include file="includes/head_logined.jsp" %>
            <%    }
            %>
        </div>
    </nav>
</div>
<h1 id="firstHeading" class="firstHeading" lang="ru">
    <b><%
        ItemDAO itemDAO = new ItemDAO();
        Car car = new Car();
        car.setCar_id((Integer) request.getSession().getAttribute("car_id"));
        CarDAO carDAO = new CarDAO();
        ArrayList<String> par;
        par = carDAO.getCarParametrsById(car);
        Item item = new Item();
        item.setCar_id(car.getCar_id());
        ArrayList<String> text;
        text = itemDAO.getItemByCarId(car);
        out.print(par.get(0));%>
    </b>
</h1>
<div class="input-group">
    <%
        if(request.getSession().getAttribute("user") == null) { %>
    <%@include file="includes/head_not_logined.jsp" %>
    <%  }
    else { %>
    <%@include file="includes/logined_listener.jsp" %>
    <%    }
    %>
</div>
<table class="infobox" style="width:25.5em;" data-name="Автомобиль">
    <p align="right">
        <tbody>
        <tr>
            <th colspan="2" class="infobox-above" style="background:#cfe3ff;"><%
                out.print(text.get(0));
            %></th>
        </tr>
        <tr>
            <td colspan="2" class="infobox-image" style="">
						<span class="no-wikidata" data-wikidata-property-id="P18">
							<a href="//commons.wikimedia.org/wiki/File:VAZ_2101_BW_2016-09-03_13-51-58.jpg?uselang=ru" class="image">
							<img alt="VAZ 2101 BW 2016-09-03 13-51-58.jpg" src="C:\Users\REMIR\Desktop\Универ\ИКТ\Семестровка\Авто\html\vaz-2101-kopeyka-zhiguli-lada.jpg" decoding="async" elementtiming="thumbnail-top" width="305" height="203" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/a/a4/VAZ_2101_BW_2016-09-03_13-51-58.jpg/458px-VAZ_2101_BW_2016-09-03_13-51-58.jpg 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/a/a4/VAZ_2101_BW_2016-09-03_13-51-58.jpg/610px-VAZ_2101_BW_2016-09-03_13-51-58.jpg 2x" data-file-width="5436" data-file-height="3624">
							</a>
						</span>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Power (h.p.)</th>
            <td class="plainlist">
                <a  title="АвтоВАЗ"><%out.print(par.get(1));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Weight (kg)</th>
            <td class="plainlist">
                <a  title="АвтоВАЗ"><%out.print(par.get(2));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Maximum speed (km/h)</th>
            <td class="plainlist">
                <a class="mw-redirect" name="max_speed"><%out.print(par.get(3));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Waste 100 km/h (l)</th>
            <td class="plainlist">
                <a title="АвтоВАЗ" name="waste"><%out.print(par.get(4));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Acceleration about 100 km/h (s)</th>
            <td class="plainlist">
                <a title="АвтоВАЗ" name="acceleration"><%out.print(par.get(5));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Country</th>
            <td class="plainlist">
                <a title="АвтоВАЗ" name="country"><%out.print(par.get(6));%></a>
            </td>
        </tr>
        <tr>
            <th class="plainlist">Body</th>
            <td class="plainlist">
                <a title="АвтоВАЗ" name="body"><%out.print(par.get(7));%></a>
            </td>
        </tr>
        </tbody>
    </p>
</table>
<div id="content" name ="content">
<%out.print(text.get(1));%>
</div>
</body>
</html>
