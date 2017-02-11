<%@ page import="bean.ListLetterBean" %>
<%@ page import="controller.communication.CommunicationController" %>
<%@ page import="querySQL.Query" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="logged_user" scope="session" class="model.User"/>
<%
    try {
        String logged_username = logged_user.getUsername();

        CommunicationController cc = new CommunicationController();
        ListLetterBean sendedLetters = new ListLetterBean();
        sendedLetters.setLetters(cc.getEmailInfo(logged_username, Query.findSenderNameAndSurname));
        session.setAttribute("sendedLettersBean", sendedLetters);

        ListLetterBean receivedLetters = new ListLetterBean();
        receivedLetters.setLetters(cc.getEmailInfo(logged_username, Query.findReceiverNameAndSurname));
        session.setAttribute("receivedLettersBean", receivedLetters);

    } catch (Exception e) {
        e.printStackTrace();
    }

    request.getRequestDispatcher("checkCommunication.jsp").forward(request, response);
%>