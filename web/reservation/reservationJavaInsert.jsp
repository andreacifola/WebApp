<%@ page import="static model.language.filteredSearchResultStructure.FilteredSearchLanguage.fromDate" %>
<%@ page import="controller.ReservationController.ReservationController" %>
<%@ page import="model.User" %>
<%@ page import="model.insertNewLocation.Location" %>
<%@ page import="static model.language.filteredSearchResultStructure.FilteredSearchLanguage.toDate" %>
<%@ page import="java.util.Date" %>
Created by IntelliJ IDEA.
User: tizianoditoma
Date: 07/02/17
Time: 01:04
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%Integer structureIndex = Integer.valueOf(request.getParameter("structure_index"));%>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    User user = new User("Tiziano", "Ditoma", "Roma", "Via Regalbuto 36", new Date(2019 - 05 - 14), "tiziano.ditoma@gmail.com",
            "tiziano.ditoma", "9dbb300e28bc21c8dab41b01883918eb", "BR7724891749412660603618210F3");

    Location location = structuresBean.getStructures().get(structureIndex).getLocations().get(id);
    User owner = structuresBean.getStructures().get(structureIndex).getOwner();


    new ReservationController(location, user, owner, null, null);

    request.getRequestDispatcher("/search/search.jsp").forward(request, response);

%>