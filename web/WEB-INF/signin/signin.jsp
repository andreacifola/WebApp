<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sign-in</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container row col-sm-10" style="background-color: white">

    <div class="col-sm-12">


        <h1 align="center">Sign in</h1>
        <form class="form-horizontal" action="/WEB-INF/signin/signinControl.jspgninControl.jsp" method="get">
            <div class="form-group">
                <% if (request.getAttribute("username_not_valid") != null) {%>
                <div class="alert alert-danger" role="alert">
                    <strong>Error!</strong> Wrong username and/or password.
                </div>
                <%} %>
                <label class="control-label col-sm-2">Username:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="username" placeholder="Enter username">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" >Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" placeholder="Enter password">
                </div>
            </div>
            <br>
            <div class="col-sm-7"></div>
            <div class="form-group col-sm-5">
                <div>
                    <button type="reset" class="btn btn-default">Cancel</button>
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>

            </div>
        </form>
        <div class="col-sm-3"></div>
        <div class="col-sm-9" align="right">
        <h5>Non sei ancora registrato? <a href="#"> Registrati ora!</a> </h5>
        </div>

    </div>

</div>

</body>
</html>

