<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca filtrata</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/bootstrap-slider.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/css/bootstrap-slider.css">

</head>
<body>
<jsp:include page="navigationBar.jsp"/>
<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Inserisci valori di ricerca</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search-form" class="form-horizontal col-sm-12" method="get" action="/results" onsubmit="return NomeCheck()"> <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-6">
                                <label class="control-label">Data di inizio:</label>
                                <input name="start-date" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                            </div>
                            <div class="col-sm-6">
                                <label class="control-label">Data di fine:</label>
                                <input name="end-date" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                            </div>
                        </div>
                        <div class="row" >
                            <div class="col-sm-6">
                                <label class="control-label">Regione:</label>
                                <input name="region" type="text" class="form-control input-sm" placeholder="Inserisci la regione">
                            </div>
                            <div class="col-sm-6">
                                <label class="control-label">Citt&agrave:</label>
                                <input name="city" type="text" class="form-control input-sm" placeholder="Inserisci la città">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <label class="control-label">Nome struttura:</label>
                                <input name="structure" type="text" class="form-control input-sm" placeholder="Inserisci la struttura">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <label class="control-label">Stanze:</label>
                                <select name="rooms" class="form-control input-sm" title="rooms-select">
                                    <option value="1" selected="selected">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">Bagni:</label>
                                <select name="toilets" class="form-control input-sm" title="toilets-select">
                                    <option value="1" selected="selected">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">Persone:</label>
                                <select name="people" class="form-control input-sm" title="people-select">
                                    <option value="1" selected="selected">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">Letti:</label>
                                <select name="beds" class="form-control input-sm" title="beds-select">
                                    <option value="1" selected="selected">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                </select>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 8%; margin-bottom: 5%">
                            <div class="col-sm-12">
                                <label class="control-label" style="margin-right: 5%">Prezzo massimo:</label>
                                <input name="price" data-provide="slider" type="text"
                                           data-slider-tooltip="always" data-slider-min="0" data-slider-max="200"
                                           data-slider-step="5" data-slider-value="75" title="price"/>

                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="wifi" type="checkbox">WiFi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="animals" type="checkbox">Animali ammessi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="room-service" type="checkbox">Servizio in camera</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="view" type="checkbox">Vista panoramica</label>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="smoking" type="checkbox">Stanza per fumatori</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="parking" type="checkbox">Area parcheggio</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="conditioned-air" type="checkbox">Area condizionata</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="plasma-tv" type="checkbox">TV al plasma</label>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-default" style="margin-top:5%;">Cerca</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-8">

        </div>
    </div>

    <script>
        $(document).ready(function(){
            var start_date=$('input[name="start-date"]');
            var end_date=$('input[name="end-date"]');
            var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
            start_date.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true
            });
            end_date.datepicker({
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true
            })
        })
    </script>
</body>
