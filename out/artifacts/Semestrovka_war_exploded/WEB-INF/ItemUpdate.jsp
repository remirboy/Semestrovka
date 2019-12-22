<%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 02.12.2019
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ItemUpdate</title>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css\logo.css">
    <link rel="stylesheet" type="text/css" href="css\Mainpage.css">
    <link rel="stylesheet" type="text/css" href="css\bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css\update.css">
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>
<body>
<form action="itemUpdate" method="post">
    <div id="content">
    <p><b>Update item <%out.print(session.getAttribute("item_name"));%> here:</b></p>
    <textarea cols="50"  id="update"  name="item"> </textarea>
    <div class="btn-group" role="group" arealabel="Basic">
        <button class="navbar navbar-dark bg-primary"  type="submit" name="button-item"  >Save item</button>
    </div>
</div>
</form>

</body>
</html>
