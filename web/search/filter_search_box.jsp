<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel panel-default" style="position: fixed">
    <div class="panel-heading">
        <h3 class="panel-title">Inserisci valori di ricerca</h3>
    </div>
    <div class="panel-body" style="margin-bottom:-5%;">
        <form name="search-form" class="form-horizontal col-sm-12" method="post" action="./structure_search.jsp" onsubmit="return NomeCheck()"> <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6">
                        <label class="control-label">Data di inizio:</label>
                        <input name="start-date" value="${param.startdate}" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                    </div>
                    <div class="col-sm-6">
                        <label class="control-label">Data di fine:</label>
                        <input name="end-date" value="${param.enddate}" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                    </div>
                </div>
                <div class="row" >
                    <div class="col-sm-6">
                        <label class="control-label">Regione:</label>
                        <input name="region" value="${param.region}" type="text" class="form-control input-sm" placeholder="Inserisci la regione">
                    </div>
                    <div class="col-sm-6">
                        <label class="control-label">Citt&agrave:</label>
                        <input name="city" value="${param.city}" type="text" class="form-control input-sm" placeholder="Inserisci la città">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <label class="control-label">Nome struttura:</label>
                        <input name="structure" value="${param.structure}" type="text" class="form-control input-sm" placeholder="Inserisci la struttura">
                    </div>
                </div>
                <div class="row">
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
                            <option value="1" ${param.toilets.equals("1") ? "selected=\"selected\"" : null}>1</option>
                            <option value="2" ${param.toilets.equals("2") ? "selected=\"selected\"" : null}>2</option>
                            <option value="3" ${param.toilets.equals("3") ? "selected=\"selected\"" : null}>3</option>
                            <option value="4" ${param.toilets.equals("4") ? "selected=\"selected\"" : null}>4</option>
                            <option value="5" ${param.toilets.equals("5") ? "selected=\"selected\"" : null}>5</option>
                            <option value="6" ${param.toilets.equals("6") ? "selected=\"selected\"" : null}>6</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label class="control-label">Persone:</label>
                        <select name="people" class="form-control input-sm" title="people-select">
                            <option value="1" ${param.people.equals("1") ? "selected=\"selected\"" : null}>1</option>
                            <option value="2" ${param.people.equals("2") ? "selected=\"selected\"" : null}>2</option>
                            <option value="3" ${param.people.equals("3") ? "selected=\"selected\"" : null}>3</option>
                            <option value="4" ${param.people.equals("4") ? "selected=\"selected\"" : null}>4</option>
                            <option value="5" ${param.people.equals("5") ? "selected=\"selected\"" : null}>5</option>
                            <option value="6" ${param.people.equals("6") ? "selected=\"selected\"" : null}>6</option>
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
                </div>
                <div class="row" style="margin-top: 8%; margin-bottom: 5%">
                    <div class="col-sm-12">
                        <label class="control-label" style="margin-right: 1%">Prezzo massimo:</label>
                        <input name="price" data-provide="slider" type="text"
                               data-slider-tooltip="always" data-slider-min="0" data-slider-max="200"
                               data-slider-step="5" data-slider-value="${param.price == null ? 75 : param.price}" title="price"/>

                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="checkbox">
                            <label><input name="wifi" type="checkbox" ${param.wifi.equals("true") ? "checked=\"checked\"" : null}>WiFi</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="animals" type="checkbox" ${param.animals.equals("true") ? "checked=\"checked\"" : null}>Animali ammessi</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="room-service" type="checkbox" ${param.roomservice.equals("true") ? "checked=\"checked\"" : null}>Servizio in camera</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="view" type="checkbox" ${param.view.equals("true") ? "checked=\"checked\"" : null}>Vista panoramica</label>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="checkbox">
                            <label><input name="smoking" type="checkbox" ${param.smoking.equals("true") ? "checked=\"checked\"" : null}>Stanza per fumatori</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="parking" type="checkbox" ${param.parking.equals("true") ? "checked=\"checked\"" : null}>Area parcheggio</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="conditioned-air" type="checkbox" ${param.conditionedair.equals("true") ? "checked=\"checked\"" : null}>Area condizionata</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="plasma-tv" type="checkbox" ${param.plasmatv.equals("true") ? "checked=\"checked\"" : null}>TV al plasma</label>
                        </div>
                    </div>
                </div>
                <div class="row" style="text-align: center">
                    <button type="submit" class="btn btn-primary" style="margin-top:5%;">Cerca</button>
                </div>
            </div>
        </form>
    </div>
</div>

