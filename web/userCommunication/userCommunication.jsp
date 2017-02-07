<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Comunicazione tra utenti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="UserCommunicationControl.js"></script>
</head>
<body>
<jsp:include page="../navigation_bar.jsp"/>
<div class="container-fluid">

    <jsp:include page="userCommunication_box.jsp">
        <jsp:param name="username_receiver" value="<%=request.getParameter(\"username_owner\")%>"/>
    </jsp:include>

</div>
</body>
</html>
