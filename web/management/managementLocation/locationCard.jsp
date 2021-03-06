<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%Integer locationIndex = Integer.valueOf(request.getParameter("location_index"));%>

<div style="margin: 1%">
    <div class="row" style="text-align: match-parent">
        <div class="col-sm-8" style="margin-top: 0.7%">
            <label><h4 class="list-group-item-heading">Nome della locazione</h4>
            </label><%//TODO SISTEMARE IL NOME DELLA LOCAZIONE SUL DB%>
        </div>
    </div>
    <div class="row" style="padding-top: 0.5%">
        <div class="col-sm-9" style="display: inline-block; float: none; vertical-align: middle">
            <div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Caratteristiche:</label>
                        <ul type="disc">
                            <li>Stanze: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(locationIndex).getNumOfRooms()%>
                            </li>
                            <li>Bagni: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(locationIndex).getNumOfBath()%>
                            </li>
                            <li>Persone
                                max.: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(locationIndex).getNumMaxGuests()%>
                            </li>
                            <li>Letti: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(locationIndex).getNumBeds()%>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-8">
                        <label>Servizi:</label>
                        <div class="row">
                            <div class="col-sm-6">
                                <ul type="circle">
                                    <li>WiFi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isWifi() ? "ok":"remove"%>"
                                                    aria-hidden="true"></span></li>
                                    <li>Animali ammessi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isPetsAllowed() ? "ok":"remove"%>"
                                                               aria-hidden="true"></span></li>
                                    <li>Servizio in camera: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isRoomService() ? "ok":"remove"%>"
                                                                  aria-hidden="true"></span></li>
                                    <li>Vista: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isViews() ? "ok":"remove"%>"
                                                     aria-hidden="true"></span></li>
                                </ul>
                            </div>
                            <div class="col-sm-6">
                                <ul type="circle">
                                    <li>Fumatori: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isSmokingRoom() ? "ok":"remove"%>"
                                                        aria-hidden="true"></span></li>
                                    <li>Parcheggio: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isParking() ? "ok":"remove"%>"
                                                          aria-hidden="true"></span></li>
                                    <li>Aria condizionata: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isConditionedAir() ? "ok":"remove"%>"
                                                                 aria-hidden="true"></span></li>
                                    <li>Tv al plasma: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isPlasmaTv() ? "ok":"remove"%>"
                                                            aria-hidden="true"></span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <label>Descrizione:</label>
                <p class="list-group-item-text" align="justify">
                    <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                            .getLocations().get(locationIndex).getDescription()%>
                </p>
            </div>
        </div><!--Lasciare questo commento così com'è, influenza in qualche modo il rendering
                                -->
        <div class="col-sm-3" style="display: inline-block; float: none;">
            <div class="caption" align="right">
                <%--
                <form method="get" action="/management/managementLocation/formLocation.jsp">
                    <button type="submit" name="structureindex" value="<%=structureIndex%>" class="btn btn-primary"> Dettagli  </button>
                </form>
                --%>
                <form method="get" action="/modifyLocation/modifyLocation.jsp">
                    <button type="submit" name="locationIndex" value="<%=locationIndex%>" class="btn btn-primary">
                        Modifica
                    </button>
                </form>
                <form method="get" action="">
                    <button type="submit" name="structureindex" value="<%=structuresBean.getStructureSelected()%>"
                            class="btn btn-primary">
                        Cancella
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
