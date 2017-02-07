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
<jsp:include page="../navigation_bar.jsp">
    <jsp:param name="current_tab" value="4"/>
</jsp:include>
<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" style="text-align:center">Posta inviata</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search-form" class="form-horizontal col-sm-12" method="post" action="visualize_email.jsp">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="receiver">A:</label>
                                <div class="col-sm-10">
                                    <input name="receiver" type="text" class="form-control input-sm" id="receiver"
                                           value="${param.newReceiver}"
                                           style="background:linear-gradient(whitesmoke,white);" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="object1">Oggetto:</label>
                                <div class="col-sm-10">
                                    <input name="object1" type="text" class="form-control" id="object1"
                                           value="${param.newObject1}
                                        " style="background:linear-gradient(whitesmoke,white);" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="message1">Testo:</label>
                                <div class="col-sm-10">
                                    <!-- Lasciare così la textarea altrimenti introduce spazi bianchi misteriosi-->
                                    <textarea name="texts" class="form-control" rows="9" id="message1"
                                              placeholder="${param.newBody1}"
                                              style="resize:none; background:linear-gradient(whitesmoke,white);"
                                              readonly></textarea>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-default" onclick="goBackSended()"
                                    style="margin-top:3%; margin-bottom:2%">Precedente
                            </button>
                            <button type="submit" class="btn btn-default" onclick="goForwardSended()"
                                    style="margin-top:3%; margin-bottom:2%">
                                Successivo
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" style="text-align:center">Posta ricevuta</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search-form" class="form-horizontal col-sm-12" method="post" action="visualize_email.jsp">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="receiver">Da:</label>
                                <div class="col-sm-10">
                                    <input name="sender" type="text" class="form-control input-sm" id="sender"
                                           value="${param.newSender}"
                                           style="background:linear-gradient(whitesmoke,white);" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="object1">Oggetto:</label>
                                <div class="col-sm-10">
                                    <input name="object2" type="text" class="form-control" id="object2"
                                           value="${param.newObject2}
                                           style=" background:linear-gradient(whitesmoke,white);" readonly>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-2" for="message1">Testo:</label>
                                <div class="col-sm-10">
                                    <!-- Lasciare così la textarea altrimenti introduce spazi bianchi misteriosi-->
                                    <textarea name="texts2" class="form-control" rows="9" id="message2"
                                              placeholder="${param.newBody2}"
                                              style="resize:none; background:linear-gradient(whitesmoke,white);"
                                              readonly></textarea>
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-default" onclick="goBackReceived()"
                                    style="margin-top:3%; margin-bottom:2%">Precedente
                            </button>
                            <button type="submit" class="btn btn-default" onclick="goForwardReceived()"
                                    style="margin-top:3%; margin-bottom:2%">Successivo
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>