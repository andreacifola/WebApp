<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca filtrata</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
<jsp:include page="/navigation_bar.jsp">
    <jsp:param name="current_tab" value="1"/>
</jsp:include>

<div class="container" style="margin-top: 5%">
    <div class="alert alert-success" role="alert" style="text-align: center"><strong>Grazie!</strong> Il tuo feedback è fondamentale per poterci migliorare costantemente!</div>

    <form action="/search/search.jsp" style="margin-top: 5%; text-align: center">
        <button class="btn btn-default" role="button" type="submit">Torna alla homepage!</button>
    </form>
</div>
</body>
</html>
