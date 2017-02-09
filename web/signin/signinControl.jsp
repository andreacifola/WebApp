<%@ page import="controller.login.LoginController" %>
<%@ page import="model.User" %>
<%@ page import="model.payment.IBANCredentialNotValid" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = null;
    try {
        user = new LoginController().LoginController(username, password);
    } catch (IBANCredentialNotValid ibanCredentialNotValid) {
        ibanCredentialNotValid.printStackTrace();
    }
    if (user == null){
        request.setAttribute("username_not_valid", username);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    //else if (user.getScout()) {
    //    request.getRequestDispatcher("#").forward(request, response);
    //}
    else {
        session.setAttribute("logged_user", user);
        request.getRequestDispatcher("/search/search.jsp").forward(request, response);
    }
%>