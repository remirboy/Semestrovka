<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 28.11.2019
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>By body</title>
    <link rel="stylesheet" type="text/css" href="css\logo.css">
    <link rel="stylesheet" type="text/css" href="css\navigation.css">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\cards.css">
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
        </div>
    </nav>
</div>

<div class="input-group">
    <button class="btn btn-outline-secondary" type="button" id="button-addon1">Поиск</button>
    <input  type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
</div>
<div class="head">
    <div class="cards">
        <div class="card">
            <button type="button" class="btn btn-outline-dark btn-sm"><img src="Images/Bodies/Sedan.png" class="card-img-top" alt="...">
                <h5 class="card-title" align="center">Sedan</h5>
            </button>
        </div>
        <div class="card" >
            <button type="button" class="btn btn-outline-dark btn-sm"><img src="Images/Bodies/Universal.png" class="card-img-top" alt="...">
                <h5 class="card-title" align="center">Universal</h5>
            </button>
        </div>
        <div class="card" >
            <button type="button" class="btn btn-outline-dark btn-sm"><img src="Images/Bodies/Hetch.png" class="card-img-top" alt="...">
                <h5 class="card-title" align="center">Hatchback</h5>
            </button>
        </div>
        <div class="card" >
            <button type="button" class="btn btn-outline-dark btn-sm"><img src="Images/Bodies/Kupe.png" class="card-img-top" alt="...">
                <h5 class="card-title" align="center">Coupe</h5>
            </button>
        </div>
        <div class="card" >
            <button type="button" class="btn btn-outline-dark btn-sm"><img src="Images/Bodies/Cabrio.png" class="card-img-top" alt="...">
                <h5 class="card-title" align="center">Cabrio</h5>
            </button>
        </div>
    </div>
</div>

</body>
</html>
