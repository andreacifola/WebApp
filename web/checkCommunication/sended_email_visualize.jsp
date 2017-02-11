<%@ page import="bean.ListLetterBean" %>
<%@ page import="controller.communication.CommunicationController" %>
<%@ page import="querySQL.Query" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="logged_user" scope="session" class="model.User"/>
<%
    try {
        String logged_email = logged_user.getEmail();

        CommunicationController cc = new CommunicationController();
        ListLetterBean sendedLetters = new ListLetterBean();
        sendedLetters.setLetters(cc.getEmailInfo(logged_email, Query.findSenderNameAndSurname));
        session.setAttribute("sendedLettersBean", sendedLetters);

    } catch (Exception e) {
        e.printStackTrace();
    }
    request.getRequestDispatcher("/checkCommunication/checkCommunication.jsp").forward(request, response);
%>