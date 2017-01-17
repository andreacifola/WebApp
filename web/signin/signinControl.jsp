<%@ page import="controller.login.LoginController" %>
<%@ page import="model.User" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = new LoginController().LoginController(username, password);
    session.setAttribute("logged_user", user);
    if (user == null){
        request.setAttribute("username_not_valid", username);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    else if (user.getScout()) {
        request.getRequestDispatcher("#").forward(request, response);
    } else {
        session.setAttribute("logged_user", user);
        request.getRequestDispatcher("/search/search.jsp").forward(request, response);
    }
%>