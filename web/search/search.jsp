<%@ page import="model.insertNewLocation.Structure" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<jsp:include page="navigation_bar.jsp">
    <jsp:param name="current_tab" value="1"/>
</jsp:include>

<div class="container-fluid" style="margin-top: 5%">

    <nav class="col-sm-4">
        <%  HashMap<String,Object> filters = (HashMap<String, Object>) request.getAttribute("filters");%>
        <%  if (filters != null){%>
        <jsp:include page="filter_search_box.jsp">
            <jsp:param name="startdate" value="<%=filters.get(\"start-date\")%>"/>
            <jsp:param name="enddate" value="<%=filters.get(\"end-date\")%>"/>
            <jsp:param name="region" value="<%=filters.get(\"region\")%>"/>
            <jsp:param name="city" value="<%=filters.get(\"city\")%>"/>
            <jsp:param name="structure" value="<%=filters.get(\"structure\")%>"/>
            <jsp:param name="rooms" value="<%=filters.get(\"rooms\")%>"/>
            <jsp:param name="toilets" value="<%=filters.get(\"toilets\")%>"/>
            <jsp:param name="people" value="<%=filters.get(\"people\")%>"/>
            <jsp:param name="beds" value="<%=filters.get(\"beds\")%>"/>
            <jsp:param name="price" value="<%=filters.get(\"price\")%>"/>
            <jsp:param name="wifi" value="<%=filters.get(\"wifi\")%>"/>
            <jsp:param name="animals" value="<%=filters.get(\"animals\")%>"/>
            <jsp:param name="roomservice" value="<%=filters.get(\"room-service\")%>"/>
            <jsp:param name="view" value="<%=filters.get(\"view\")%>"/>
            <jsp:param name="smoking" value="<%=filters.get(\"smoking\")%>"/>
            <jsp:param name="parking" value="<%=filters.get(\"parking\")%>"/>
            <jsp:param name="conditionedair" value="<%=filters.get(\"conditioned-air\")%>"/>
            <jsp:param name="plasmatv" value="<%=filters.get(\"plasma-tv\")%>"/>
        </jsp:include>
        <%}else{%>
        <jsp:include page="filter_search_box.jsp"/>
        <%}%>
    </nav>

    <div class="col-sm-8">
        <%if (request.getAttribute("structure_list") != null){for (Structure structure : (ArrayList<Structure>) request.getAttribute("structure_list")) {%>
        <div class="row">
            <jsp:include page="structure_card.jsp">
                <jsp:param name="title" value="<%=structure.getName()%>"/>
                <jsp:param name="address" value="<%=structure.getAddress()%>"/>
                <jsp:param name="description" value="<%=structure.getDescription()%>"/>
            </jsp:include>
        </div>
        <%}}%>
    </div>
</div>

<script>
    $(document).ready(function(){
        var start_date=$('input[name="start-date"]');
        var end_date=$('input[name="end-date"]');
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        start_date.datepicker({
            format: 'dd/mm/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true
        });
        end_date.datepicker({
            format: 'dd/mm/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true
        })
    })
</script>
</body>
