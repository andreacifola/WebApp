<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("logged_user", null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
