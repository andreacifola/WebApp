<%--
  Created by IntelliJ IDEA.
  User: davidemagnanimi
  Date: 04/01/17
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="logged_user" scope="session" class="model.User"/>
<jsp:useBean id="paymentBean" scope="session" class="bean.PaymentBean"/>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%
    String cardNumber = request.getParameter("credit-card-number"),
            name = request.getParameter("name"),
            surname = request.getParameter("surname"),
            date = request.getParameter("date");


%>