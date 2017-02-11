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

</head>
<body>

<jsp:include page="../navigation_bar.jsp">
    <jsp:param name="current_tab" value="4"/>
</jsp:include>

<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Posta <b> INVIATA</b></h3>
            </div>

            <form name="search-form" class="form-horizontal col-sm-12" method="post"
                  action="/checkCommunication/sended_email_visualize.jsp">
                <div class="form-group">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <button type="submit" name="submit_btn" class="btn btn-primary" value="<%="1"%>"
                                style="margin-top:3%; margin-bottom:2%">Cerca Posta <label style="font-weight:bold">
                            INVIATA</label>
                        </button>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </form>

            <jsp:include page="/checkCommunication/sended_email_check.jsp"/>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Posta <label style="font-weight:bold"> RICEVUTA</label></h3>
            </div>

            <form name="search-form" class="form-horizontal col-sm-12" method="post"
                  action="/checkCommunication/received_email_visualize.jsp">
                <div class="form-group">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <button type="submit" name="submit_btn" class="btn btn-primary" value="<%="1"%>"
                                style="margin-top:3%; margin-bottom:2%">Cerca Posta <label style="font-weight:bold">
                            RICEVUTA</label>
                        </button>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </form>

            <jsp:include page="/checkCommunication/received_email_check.jsp"/>
        </div>
    </div>
</div>
</body>
</html>