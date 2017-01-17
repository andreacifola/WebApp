<%@ page import="model.insertNewLocation.Structure" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<html>
<head>
    <title>Ricerca filtrata</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/bootstrap-slider.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/css/bootstrap-slider.css">

</head>
<body>

<jsp:include page="/navigation_bar.jsp">
    <jsp:param name="current_tab" value="1"/>
</jsp:include>

<div class="container-fluid" style="margin-top: 5%">
    <div class="col-sm-4">
        <jsp:include page="/search/filter_search_box.jsp"/>
    </div>
    <div class="col-sm-8">
        <%for (int i=0; i<structuresBean.getStructures().size();i++) {%>
        <div class="row">
            <jsp:include page="structure_card.jsp">
                <jsp:param name="structure_index" value="<%=i%>"/>
            </jsp:include>
        </div>
        <%}%>
    </div>
</div>
</body>
