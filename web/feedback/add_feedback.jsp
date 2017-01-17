<%@ page import="controller.feedback.FeedbackController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="feedback" class="bean.FeedbackBean" scope="request">
    <jsp:setProperty name="feedback" property="*"/>
</jsp:useBean>
<%
    String ciao = "da";
    feedback.setDescription(ciao);
    //TODO implementare la logica del controllo e salvataggio
%>