<%@ page import="model.insertNewLocation.Structure" %><%--
  Created by IntelliJ IDEA.
  User: davidemagnanimi
  Date: 05/01/17
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Locazioni</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/navigation_bar.jsp">
    <jsp:param name="current_tab" value="1"/>
</jsp:include>

<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%structuresBean.setStructureSelected(Integer.valueOf(request.getParameter("structureindex")));%>

<div class="container" style="margin-top: 4%">
    <h1 class="text-center">Scegli la locazione più adatta a te!</h1>
    <div class="list-group" style="margin-top: 2%">

        <%for (int locationIndex=0; locationIndex<structuresBean.getStructures().get(structuresBean.getStructureSelected())
                .getLocations().size();locationIndex++) {%>

            <div class="list-group-item">
                <jsp:include page="location_card.jsp">
                    <jsp:param name="location_index" value="<%=locationIndex%>"/>
                </jsp:include>
            </div>

        <%}%>

    </div>
</div>

</body>
</html>
