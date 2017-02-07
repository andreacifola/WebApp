<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 03/01/17
  Time: 03:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Form Struttura</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/bootstrap-slider.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/css/bootstrap-slider.css">


</head>
<body>

<jsp:include page="../../navigationBar.jsp"/>

<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Form della struttura</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form id="formStructure-form" class="form-horizontal col-sm-12"
                      action="/management/managementStructure/formStructure.jsp">
                    <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-9">
                                <label class="control-label">Nome:</label>
                                <input name="name" type="text" value="${param.name}" class="form-control input-sm"
                                       placeholder="Inserisci il nome della struttura">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-9">
                                <label class="control-label">Regione:</label>
                                <input name="region" type="text" value="${param.region}" class="form-control input-sm"
                                       placeholder="Inserisci la regione in cui si trova la struttura">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-9">
                                <label class="control-label">Città:</label>
                                <input name="city" type="text" value="${param.city}" class="form-control input-sm"
                                       placeholder="Inserisci la città in cui si trova la struttura">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-7">
                                <label class="control-label">Indirizzo:</label>
                                <input name="address" type="text" value="${param.address}" class="form-control input-sm"
                                       placeholder="Inserisci l'indirizzo">
                            </div>
                            <div class="col-sm-2">
                                <label class="control-label">Civico:</label>
                                <input name="numHouse" type="text" value="${param.numHouse}"
                                       class="form-control input-sm" placeholder="">
                            </div>
                            <div class="col-sm-3">
                                <label class="control-label">CAP:</label>
                                <input name="CAP" type="text" value="${param.CAP}" class="form-control input-sm"
                                       placeholder="">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-9">
                                <label class="control-label">Propietario:</label>
                                <input name="owner" type="text" value="${param.owner}" class="form-control input-sm"
                                       placeholder="Inserisci il propietario della struttura">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <label class="control-label">Descrizione:</label>
                                <textarea name="description" type="text" value="${param.description}"
                                          class="form-control input-sm" rows="5"
                                          placeholder="Inserisci una descrizione della struttura"></textarea>
                            </div>
                        </div>
                        <div style="text-align: right; margin-top: 5%" %>
                            <input name="submit" type="submit"
                                   onclick="submitForm('/management/managementStructure/structureJavaInsert.jsp')"
                                   value="Inserisci" class="btn btn-primary"/>
                            <input name="cancel" type="submit"
                                   onclick="submitForm('/management/managementStructure/structure.jsp')" value="Annulla"
                                   class="btn btn-default"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script>
        function submitForm(action) {
            document.getElementById('formStructure-form').action = action;
            document.getElementById('formStructure-form').submit();
        }
    </script>

</div>
</body>
</html>