<%--
  Created by IntelliJ IDEA.
  User: davidemagnanimi
  Date: 04/01/17
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%Integer structureIndex = Integer.valueOf(request.getParameter("structure_index"));%>
<%Integer locationIndex = Integer.valueOf(request.getParameter("location_index"));%>


<div style="margin: 1%">
    <div class="row">
        <div class="col-sm-8" style="margin-top: 0.7%">
            <label><h4 class="list-group-item-heading">Nome della locazione</h4>
            </label><%//TODO SISTEMARE IL NOME DELLA LOCAZIONE SUL DB%>
            <label style="margin-left: 5%">
                <% for (int i = 0; i < 5; i++) {
                    if (i < 3) { //TODO SISTEMARE IL NUMERO DI STELLE (AD ES INSERIRE IL VALORE MEDIO DELLE STELLE NEGLI ATTRIBUTI DELLA LOCAZIONE%>
                <span class="glyphicon glyphicon-star"></span>
                <%} else {%>
                <span class="glyphicon glyphicon-star-empty"></span>
                <%
                        }
                    }
                %>
            </label>
        </div>
        <div class="col-sm-2">
            <button type="button" class="btn btn-default btn-block">Recensisci</button>
        </div>
        <div class="col-sm-2">
            <button type="button" class="btn btn-default btn-block">Contatta</button>
        </div>
    </div>
    <div class="row" style="padding-top: 2%">
        <div class="col-sm-9" style="display: inline-block; float: none; vertical-align: middle">
            <div>
                <div class="row">
                    <div class="col-sm-4">
                        <label>Caratteristiche:</label>
                        <ul type="disc">
                            <li>Stanze: <%=structuresBean.getStructures().get(structureIndex)
                                    .getLocations().get(locationIndex).getNumOfRooms()%>
                            </li>
                            <li>Bagni: <%=structuresBean.getStructures().get(structureIndex)
                                    .getLocations().get(locationIndex).getNumOfBath()%>
                            </li>
                            <li>Persone max.: <%=structuresBean.getStructures().get(structureIndex)
                                    .getLocations().get(locationIndex).getNumMaxGuests()%>
                            </li>
                            <li>Letti: <%=structuresBean.getStructures().get(structureIndex)
                                    .getLocations().get(locationIndex).getNumBeds()%>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-8">
                        <label>Servizi:</label>
                        <div class="row">
                            <div class="col-sm-6">
                                <ul type="circle">
                                    <li>WiFi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isWifi() ? "ok":"remove"%>"
                                                    aria-hidden="true"></span></li>
                                    <li>Animali ammessi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isPetsAllowed() ? "ok":"remove"%>"
                                                               aria-hidden="true"></span></li>
                                    <li>Servizio in camera: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isRoomService() ? "ok":"remove"%>"
                                                                  aria-hidden="true"></span></li>
                                    <li>Vista: <span
                                            class="glyphicon glyphicon-${param.view.equals("true") ? "ok":"remove"}"
                                            aria-hidden="true"></span></li>
                                </ul>
                            </div>
                            <div class="col-sm-6">
                                <ul type="circle">
                                    <li>Fumatori: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isSmokingRoom() ? "ok":"remove"%>"
                                                        aria-hidden="true"></span></li>
                                    <li>Parcheggio: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isParking() ? "ok":"remove"%>"
                                                          aria-hidden="true"></span></li>
                                    <li>Aria condizionata: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structureIndex)
                                        .getLocations().get(locationIndex).getService().isConditionedAir() ? "ok":"remove"%>"
                                                                 aria-hidden="true"></span></li>
                                    <li>TV al plasma: <span
                                            class="glyphicon glyphicon-${param.plasmatv.equals("true") ? "ok":"remove"}"
                                            aria-hidden="true"></span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <label>Descrizione:</label>
                <p class="list-group-item-text" align="justify">
                    <%=structuresBean.getStructures().get(structureIndex)
                            .getLocations().get(locationIndex).getDescription()%>
                </p>
            </div>
        </div><!--Lasciare questo commento così com'è, influenza in qualche modo il rendering
                                -->
        <div class="col-sm-3" style="display: inline-block; float: none;">
            <div>
                <h1 align="center"><strong><%=structuresBean.getStructures().get(structureIndex)
                        .getLocations().get(locationIndex).getPrice()%>
                    <small><span class="glyphicon glyphicon-euro" aria-hidden="true"></span></small>
                </strong></h1>
                <form method="get" action="/reservation/reservationJavaInsert.jsp">
                    <button type="submit" name="select" value="${param.id}" class="btn btn-primary btn-block">Acquista
                    </button>
                </form>
                <%--
                <form method="get" action="../payment/checkout.jsp">
                    <button type="submit" name="select" value="${param.id}" class="btn btn-primary btn-block">Acquista</button>
                </form>
                --%>
            </div>
        </div>
    </div>
    <label style="margin-top: 1%">Recensioni:</label>
    <div style="max-height: 200px; overflow-y: scroll;">
        <%
            for (int i = 0; i < structuresBean.getStructures().get(structureIndex)
                    .getLocations().get(locationIndex).getFeedbacks().size(); i++) {
        %>
        <div class="well well-sm">
            <label>
                <small><%=structuresBean.getStructures().get(structureIndex)
                        .getLocations().get(locationIndex).getFeedbacks().get(i).getUsername()%>
                </small>
            </label>
            <label style="margin-left: 2%">
                <small>
                    <% for (int star = 0; star < 5; star++) {
                        if (star < structuresBean.getStructures().get(structureIndex)
                                .getLocations().get(locationIndex).getFeedbacks().get(i).getRating()) {%>
                    <span class="glyphicon glyphicon-star"></span>
                    <%} else {%>
                    <span class="glyphicon glyphicon-star-empty"></span>
                    <%
                            }
                        }
                    %>
                </small>
            </label>
            <p style="margin-bottom: 0; font-style: italic">"<%=structuresBean.getStructures().get(structureIndex)
                    .getLocations().get(locationIndex).getFeedbacks().get(i).getDescription()%>"</p>
        </div>
        <%}%>
    </div>
</div>