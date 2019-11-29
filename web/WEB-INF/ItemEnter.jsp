<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 26.11.2019
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание статьи</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\logo.css">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\enter.css">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<div id="nav">
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
<div class="input-group">
    <form method="post" action="" name="item" id="item" >
        <table class="infobox" style="width:25.5em;" data-name="Автомобиль">
            <p align="right">
                <tbody>
                <tr>
                    <th colspan="2" class="infobox-above" style="background:#cfe3ff;">Название автомобиля<p><input type="text" name="car_name"></p></th>
            </tr>
            <tr>
                <td colspan="2" class="infobox-image" style="">
						<span class="no-wikidata" data-wikidata-property-id="P18">
							<a href="" class="image">
							<img alt="" src="" decoding="async" elementtiming="thumbnail-top" width="305" height="203" srcset="" data-file-width="5436" data-file-height="3624">
							</a>
						</span>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Power (h.p.)</th>
                <td class="plainlist">
                    <p><input type="text" name="power"></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Weight (kg)</th>
                <td class="plainlist">
                    <p><input type="text" name="weight"></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Maximum speed (km/h)</th>
                <td class="plainlist">
                    <p><input type="text" name="max_speed"></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Waste 100 km/h (l)</th>
                <td class="plainlist">
                    <p><input type="text" name="waste"></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Acceleration about 100 km/h (s)</th>
                <td class="plainlist">
                    <p><input type="text" name="acceleration"></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist" >Country</th>
                <td class="plainlist">
                    <p>
                        <select name="country">
                            <option name="country">France</option>
                            <option name="country">USA</option>
                            <option name="country">Russia</option>
                            <option name="country">Japan</option>
                            <option name="country">German</option>
                        </select></p>
                </td>
            </tr>
            <tr>
                <th class="plainlist">Bodywork</th>
                <td class="plainlist">
                    <p>
                        <select name="body">
                            <option name="body">Sedan</option>
                            <option name="body">Wagon</option>
                            <option name="body">Hatchback</option>
                            <option name="body">Сoupe</option>
                            <option name="body">Cabrio</option>
                        </select></p>
                </td>
            </tr>
            </tbody>
            </p>
        </table>
        <div id="content">
            <p><b>Item name:</b></p>
            <input name="name">
            <p><b>Write about auto here:</b></p>
            <textarea cols="100" name="item"> </textarea>
            <div class="btn-group" role="group" arealabel="Basic">
                    <button class="navbar navbar-dark bg-primary" type="button" name="button-loader">&dArr;Загузить картинку</button>
                    <button class="navbar navbar-dark bg-primary"  type="submit" name="button-item" onclick="valid(document.getElementById('form'))" >Save item</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
