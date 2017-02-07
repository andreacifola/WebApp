<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 03/01/17
  Time: 03:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Form Locazione</title>
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
<%Integer structureIndex = Integer.valueOf(request.getParameter("structureindex"));%>


<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Form della locazione</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form id="formLocation-form" class="form-horizontal col-sm-12" name="structureindex"
                      value="<%=structureIndex%>" action="locationJavaInsert.jsp">
                    <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label for="description">Descrizione:</label>
                            <textarea name="description" class="form-control" value="${param.description}" rows="5"
                                      id="description"></textarea>
                        </div>
                        <div class="col-sm-3">
                            <label class="control-label">Stanze:</label>
                            <select name="rooms" class="form-control input-sm" title="rooms-select">
                                <option value="1" ${param.rooms.equals("1") ? "selected=\"selected\"" : null}>1</option>
                                <option value="2" ${param.rooms.equals("2") ? "selected=\"selected\"" : null}>2</option>
                                <option value="3" ${param.rooms.equals("3") ? "selected=\"selected\"" : null}>3</option>
                                <option value="4" ${param.rooms.equals("4") ? "selected=\"selected\"" : null}>4</option>
                                <option value="5" ${param.rooms.equals("5") ? "selected=\"selected\"" : null}>5</option>
                                <option value="6" ${param.rooms.equals("6") ? "selected=\"selected\"" : null}>6</option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label class="control-label">Bagni:</label>
                            <select name="toilets" class="form-control input-sm" title="toilets-select">
                                <option value="1" ${param.toilets.equals("1") ? "selected=\"selected\"" : null}>1
                                </option>
                                <option value="2" ${param.toilets.equals("2") ? "selected=\"selected\"" : null}>2
                                </option>
                                <option value="3" ${param.toilets.equals("3") ? "selected=\"selected\"" : null}>3
                                </option>
                                <option value="4" ${param.toilets.equals("4") ? "selected=\"selected\"" : null}>4
                                </option>
                                <option value="5" ${param.toilets.equals("5") ? "selected=\"selected\"" : null}>5
                                </option>
                                <option value="6" ${param.toilets.equals("6") ? "selected=\"selected\"" : null}>6
                                </option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label class="control-label">Persone:</label>
                            <select name="people" class="form-control input-sm" title="people-select">
                                <option value="1" ${param.people.equals("1") ? "selected=\"selected\"" : null}>1
                                </option>
                                <option value="2" ${param.people.equals("2") ? "selected=\"selected\"" : null}>2
                                </option>
                                <option value="3" ${param.people.equals("3") ? "selected=\"selected\"" : null}>3
                                </option>
                                <option value="4" ${param.people.equals("4") ? "selected=\"selected\"" : null}>4
                                </option>
                                <option value="5" ${param.people.equals("5") ? "selected=\"selected\"" : null}>5
                                </option>
                                <option value="6" ${param.people.equals("6") ? "selected=\"selected\"" : null}>6
                                </option>
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <label class="control-label">Letti:</label>
                            <select name="beds" class="form-control input-sm" title="beds-select">
                                <option value="1" ${param.beds.equals("1") ? "selected=\"selected\"" : null}>1</option>
                                <option value="2" ${param.beds.equals("2") ? "selected=\"selected\"" : null}>2</option>
                                <option value="3" ${param.beds.equals("3") ? "selected=\"selected\"" : null}>3</option>
                                <option value="4" ${param.beds.equals("4") ? "selected=\"selected\"" : null}>4</option>
                                <option value="5" ${param.beds.equals("5") ? "selected=\"selected\"" : null}>5</option>
                                <option value="6" ${param.beds.equals("6") ? "selected=\"selected\"" : null}>6</option>
                            </select>
                        </div>
                        <div class="col-sm-6">
                            <label class="control-label" style="margin-top: 2%">Inizio disponibiità:</label>
                            <input name="startAvaibility" type="text" class="form-control input-sm"
                                   value="${param.startAvaibility}" placeholder="GG-MM-AAAA">
                        </div>
                        <div class="col-sm-6">
                            <label class="control-label" style="margin-top: 2%">Fine disponibilità:</label>
                            <input name="endAvaibility" type="text" class="form-control input-sm"
                                   value="${param.endAvaibility}" placeholder="GG-MM-AAAA">
                        </div>
                        <div class="col-sm-12" style="margin-top: 10%">
                            <label class="control-label">Prezzo massimo:</label>
                            <input name="price" data-provide="slider" type="text"
                                   data-slider-tooltip="always" data-slider-min="0" data-slider-max="200"
                                   data-slider-step="5" data-slider-value="${param.price == null ? 75 : param.price}"
                                   title="price"/>
                        </div>
                        <br>
                    </div>
                    <div class="form-group" style="margin-top: 10%">
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="wifi"
                                              type="checkbox" ${param.wifi.equals("true") ? "checked=\"checked\"" : null}>WiFi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="animals"
                                              type="checkbox" ${param.animals.equals("true") ? "checked=\"checked\"" : null}>Animali
                                    ammessi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="room-service"
                                              type="checkbox" ${param.roomservice.equals("true") ? "checked=\"checked\"" : null}>Servizio
                                    in camera</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="view"
                                              type="checkbox" ${param.view.equals("true") ? "checked=\"checked\"" : null}>Vista
                                    panoramica</label>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="smoking"
                                              type="checkbox" ${param.smoking.equals("true") ? "checked=\"checked\"" : null}>Stanza
                                    per fumatori</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="parking"
                                              type="checkbox" ${param.parking.equals("true") ? "checked=\"checked\"" : null}>Area
                                    parcheggio</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="conditioned-air"
                                              type="checkbox" ${param.conditionedair.equals("true") ? "checked=\"checked\"" : null}>Area
                                    condizionata</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="plasma-tv"
                                              type="checkbox" ${param.plasmatv.equals("true") ? "checked=\"checked\"" : null}>TV
                                    al plasma</label>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div>
                        <div class="col-sm-3">
                            <form method="get">
                                <button type="submit" name="structureindex" value="<%=structureIndex%>"
                                        class="btn btn-primary">Inserisci
                                </button>
                            </form>
                        </div>
                        <div class="col-sm-3">
                            <form method="get" action="/management/managementLocation/location.jsp">
                                <button type="submit" name="structureindex" value="<%=structureIndex%>"
                                        class="btn btn-default">Annulla
                                </button>
                            </form>
                        </div>
                        <%--
                        <input name="submit" type="submit" onclick="submitForm('/management/managementLocation/locationJavaInsert.jsp')" value="Inserisci" class="btn btn-button" />
                        <input name="cancel" type="submit" onclick="submitForm('/management/managementLocation/location.jsp')" value="Annulla" class="btn btn-button" />
                        --%>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--
    <script>
        function submitForm(action)
        {
            document.getElementById('formLocation-form').action = action;
            document.getElementById('formLocation-form').submit();
        }
    </script>
    --%>

    <script>
        $(document).ready(function () {
            var start_date = $('input[name="startAvaibility"]');
            var end_date = $('input[name="endAvaibility"]');
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
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
    <script type="text/javascript">
        function mostraMessaggio() {
            window.alert("La locazione è stata inserita");
        }
    </script>

</div>
</body>