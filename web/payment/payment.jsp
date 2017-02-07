<%--
  Created by IntelliJ IDEA.
  User: davidemagnanimi
  Date: 03/01/17
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagamento</title>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../navigationBar.jsp"/>
<div class="container" style="margin-top: 10%; width: 30%">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Inserisci le informazioni richieste</h3>
        </div>
        <div class="panel-body">
            <form class="col-sm-12" method="get" action="checkout.jsp" onsubmit="return NomeCheck()">
                <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
                <div class="form-group">
                    <div class="row">
                        <label class="control-label">Numero di carta di credito:</label>
                        <input name="credit-card-number" type="text" class="form-control input-sm">
                    </div>
                    <div class="row">
                        <label class="control-label">Nome del proprietario della carta:</label>
                        <input name="name" type="text" class="form-control input-sm">
                    </div>
                    <div class="row">
                        <label class="control-label">Cognome del proprietario della carta:</label>
                        <input name="surname" type="text" class="form-control input-sm">
                    </div>
                    <div class="row">
                        <label class="control-label">Data di scadenza:</label>
                        <input name="date" type="date" class="form-control input-sm">
                    </div>
                    <div class="row" style="text-align: center; margin-top: 5%;  margin-bottom: -10%;">
                        <button type="submit" name="button" value="cancel" class="btn btn-default">Annulla</button>
                        <button type="submit" name="button" value="confirm" class="btn btn-primary">Conferma</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
