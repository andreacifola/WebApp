<%@ page import="controller.communication.UsersCommunicationController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sender = request.getParameter("sender");
    String receiver = request.getParameter("receiver");
    String object = request.getParameter("object");
    String text = request.getParameter("texts");
    //TODO prendere username di sender dal login di Luca e username di receiver dal caso d'uso di Davide...

    try {
        UsersCommunicationController ucc = new UsersCommunicationController();
        ucc.sendEmail("andreacifola", "davidemagno", object, text);

        request.getRequestDispatcher("../managementLocation/managementLocation.jsp").forward(request, response);
        //TODO rimandare alla pagina precedente
    } catch (Exception e) {
        e.printStackTrace();
    }
%>