<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="filters" class="bean.FilterSearchBean" scope="request">
    <jsp:setProperty name="filters" property="*"/>
</jsp:useBean>

<div class="panel panel-default" style="position: fixed">
    <div class="panel-heading">
        <h3 class="panel-title">Inserisci valori di ricerca</h3>
    </div>
    <div class="panel-body" style="margin-bottom:-5%;">
        <form name="search-form" class="form-horizontal col-sm-12" method="post" action="/search/structure_search.jsp" onsubmit="return validateSearchFilters(this)">
            <div class="form-group">
                <div class="row">
                    <div class="col-sm-6">
                        <label class="control-label">Data di inizio:</label>
                        <input name="start_date" value="<%=filters.getStart_date()%>" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                    </div>
                    <div class="col-sm-6">
                        <label class="control-label">Data di fine:</label>
                        <input name="end_date" value="<%=filters.getEnd_date()%>" type="text" class="form-control input-sm" placeholder="GG-MM-AAAA">
                    </div>
                </div>
                <div class="row" >
                    <div class="col-sm-6">
                        <label class="control-label">Regione:</label>
                        <input name="region" value="<%=filters.getRegion()%>" type="text" class="form-control input-sm" placeholder="Inserisci la regione">
                    </div>
                    <div class="col-sm-6">
                        <label class="control-label">Citt&agrave:</label>
                        <input name="city" value="<%=filters.getCity()%>" type="text" class="form-control input-sm" placeholder="Inserisci la città">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <label class="control-label">Nome struttura:</label>
                        <input name="structure" value="<%=filters.getStructure()%>" type="text" class="form-control input-sm" placeholder="Inserisci la struttura">
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3">
                        <label class="control-label">Stanze:</label>
                        <select name="rooms" class="form-control input-sm" title="rooms-select">
                            <option value="1" <%=filters.getRooms() == 1 ? "selected=\"selected\"" : null%>>1</option>
                            <option value="2" <%=filters.getRooms() == 2 ? "selected=\"selected\"" : null%>>2</option>
                            <option value="3" <%=filters.getRooms() == 3 ? "selected=\"selected\"" : null%>>3</option>
                            <option value="4" <%=filters.getRooms() == 4 ? "selected=\"selected\"" : null%>>4</option>
                            <option value="5" <%=filters.getRooms() == 5 ? "selected=\"selected\"" : null%>>5</option>
                            <option value="6" <%=filters.getRooms() == 6 ? "selected=\"selected\"" : null%>>6</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label class="control-label">Bagni:</label>
                        <select name="baths" class="form-control input-sm" title="toilets-select">
                            <option value="1" <%=filters.getBaths() == 1 ? "selected=\"selected\"" : null%>>1</option>
                            <option value="2" <%=filters.getBaths() == 2 ? "selected=\"selected\"" : null%>>2</option>
                            <option value="3" <%=filters.getBaths() == 3 ? "selected=\"selected\"" : null%>>3</option>
                            <option value="4" <%=filters.getBaths() == 4 ? "selected=\"selected\"" : null%>>4</option>
                            <option value="5" <%=filters.getBaths() == 5 ? "selected=\"selected\"" : null%>>5</option>
                            <option value="6" <%=filters.getBaths() == 6 ? "selected=\"selected\"" : null%>>6</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label class="control-label">Persone:</label>
                        <select name="guests" class="form-control input-sm" title="people-select">
                            <option value="1" <%=filters.getGuests() == 1 ? "selected=\"selected\"" : null%>>1</option>
                            <option value="2" <%=filters.getGuests() == 2 ? "selected=\"selected\"" : null%>>2</option>
                            <option value="3" <%=filters.getGuests() == 3 ? "selected=\"selected\"" : null%>>3</option>
                            <option value="4" <%=filters.getGuests() == 4 ? "selected=\"selected\"" : null%>>4</option>
                            <option value="5" <%=filters.getGuests() == 5 ? "selected=\"selected\"" : null%>>5</option>
                            <option value="6" <%=filters.getGuests() == 6 ? "selected=\"selected\"" : null%>>6</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <label class="control-label">Letti:</label>
                        <select name="beds" class="form-control input-sm" title="beds-select">
                            <option value="1" <%=filters.getBeds() == 1 ? "selected=\"selected\"" : null%>>1</option>
                            <option value="2" <%=filters.getBeds() == 2 ? "selected=\"selected\"" : null%>>2</option>
                            <option value="3" <%=filters.getBeds() == 3 ? "selected=\"selected\"" : null%>>3</option>
                            <option value="4" <%=filters.getBeds() == 4 ? "selected=\"selected\"" : null%>>4</option>
                            <option value="5" <%=filters.getBeds() == 5 ? "selected=\"selected\"" : null%>>5</option>
                            <option value="6" <%=filters.getBeds() == 6 ? "selected=\"selected\"" : null%>>6</option>
                        </select>
                    </div>
                </div>
                <div class="row" style="margin-top: 8%; margin-bottom: 5%">
                    <div class="col-sm-12">
                        <label class="control-label" style="margin-right: 1%">Prezzo massimo:</label>
                        <input name="price" data-provide="slider" type="text"
                               data-slider-tooltip="always" data-slider-min="0" data-slider-max="200"
                               data-slider-step="5" data-slider-value="<%=filters.getPrice()%>" title="price"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="checkbox">
                            <label><input name="wifi" type="checkbox" <%=filters.getWifi() ? "checked=\"checked\"" : null%>>WiFi</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="pets" type="checkbox" <%=filters.getPets() ? "checked=\"checked\"" : null%>>Animali ammessi</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="room_service" type="checkbox" <%=filters.getRoom_service() ? "checked=\"checked\"" : null%>>Servizio in camera</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="view" type="checkbox" <%=filters.getView() ? "checked=\"checked\"" : null%>>Vista panoramica</label>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="checkbox">
                            <label><input name="smoking" type="checkbox" <%=filters.getSmoking() ? "checked=\"checked\"" : null%>>Stanza per fumatori</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="parking" type="checkbox" <%=filters.getParking() ? "checked=\"checked\"" : null%>>Area parcheggio</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="conditioned_air" type="checkbox" <%=filters.getConditioned_air() ? "checked=\"checked\"" : null%>>Area condizionata</label>
                        </div>
                        <div class="checkbox">
                            <label><input name="plasma_tv" type="checkbox" <%=filters.getPlasma_tv() ? "checked=\"checked\"" : null%>>TV al plasma</label>
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

<script>
    $(document).ready(function(){
        var start_date=$('input[name="start_date"]');
        var end_date=$('input[name="end_date"]');
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
