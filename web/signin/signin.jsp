<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Accesso</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="well" style="background-color: white;">
    <div style="margin-left: 10%; margin-right: 10%">
        <div class="row">
        <h1 align="center">Accedi</h1>
        <br>
    </div>
        <div class="row">
        <form class="form-horizontal" action="/signin/signinControl.jsp" method="get">
            <div class="row">
                <div class="form-group">
                    <% if (request.getAttribute("username_not_valid") != null) {%>
                    <div class="row">
                        <div class="alert alert-danger" role="alert">
                            <strong>Errore!</strong> Nome utente e/o password sbagliate.
                        </div>
                    </div>
                    <%} %>
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="control-label">Nome utente:</label>
                        </div>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="username" placeholder="Inserisci il nome utente">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="control-label">Password:</label>
                        </div>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" name="password" placeholder="Inserisci la password">
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-7"></div>
                <div class="col-sm-5">
                    <div class="form-group">
                        <button type="reset" class="btn btn-default">Reset</button>
                        <button type="submit" class="btn btn-primary">Accedi</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
        <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-10" align="right">
            <h5>Non sei ancora registrato? <a href="../registration/registration.jsp"> Registrati ora!</a></h5>
        </div>
    </div>

    </div>
</div>

</body>
</html>

