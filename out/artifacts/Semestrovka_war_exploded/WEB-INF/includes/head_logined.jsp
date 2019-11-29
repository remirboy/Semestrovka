<%@ page import="DB.model.User" %><%--
  Created by IntelliJ IDEA.
  User: REMIR
  Date: 26.11.2019
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <p style="text-align: right; font-weight: bold">
        <a  class="button7" style="font-weight: bold"><%
            out.println( request.getSession().getAttribute("user"));
            out.println( request.getSession().getAttribute("id"));%></a>
    </p><br/>
    <button class="btn btn-outline-dark btn-sm" type="button"><a href="itementer">&#9998;</a></button>
</header>