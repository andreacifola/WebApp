<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<html>
<head>
    <title>Gestisci locazione</title>

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

    <script src="ModifyLocationControl.js"></script>

</head>
<body>
<jsp:include page="../navigation_bar.jsp"/>
<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title" style="text-align:center">Inserisci i valori da modificare</h3>
            </div>
            <div class="panel-body" style="margin-bottom:-5%;">
                <form name="search-form" class="form-horizontal col-sm-12" method="post"
                      action="modify_data_location.jsp" onsubmit="return validateManag(this)">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-10">
                                <label class="control-label">Descrizione:</label>
                                <!-- Lasciare così la textarea altrimenti introduce spazi bianchi misteriosi-->
                                <textarea name="description" class="form-control" rows="5" id="descr"
                                          style="resize:none;"><%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getDescription()%></textarea>
                            </div>
                            <div class="col-sm-1"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-10">
                                <div class="col-sm-3">
                                    <label class="control-label">Stanze:</label>
                                    <select name="rooms" class="form-control input-sm" title="rooms-select">
                                        <option value="1" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 1 ? "selected=\"selected\"" : null%>>
                                            1
                                        </option>
                                        <option value="2" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 2 ? "selected=\"selected\"" : null%>>
                                            2
                                        </option>
                                        <option value="3" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 3 ? "selected=\"selected\"" : null%>>
                                            3
                                        </option>
                                        <option value="4" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 4 ? "selected=\"selected\"" : null%>>
                                            4
                                        </option>
                                        <option value="5" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 5 ? "selected=\"selected\"" : null%>>
                                            5
                                        </option>
                                        <option value="6" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfRooms() == 6 ? "selected=\"selected\"" : null%>>
                                            6
                                        </option>
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <label class="control-label">Bagni:</label>
                                    <select name="toilets" class="form-control input-sm" title="toilets-select">
                                        <option value="1" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 1 ? "selected=\"selected\"" : null%>>
                                            1
                                        </option>
                                        <option value="2" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 2 ? "selected=\"selected\"" : null%>>
                                            2
                                        </option>
                                        <option value="3" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 3 ? "selected=\"selected\"" : null%>>
                                            3
                                        </option>
                                        <option value="4" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 4 ? "selected=\"selected\"" : null%>>
                                            4
                                        </option>
                                        <option value="5" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 5 ? "selected=\"selected\"" : null%>>
                                            5
                                        </option>
                                        <option value="6" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumOfBath() == 6 ? "selected=\"selected\"" : null%>>
                                            6
                                        </option>
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <label class="control-label">Persone:</label>
                                    <select name="people" class="form-control input-sm" title="people-select">
                                        <option value="1" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 1 ? "selected=\"selected\"" : null%>>
                                            1
                                        </option>
                                        <option value="2" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 2 ? "selected=\"selected\"" : null%>>
                                            2
                                        </option>
                                        <option value="3" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 3 ? "selected=\"selected\"" : null%>>
                                            3
                                        </option>
                                        <option value="4" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 4 ? "selected=\"selected\"" : null%>>
                                            4
                                        </option>
                                        <option value="5" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 5 ? "selected=\"selected\"" : null%>>
                                            5
                                        </option>
                                        <option value="6" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumMaxGuests() == 6 ? "selected=\"selected\"" : null%>>
                                            6
                                        </option>
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <label class="control-label">Letti:</label>
                                    <select name="beds" class="form-control input-sm" title="beds-select">
                                        <option value="1" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 1 ? "selected=\"selected\"" : null%>>
                                            1
                                        </option>
                                        <option value="2" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 2 ? "selected=\"selected\"" : null%>>
                                            2
                                        </option>
                                        <option value="3" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 3 ? "selected=\"selected\"" : null%>>
                                            3
                                        </option>
                                        <option value="4" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 4 ? "selected=\"selected\"" : null%>>
                                            4
                                        </option>
                                        <option value="5" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 5 ? "selected=\"selected\"" : null%>>
                                            5
                                        </option>
                                        <option value="6" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getNumBeds() == 6 ? "selected=\"selected\"" : null%>>
                                            6
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-1"></div>
                        </div>
                        <div class="col-sm-0.5"></div>
                        <div class="col-sm-11">
                            <div class="row" style="margin-top: 8%; margin-bottom: 5%">
                                <div class="col-sm-12">
                                    <label class="control-label" style="margin-right: 5%">Prezzo massimo:</label>
                                    <input name="price" value="<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(structuresBean.getLocationSelected()).getPrice()%>"
                                           data-provide="slider" type="text"
                                           data-slider-tootip="none" data-slider-min="0" data-slider-max="200"
                                           data-slider-step="5" data-slider-value="100" title="price"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-0.5"></div>
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="wifi"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isWifi() ? "checked=\"checked\"" : null%>>WiFi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="animals"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isPetsAllowed() ? "checked=\"checked\"" : null%>>Animali
                                    ammessi</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="room-service"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isRoomService() ? "checked=\"checked\"" : null%>>Servizio
                                    in
                                    camera</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="view"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isViews() ? "checked=\"checked\"" : null%>>Vista
                                    panoramica</label>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="checkbox">
                                <label><input name="smoking"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isSmokingRoom() ? "checked=\"checked\"" : null%>>Stanza
                                    per
                                    fumatori</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="parking"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isParking() ? "checked=\"checked\"" : null%>>Area
                                    parcheggio</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="conditioned-air"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isConditionedAir() ? "checked=\"checked\"" : null%>>Area
                                    condizionata</label>
                            </div>
                            <div class="checkbox">
                                <label><input name="plasma-tv"
                                              type="checkbox" <%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(structuresBean.getLocationSelected()).getService().isPlasmaTv() ? "checked=\"checked\"" : null%>>TV
                                    al
                                    plasma</label>
                            </div>
                        </div>
                        <div style="text-align: center">
                            <button type="reset" class="btn btn-default" onclick="history.go(-1)"
                                    style="margin-top:5%;">Annulla
                            </button>
                            <button type="submit" class="btn btn-default" style="margin-top:5%;">Aggiorna</button>
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