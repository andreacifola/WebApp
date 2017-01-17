<<%
    if ((session.getAttribute("logged_user") == null)) {
%>

<%}else{ %>
Welcome <%=session.getAttribute("username")%>
<a href='logout.jsp'>Log out</a>
<%}%>
