<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione Profilo</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- Date Piker -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <script type="text/javascript" src="managementProfileControl.js"></script>

</head>
<body>
<div class="container-fluid" style="margin-top: 1%">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" style="text-align:center">Gestione Profilo</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search_form" class="form-horizontal col-sm-12" method="post" action="user_search.jsp" onsubmit="return validateUser(this)">
                    <div class="form-group">

                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="name">Nome:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="forename"  value="${param.newName.equals("null") ? "Prova" : param.newName}" class="form-control input-sm" id="name"
                                           placeholder="Inserisci nome">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="surname">Cognome:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="surname" value="${param.newSurname}" class="form-control input-sm" id="surname"
                                           placeholder="Inserisci cognome">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="city">Città :</label>
                                <div class="col-sm-9">
                                    <input type="text" name="city" value="${param.newCity}" class="form-control input-sm" id="city"
                                           placeholder="Inserisci città ">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="address">Indirizzo:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="address" value="${param.newAddress}" class="form-control input-sm" id="address"
                                           placeholder="Inserisci indirizzo">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="date">Data:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="date" value="${param.newDate}" class="form-control input-sm" id="date"
                                           placeholder="GG-MM-AAAA">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="email">Email:</label>
                                <div class="col-sm-9">
                                    <input type="email" name="email" value="${param.newEmail}" class="form-control input-sm" id="email"
                                           placeholder="Inserisci email">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="username">Username:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="username" class="form-control input-sm" id="username"
                                           placeholder="Inserisci username">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="password">Password:</label>
                                <div class="col-sm-9">
                                    <input type="password" name="password" value="${param.newPassword}" class="form-control input-sm" id="password"
                                           placeholder="Inserisci password">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="rptpwd">Ripeti pwd:</label>
                                <div class="col-sm-9">
                                    <input type="password" name="rptpassword" value="${param.newPassword}" class="form-control input-sm" id="rptpwd"
                                           placeholder="Inserisci nuovamente password">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div class="row" style="margin-bottom: 3%">
                            <div class="col-sm-0.5"></div>
                            <div class="col-sm-11">
                                <label class="control-label col-sm-3" for="iban">Codice IBAN:</label>
                                <div class="col-sm-9">
                                    <input type="text" name="iban"  value="${param.newIban}" class="form-control input-sm" id="iban"
                                           placeholder="Inserisci codice IBAN">
                                </div>
                            </div>
                            <div class="col-sm-0.5"></div>
                        </div>
                        <div style="text-align: center">
                            <button type="reset" onclick="window.history.back()" class="btn btn-default" style="margin-top:3%; margin-bottom:2%">Indietro</button>
                            <button type="submit" class="btn btn-default" style="margin-top:3%; margin-bottom:2%">Salva</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-sm-3"></div>

    <script>
        $(document).ready(function(){
            var date_input=$('input[name="date"]');
            var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
            });
        })
    </script>
</div>
</body>