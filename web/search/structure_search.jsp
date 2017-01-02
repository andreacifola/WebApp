<%@ page import="model.insertNewLocation.Structure" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.filteredSearch.FilteredSearchController" %>
<%@ page import="model.payment.IBANCredentialNotValid" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<%
    String startDate = request.getParameter("start-date"),
            endDate = request.getParameter("end-date"),
            region = request.getParameter("region"),
            city = request.getParameter("city"),
            structure = request.getParameter("structure");
    Integer rooms = Integer.valueOf(request.getParameter("rooms")),
            toilets = Integer.valueOf(request.getParameter("toilets")),
            people = Integer.valueOf(request.getParameter("people")),
            beds = Integer.valueOf(request.getParameter("beds")),
            price = Integer.valueOf(request.getParameter("price"));
    Boolean wifi = (request.getParameter("wifi") != null) ? Boolean.TRUE: Boolean.FALSE,
            animals = (request.getParameter("animals") != null) ? Boolean.TRUE: Boolean.FALSE,
            roomService = (request.getParameter("room-service") != null) ? Boolean.TRUE: Boolean.FALSE,
            view = (request.getParameter("view") != null) ? Boolean.TRUE: Boolean.FALSE,
            smoking = (request.getParameter("smoking") != null) ? Boolean.TRUE: Boolean.FALSE,
            parking = (request.getParameter("parking") != null) ? Boolean.TRUE: Boolean.FALSE,
            conditionedAir = (request.getParameter("conditioned-air") != null) ? Boolean.TRUE: Boolean.FALSE,
            plasmaTv = (request.getParameter("plasma-tv") != null) ? Boolean.TRUE: Boolean.FALSE;

    HashMap<String, Object> filters = new HashMap<String, Object>();
    filters.put("start-date",startDate);
    filters.put("end-date",endDate);
    filters.put("region",region);
    filters.put("city",city);
    filters.put("structure",structure);
    filters.put("rooms",rooms);
    filters.put("toilets",toilets);
    filters.put("people",people);
    filters.put("beds",beds);
    filters.put("price",price);
    filters.put("wifi",wifi);
    filters.put("animals",animals);
    filters.put("room-service",roomService);
    filters.put("view",view);
    filters.put("smoking",smoking);
    filters.put("parking",parking);
    filters.put("conditioned-air",conditionedAir);
    filters.put("plasma-tv",plasmaTv);

    request.setAttribute("filters", filters);

    try {
        ArrayList<Structure> s = new FilteredSearchController().startResearch(null,null, region, city, structure,rooms,toilets,
                people,beds,price,wifi,smoking,animals,parking,roomService,conditionedAir,view,plasmaTv);
        request.setAttribute("structure_list",s);
    } catch (IBANCredentialNotValid | SQLException ibanCredentialNotValid) {
        ibanCredentialNotValid.printStackTrace();
    }


    request.getRequestDispatcher("search.jsp").forward(request,response);
%>