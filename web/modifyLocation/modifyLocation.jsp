<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="structuresBean" scope="session" class="bean.StructureListBean"/>
<%structuresBean.setLocationSelected(Integer.valueOf(request.getParameter("locationIndex")));%>

<html>
<head>
    <title>Gestisci locazione</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.5.4/css/bootstrap-slider.css">

    <script src="ModifyLocationControl.js"></script>

</head>
<body>

<jsp:include page="../navigation_bar.jsp"/>
<div class="container-fluid">

    <jsp:include page="modifyLocation_box.jsp"/>
</div>

</body>
</html>
