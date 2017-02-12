<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="receivedLettersBean" scope="session" class="bean.ListLetterBean"/>

<html>
<head>
    <title>Visualizza posta ricevuta</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid">

    <%if (receivedLettersBean.getLetters() == null) {%>

    <div style="margin-top: 2%">
        <h4 style="text-align: center">Premi il bottone per cercare le lettere inviate!</h4>
    </div>

    <%} else if (receivedLettersBean.getLetters().size() == 0) {%>

    <div style="margin-top: 2%">
        <h4>Non ci sono email inviate da mostrare!</h4>
    </div>

    <%} else for (int i = 0; i < receivedLettersBean.getLetters().size(); i++) {%>

    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <jsp:include page="received_email_card.jsp">
                <jsp:param name="received_email_index" value="<%=i%>"/>
            </jsp:include>
        </div>
        <div class="col-sm-1"></div>
    </div>

    <%}%>

</div>
</body>
</html>