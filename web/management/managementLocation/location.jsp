<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 03/01/17
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Form Struttura</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/css/bootstrap-slider.css">

</head>

<body data-spy="scroll" data-target=".navbar" data-offset="25" style="margin-top: 5%">
<jsp:include page="../../navigation_bar.jsp"/>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%Integer structureIndex = Integer.valueOf(request.getParameter("structureindex"));%>


<div class="container-fluid " style="margin-top: 5%">
    <div class="col-sm-8 ">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div style="text-align: left">
                        <h3 style="margin-left: 2%" class="panel-title">Elenco delle locazioni</h3>
                    </div>
                    <div style="margin-right: 2%; text-align: right">
                        <form method="get" action="formLocation.jsp">
                            <button type="submit" name="structureindex" value="<%=structureIndex%>"
                                    class="btn btn-default">Aggiungi nuova locazione
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <%
                for (int locationIndex = 0; locationIndex < structuresBean.getStructures().get(structureIndex)
                        .getLocations().size(); locationIndex++) {
            %>
            <div class="list-group-item">
                <jsp:include page="locationCard.jsp">
                    <jsp:param name="structure_index" value="<%=structureIndex%>"/>
                    <jsp:param name="location_index" value="<%=locationIndex%>"/>
                </jsp:include>
            </div>
            <%}%>
        </div>
    </div>
</div>
</body>

</html>