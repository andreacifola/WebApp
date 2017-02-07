<%@ page import="controller.insertStructureController.InsertNewStructureController" %><%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 17/01/17
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name"),
            region = request.getParameter("region"),
            city = request.getParameter("city"),
            address = request.getParameter("address"),
            owner = request.getParameter("owner"),
            desciption = request.getParameter("description");
    Integer numHouse = Integer.valueOf(request.getParameter("numHouse")),
            CAP = Integer.valueOf(request.getParameter("CAP"));

    InsertNewStructureController.addNewStructure(name, owner, desciption, region, city, address, numHouse, CAP);

    request.getRequestDispatcher("/management/managementStructure/structure.jsp").forward(request, response);

%>
