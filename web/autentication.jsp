<%@ page import="bean.BeanUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% BeanUser user = (BeanUser) request.getAttribute("user"); %>
<html>
<head>
    <title> Autenticazione</title>

</head>
<body>
<% if (user != null){%>
    <h3> Autenticazione Eseguita</h3>
<% } else{ %>
    <h3> Autenticazione non eseguita</h3>
<% } %>

</body>
</html>