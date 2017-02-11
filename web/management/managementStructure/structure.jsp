<%--
Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 03/01/17
  Time: 04:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>

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

<%if (request.getAttribute("true_modify_location") != null) {%>

<div class="container-fluid " style="margin-top: 5%">
    <div class="alert alert-success" role="success">
        La locazione <label style="font-style: italic"><%=request.getAttribute("true_modify_location")%>
    </label>
    </div>
    <%}%>
    <div class="col-sm-8 ">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div style="text-align: left">
                        <h3 style="margin-left: 2%" class="panel-title">Elenco delle strutture</h3>
                    </div>
                    <div style="text-align: right">
                        <input style="margin-right: 2%" class="btn btn-default" type="button"
                               value="Aggiungi nuova struttura"
                               onClick="location.href='/management/managementStructure/formStructure.jsp'">
                    </div>
                </div>
            </div>
            <div>
                <%for (int i = 0; i < structuresBean.getStructures().size(); i++) {%>
                <div class="list-group-item">
                    <jsp:include page="structureCard.jsp">
                        <jsp:param name="structure_index" value="<%=i%>"/>
                    </jsp:include>
                </div>
                <%}%>
            </div>
        </div>
    </div>
</div>
</body>
</html>
