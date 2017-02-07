<%@ page import="controller.managementLocationController.ManagementLocationController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String description = request.getParameter("description");

    Integer rooms = Integer.valueOf(request.getParameter("rooms"));
    Integer toilets = Integer.valueOf(request.getParameter("toilets"));
    Integer people = Integer.valueOf(request.getParameter("people"));
    Integer beds = Integer.valueOf(request.getParameter("beds"));
    Double price = Double.valueOf(request.getParameter("price"));

    Boolean wifi = (request.getParameter("wifi") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean animals = (request.getParameter("animals") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean roomService = (request.getParameter("room-service") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean view = (request.getParameter("view") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean smoking = (request.getParameter("smoking") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean parking = (request.getParameter("parking") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean conditionedAir = (request.getParameter("conditioned-air") != null) ? Boolean.TRUE : Boolean.FALSE;
    Boolean plasmaTv = (request.getParameter("plasma-tv") != null) ? Boolean.TRUE : Boolean.FALSE;

    //TODO prendere tutti i dati dal caso d'uso di Tiziano

    try {
        ManagementLocationController mlc = new ManagementLocationController();
        //TODO sostituire 1 con id (che cosa è che non mi ricordo???)
        mlc.modifyLocation(2, description, rooms, toilets, people, beds, price, wifi, animals,
                roomService, view, smoking, parking, conditionedAir, plasmaTv);

        //TODO rimandare alla pagina precedente
        request.getRequestDispatcher("../registration/registration.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
