<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="sendedLettersBean" scope="session" class="bean.ListLetterBean"/>
<jsp:useBean id="receivedLettersBean" scope="session" class="bean.ListLetterBean"/>

<html>
<head>
    <title>Visualizza posta inviata e ricevuta</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="UserCommunicationControl.js"></script>
</head>
<body>
<jsp:include page="../navigation_bar.jsp"/>
<div class="container-fluid">
    <%
        int i = 0;
        String sender = sendedLettersBean.getLetters().get(i).getUsername();
        String object1 = sendedLettersBean.getLetters().get(i).getObject();
        String body1 = sendedLettersBean.getLetters().get(i).getBody();

        String receiver = receivedLettersBean.getLetters().get(i).getUsername();
        String object2 = receivedLettersBean.getLetters().get(i).getObject();
        String body2 = receivedLettersBean.getLetters().get(i).getBody();
    %>
    <jsp:include page="checkCommunication_box.jsp">
        <jsp:param name="newSender" value="<%=sender%>"/>
        <jsp:param name="newObject1" value="<%=object1%>"/>
        <jsp:param name="newBody1" value="<%=body1%>"/>

        <jsp:param name="newReceiver" value="<%=receiver%>"/>
        <jsp:param name="newObject2" value="<%=object2%>"/>
        <jsp:param name="newBody2" value="<%=body2%>"/>
    </jsp:include>

</div>
</body>
</html>