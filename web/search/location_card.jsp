<%--
  Created by IntelliJ IDEA.
  User: davidemagnanimi
  Date: 04/01/17
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%Integer locationIndex = Integer.valueOf(request.getParameter("location_index"));%>
<%int myFeedBack = -1;%>

    <div style="margin: 1%">
        <div class="row">
            <div class="col-sm-9" style="margin-top: 0.7%">
                <label><h4 class="list-group-item-heading">Nome della locazione</h4></label><%//TODO SISTEMARE IL NOME DELLA LOCAZIONE SUL DB%>
            </div>

            <div class="col-sm-3">
                <form action="/userCommunication/userCommunication.jsp">
                    <button type="submit" name="username_owner" value="<%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getOwner().getUsername()%>" hidden class="btn btn-default btn-block">Contatta</button>
                </form>
            </div>
        </div>
        <div class="row" style="padding-top: 2%">
            <div class="col-sm-9" style="display: inline-block; float: none; vertical-align: middle">
                <div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label>Caratteristiche:</label>
                            <ul type="disc">
                                <li>Stanze: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getNumOfRooms()%></li>
                                <li>Bagni: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getNumOfBath()%></li>
                                <li>Persone max.: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getNumMaxGuests()%></li>
                                <li>Letti: <%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getNumBeds()%></li>
                            </ul>
                        </div>
                        <div class="col-sm-8">
                            <label>Servizi:</label>
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul type="circle">
                                        <li>WiFi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isWifi() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>Animali ammessi: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isPetsAllowed() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>Servizio in camera: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isRoomService() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>Vista: <span class="glyphicon glyphicon-${param.view.equals("true") ? "ok":"remove"}" aria-hidden="true"></span></li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <ul type="circle">
                                        <li>Fumatori: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isSmokingRoom() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>Parcheggio: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isParking() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>Aria condizionata: <span class="glyphicon glyphicon-<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                        .getLocations().get(locationIndex).getService().isConditionedAir() ? "ok":"remove"%>" aria-hidden="true"></span></li>
                                        <li>TV al plasma: <span class="glyphicon glyphicon-${param.plasmatv.equals("true") ? "ok":"remove"}" aria-hidden="true"></span></li>
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
                                --><div class="col-sm-3" style="display: inline-block; float: none;">
            <div>
                <h1 align="center"><strong><%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                        .getLocations().get(locationIndex).getPrice()%><small><span class="glyphicon glyphicon-euro" aria-hidden="true"></span></small></strong></h1>
                <form method="get" action="../payment/payment.jsp">
                    <button type="submit" name="locationIndex" value="<%=locationIndex%>" class="btn btn-primary btn-block">Prenota ora!</button>
                </form>
            </div>
        </div>
        </div>
        <%if (structuresBean.getStructures().get(structuresBean.getStructureSelected())
                .getLocations().get(locationIndex).getFeedbacks().size() != 0){%>
        <label style="margin-top: 1%">Recensioni:</label>
        <div style="max-height: 200px; overflow-y: scroll;">
                <%for (int i = 0; i < structuresBean.getStructures().get(structuresBean.getStructureSelected())
                        .getLocations().get(locationIndex).getFeedbacks().size(); i++){
                    if (structuresBean.getStructures().get(structuresBean.getStructureSelected())
                            .getLocations().get(locationIndex).getFeedbacks().get(i).getUsername().equals("andrea.cifola")){
                        myFeedBack = i;
                        continue;
                    }
                %>
                <div class="well well-sm">
                    <label><small><%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                            .getLocations().get(locationIndex).getFeedbacks().get(i).getUsername()%></small></label>
                    <label style="margin-left: 2%"><small>
                        <% for (int star = 0; star < 5; star++){
                            if (star < structuresBean.getStructures().get(structuresBean.getStructureSelected())
                                    .getLocations().get(locationIndex).getFeedbacks().get(i).getRating()){%>
                        <span class="glyphicon glyphicon-star"></span>
                        <%} else {%>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <%}}%>
                    </small></label>
                    <p style="margin-bottom: 0; font-style: italic">"<%=structuresBean.getStructures().get(structuresBean.getStructureSelected())
                            .getLocations().get(locationIndex).getFeedbacks().get(i).getDescription()%>"</p>
                </div>
                <%}%>
            </div>
        <%}%>
        <label>La tua recensione:</label>
        <div class="form-group">
            <form method="get" action="/feedback/add_feedback.jsp">
                <div class="row">
                    <div class="col-sm-2" style="display: inline-block; float: none; vertical-align: middle">
                        <h6>Valutazione sintetica:</h6>
                    </div><!--Lasciare questo commento così com'è, influenza in qualche modo il rendering
                 --><div class="col-sm-10" style="display: inline-block; float: none;">
                        <label class="radio-inline">
                            <input type="radio" name="rating" value="1" <%=(myFeedBack != -1 && structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getRating() == 1) ? "checked=\"checked\"" : null%> style="margin-top: 2px"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="rating" value="2" <%=(myFeedBack != -1 && structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getRating() == 2) ? "checked=\"checked\"" : null%> style="margin-top: 2px"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="rating" value="3" <%=(myFeedBack != -1 && structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getRating() == 3) ? "checked=\"checked\"" : null%> style="margin-top: 2px"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="rating"  value="4" <%=(myFeedBack != -1 && structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getRating() == 4) ? "checked=\"checked\"" : null%> style="margin-top: 2px"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="rating"  value="5" <%=(myFeedBack != -1 && structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getRating() == 5) ? "checked=\"checked\"" : null%> style="margin-top: 2px"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span>
                        </label>
                    </div>
                </div>
                <div>
                    <h6>Descrivi la tua esperienza:</h6>
                    <textarea name="description" class="form-control" rows="4"><%=(myFeedBack != -1) ? structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getFeedbacks().get(myFeedBack).getDescription() : ""%></textarea>
                </div>
                <div class="row" style="margin-top: 1%">
                    <div class="col-sm-10"></div>
                    <div class="col-sm-2">
                        <button class="btn btn-default btn-block" name="locationID" hidden value="<%=structuresBean.getStructures().get(structuresBean.getStructureSelected()).getLocations().get(locationIndex).getId()%>" type="submit"><%=myFeedBack == -1 ? "Aggiungi":"Modifica"%></button>
                    </div>
                </div>
            </form>
        </div>
    </div>