<%
    session.setAttribute("username", null);
    session.invalidate();
    response.sendRedirect("signin.jsp");
%>
