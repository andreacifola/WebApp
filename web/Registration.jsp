<%@page import="bean.BeanUser" %>
<%@page import="dataSource.DataSource" %>
<%@ page import="querySQL.Query" %>
<%@ page import="utilityMD5.UtilityMD5" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% BeanUser user = (BeanUser) request.getAttribute("user");%>
<html>
<head>
    <title>Cerca Utente già Registrato</title>
</head>
<body>
<% if (user != null) {%>
<h3> L'utente <% user.getUsername(); %> già esiste! </h3>
<%} else {%>
<%
    try {
        Connection connection = DataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Query.addNewUser);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getCity());
        preparedStatement.setString(4, user.getAddress());
        preparedStatement.setDate(5, (java.sql.Date) user.getBirthDate());
        preparedStatement.setString(6, user.getEmail());
        preparedStatement.setString(7, user.getUsername());
        preparedStatement.setString(8, UtilityMD5.stringByHashingPassword(user.getPassword()));
        preparedStatement.setString(9, String.valueOf(user.getIban()));
    } catch (SQLException e) {
        e.printStackTrace();
%>
<h3>Registrato!</h3>
<%
        }
    }
%>
</body>
</html>