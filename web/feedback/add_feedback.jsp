<%@ page import="controller.feedback.FeedbackController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="feedback" class="bean.FeedbackBean" scope="request">
    <jsp:setProperty name="feedback" property="*"/>
</jsp:useBean>

<jsp:useBean id="logged_user" class="model.User" scope="session"/>

<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>

<%
    String username = logged_user.getUsername();
    String description = feedback.getDescription();
    Integer rating = feedback.getRating();

    FeedbackController fc = new FeedbackController();

    structuresBean.setStructures(null);

    if (fc.storeFeedback(username, Integer.valueOf(request.getParameter("locationID")), rating, description))
        request.getRequestDispatcher("/feedback/feedback_added.jsp").forward(request,response);
    else
        request.getRequestDispatcher("/feedback/feedback_refused.jsp").forward(request,response);
%>