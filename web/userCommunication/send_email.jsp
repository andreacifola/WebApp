<%@ page import="controller.communication.UsersCommunicationController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sender = request.getParameter("sender");
    String receiver = request.getParameter("receiver");
    String object = request.getParameter("object");
    String text = request.getParameter("texts");

    try {
        UsersCommunicationController ucc = new UsersCommunicationController();
        ucc.sendEmail(sender, receiver, object, text);

        request.getRequestDispatcher("/checkCommunication/checkCommunication.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>