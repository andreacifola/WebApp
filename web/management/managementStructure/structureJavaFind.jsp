<%@ page import="bean.StructureListBean" %>
<%@ page import="controller.insertLocationController.FindStructureByUsername" %>
<%@ page import="model.payment.IBANCredentialNotValid" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 13/01/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<%

    StructureListBean structures = new StructureListBean();
    try {
        structures.setStructures(new FindStructureByUsername().findStructureByUsername("tiziano.ditoma"));
        session.setAttribute("structuresBean", structures);
    } catch (IBANCredentialNotValid | SQLException ibanCredentialNotValid) {
        ibanCredentialNotValid.printStackTrace();
    }

    request.getRequestDispatcher("/management/managementStructure/structure.jsp").forward(request, response);
%>

