<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione Profilo</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <script src="managementProfileControl.js"></script>
</head>
<body>
<div class="container-fluid" style="margin-top: 1%">
    <%if (request.getAttribute("username_not_valid") != null){%>
    <div class="alert alert-danger" role="alert">
        Lo username <label style="font-style: italic"> <%=request.getAttribute("username_not_valid")%></label> non è valido.</div>
    <%}%>
    <% HashMap<String,Object> attributes = (HashMap<String,Object>) request.getAttribute("attributes");%>
    <% if(attributes != null) {%>
    <jsp:include page="managementProfileBox.jsp">
        <jsp:param name="newName" value="<%=attributes.get(\"forename\")%>"/>
        <jsp:param name="newSurname" value="<%=attributes.get(\"surname\")%>"/>
        <jsp:param name="newCity" value="<%=attributes.get(\"city\")%>"/>
        <jsp:param name="newAddress" value="<%=attributes.get(\"address\")%>"/>
        <jsp:param name="newDate" value="<%=attributes.get(\"date\")%>"/>
        <jsp:param name="newEmail" value="<%=attributes.get(\"email\")%>"/>
        <jsp:param name="newPassword" value="<%=attributes.get(\"password\")%>"/>
        <jsp:param name="newIban" value="<%=attributes.get(\"iban\")%>"/>
    </jsp:include>
    <% } else {%>
    <jsp:include page="managementProfileBox.jsp"/>
    <%}%>
</div>
</body>
</html>
