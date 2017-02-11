<%@ page import="bean.StructureListBean" %>
<%@ page import="controller.insertLocationController.FindStructureByUsername" %>
<jsp:useBean id="logged_user" scope="session" class="model.User"/>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>


<% StructureListBean structures = new StructureListBean();
    try {
        structures.setStructures(new FindStructureByUsername().findStructureByUsername(logged_user.getUsername()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    session.setAttribute("structuresBean", structures);

    request.getRequestDispatcher("/management/managementStructure/structure.jsp").forward(request, response);
%>