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
<jsp:include page="../navigationBar.jsp"/>
<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" style="text-align:center">Inserisci il messaggio</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search-form" class="form-horizontal col-sm-12" method="post" action="send_email.jsp"
                      onsubmit="return validateCommunication(this)">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="sender">Da:</label>
                                <div class="col-sm-10">
                                    <input name="sender" type="text" class="form-control input-sm" id="sender"
                                           value="TODO mettere mittente" style="background:white;" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="receiver">A:</label>
                                <div class="col-sm-10">
                                    <input name="receiver" type="text" class="form-control input-sm" id="receiver"
                                           value="TODO mettere destinatario" style="background:white;" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="object">Oggetto:</label>
                                <div class="col-sm-10">
                                    <input name="object" type="text" class="form-control input-lg" id="object"
                                           style="font-size: 14px" placeholder="Inserisci oggetto...">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="message">Testo:</label>
                                <div class="col-sm-10">
                                    <!-- Lasciare così la textarea altrimenti introduce spazi bianchi misteriosi-->
                                    <textarea name="texts" class="form-control" rows="9" id="message"
                                              style="resize:none;" placeholder="Inserisci messaggio..."></textarea>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div style="text-align: center">
                            <button type="reset" class="btn btn-default" onclick="window.history.back()"
                                    style="margin-top:3%; margin-bottom:2%">Annulla
                            </button>
                            <button type="submit" class="btn btn-default" style="margin-top:3%; margin-bottom:2%">
                                Invia
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-sm-3"></div>
</div>
</body>
</html>
