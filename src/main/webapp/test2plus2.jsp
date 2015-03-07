<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="DBConnection.DBTools" %>
<%@ page import="DBConnection.DBObject" %>
<%@ page import="DBConnection.DBAPI" %>
<%@ page import="DBConnection.UserDAO" %>
<%@ page import="Bank.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 01.12.2014
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%!
    User user;
%>
<%
    user = UserDAO.getObject();

     %>
<%= user.getName() %>
<%= user.getAddress()%>


</body>
</html>
