<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 16/01/17
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<jsp:useBean id="reservationBean" scope="session" class="bean.ReservationListBean"/>
<%Integer reservationIndex = Integer.valueOf(request.getParameter("reservationIndex"));%>


<div class="caption" style="margin-right: -0.7%">
    <div class="col-sm-10" style="display: inline-block; float: none; vertical-align: middle">
        <div class="row" style="text-align: center">
            <label><h2 class="card-title" style="text-align: center"> Prenotazione </h2>
                <h2><%="Locazione n° " + reservationBean.getReservations().get(reservationIndex).getIdLocation() %>
                </h2></label>
        </div>
        <div class="row">
            <label style="margin-left: 15%"><h4><%= "Data di inizio: "%>
            </h4>
                <h5><%=reservationBean.getReservations().get(reservationIndex).getFromDate().toString() %>
                </h5></label>
            <label style="margin-left: 30%"><h4><%= "Data di fine: "%>
            </h4>
                <h5><%=reservationBean.getReservations().get(reservationIndex).getToDate().toString() %>
                </h5></label>
        </div>
    </div>
    <div class="row" style="display: inline-block; float: none;" style="text-align: right; horiz-align: right">
        <form method="get" action="">
            <button type="submit" name="reservationIndex" value="<%=reservationIndex%>" class="btn btn-primary">
                Prenotazione
            </button>
        </form>
    </div>
</div>