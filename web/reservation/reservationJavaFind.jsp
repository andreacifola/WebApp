<%@ page import="bean.ReservationListBean" %>
<%@ page import="controller.ReservationController.FindReservationByUsername" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 19/01/17
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    ReservationListBean reservations = new ReservationListBean();
    try {
        reservations.setReservations(new FindReservationByUsername().findReservationByUsername("tiziano.ditoma"));
        session.setAttribute("reservationBean", reservations);
    } catch (SQLException ibanCredentialNotValid) {
        ibanCredentialNotValid.printStackTrace();
    }

    request.getRequestDispatcher("/reservation/reservation.jsp").forward(request, response);

%>