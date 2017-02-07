<%@ page import="controller.insertLocationController.InsertNewLocationController" %>
<%@ page import="model.insertNewLocation.Service" %><%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 17/01/17
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Integer structureIndex = Integer.valueOf(request.getParameter("structureindex"));%>

<%
    String descripton = request.getParameter("description"),
            startAvaibility = request.getParameter("startAvaibility"),
            endAvaibility = request.getParameter("endAvaibility");
    Integer rooms = Integer.valueOf(request.getParameter("rooms")),
            toilets = Integer.valueOf(request.getParameter("toilets")),
            people = Integer.valueOf(request.getParameter("people")),
            beds = Integer.valueOf(request.getParameter("beds")),
            price = Integer.valueOf(request.getParameter("price"));
    Boolean wifi = (request.getParameter("wifi") != null) ? Boolean.TRUE : Boolean.FALSE,
            animals = (request.getParameter("animals") != null) ? Boolean.TRUE : Boolean.FALSE,
            roomService = (request.getParameter("room-service") != null) ? Boolean.TRUE : Boolean.FALSE,
            view = (request.getParameter("view") != null) ? Boolean.TRUE : Boolean.FALSE,
            smoking = (request.getParameter("smoking") != null) ? Boolean.TRUE : Boolean.FALSE,
            parking = (request.getParameter("parking") != null) ? Boolean.TRUE : Boolean.FALSE,
            conditionedAir = (request.getParameter("conditioned-air") != null) ? Boolean.TRUE : Boolean.FALSE,
            plasmaTv = (request.getParameter("plasma-tv") != null) ? Boolean.TRUE : Boolean.FALSE;

    Service service = new Service(wifi, smoking, animals, parking, roomService, conditionedAir, view, plasmaTv);

    InsertNewLocationController.addNewLocation(descripton, String.valueOf(rooms), String.valueOf(toilets), String.valueOf(people),
            String.valueOf(beds), String.valueOf(price), null, null, service, structureIndex);

    request.getRequestDispatcher("/management/managementLocation/location.jsp").forward(request, response);


%>