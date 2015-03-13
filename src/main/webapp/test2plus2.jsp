<%@ page import="DBConnection.DBObject" %>
<%@ page import="DBConnection.DBAPI" %>
<%@ page import="java.math.BigInteger" %>
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
    DBObject user;
%>
<%
    user = DBAPI.getObject(new BigInteger("34"));

     %>
<%= user.getInfo() %>
<%= user.getID()%>


</body>
</html>
