<jsp:include page="navigationBar.jsp"/>
    <div class="container-fluid">
        <h2 align="center">Ricerca filtrata</h2>
        <form name="search-form" class="form-horizontal col-sm-4" method="get" action="/results" onsubmit="return NomeCheck()"> <!-- style="background-color: rgba(36,154,96,0.55); border-radius: 2%;"> -->
            <br>
            <div class="form-group">
                <div class="col-sm-4" align="left">
                    <label class="control-label">Data di inizio:</label>
                </div>
                <div class="col-sm-8" align="right">
                        <input name="start-date" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                </div>
            </div>
            <div class="form-group">
                    <div class="col-sm-4" align="left">
                        <label class="control-label">Data di fine:</label>
                    </div>
                    <div class="col-sm-8" align="right">
                        <input name="end-date" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                    </div>
                </div>
            <div class="form-group" >
                    <div class="col-sm-4" align="left">
                        <label class="control-label">Regione:</label>
                    </div>
                    <div class="col-sm-8" align="right">
                        <input name="region" type="text" class="form-control input-sm" placeholder="Inserisci la regione">
                    </div>
                </div>
            <div class="form-group">
                    <div class="col-sm-4" align="left">
                        <label class="control-label">Citt&agrave:</label>
                    </div>
                    <div class="col-sm-8" align="right">
                        <input name="city" type="text" class="form-control input-sm" placeholder="Inserisci la città">
                    </div>
                </div>
            <div class="form-group">
                    <div class="col-sm-4" align="left">
                        <label class="control-label">Nome struttura:</label>
                    </div>
                    <div class="col-sm-8" align="right">
                        <input name="structure" type="text" class="form-control input-sm" placeholder="Inserisci la struttura">
                    </div>
                </div>
            <div class="form-group">
                    <div class="col-sm-8" align="left">
                        <label class="control-label">Numero di stanze:</label>
                    </div>
                    <div class="col-sm-4" align="right">
                        <select name="rooms" class="form-control input-sm" title="rooms-select">
                            <option value="1" selected="selected">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>
                    </div>
            </div>
            <div class="form-group">
                    <div class="col-sm-8" align="legt">
                        <label class="control-label">Numero di bagni:</label>
                    </div>
                    <div class="col-sm-4" align="right">
                        <select name="toilets" class="form-control input-sm" title="toilets-select">
                            <option value="1" selected="selected">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>
                    </div>
                </div>
            <div class="form-group">
                    <div class="col-sm-8" align="left">
                        <label class="control-label">Numero di persone:</label>
                    </div>
                    <div class="col-sm-4" align="right">
                        <select name="people" class="form-control input-sm" title="people-select">
                            <option value="1" selected="selected">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>
                    </div>
                </div>
            <div class="form-group">
                <div class="col-sm-8" align="left">
                        <label class="control-label">Numero di posti letto:</label>
                    </div>
                <div class="col-sm-4" align="right">
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
            <div class="form-group">
                <div class="col-sm-8" align="left">
                    <label class="control-label">Prezzo massimo:</label>
                </div>
                <div class="col-sm-4" align="right">
                    <input name="price" type="number" class="form-control input-sm" value="50" max="1000" min="10" title="price-input">
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
            <br>
        </form>

        <div class="col-sm-8">
            <!--<div class="input-group">
                <span class="input-group-btn">
                        <button type="button" class="btn btn-default" data-value="decrease" data-target="#spinner" data-toggle="spinner">
                            <span class="glyphicon glyphicon-minus"></span>
                        </button>
                </span>
                <input type="text" data-ride="spinner" id="spinner" class="form-control input-number" value="1" data-min="1">
                <span class="input-group-btn">
                    <button type="button" class="btn btn-default" data-value="increase" data-target="#spinner" data-toggle="spinner" data-on="mousehold">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </span>
            </div>-->
        </div>
    </div>
