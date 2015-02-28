<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="DBConnection.DBTools" %>
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
    ResultSet rs;
    String result;
%>
<%
    //rs = DBTools.executeSelect(request.getParameter("query"), new MyResultSetHandler());
    try {
    rs.next();
    result = rs.toString();
} catch (SQLException e) {
    e.printStackTrace();
}
     %>
<%= result %>


</body>
</html>
