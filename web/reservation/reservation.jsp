<%--
  Created by IntelliJ IDEA.
  User: tizianoditoma
  Date: 16/01/17
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Prenotazioni</title>
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
<jsp:include page="../navigationBar.jsp"/>
<jsp:useBean id="reservationBean" scope="session" class="bean.ReservationListBean"/>
<jsp:useBean id="strucuturesBean" scope="session" class="bean.StructureListBean"/>


<div class="container-fluid " style="margin-top: 5%">
    <div class="col-sm-8 ">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div style="text-align: left">
                        <h3 style="margin-left: 2%" class="panel-title">Ecco le tue prenotazioni . Buon Viaggio!</h3>
                    </div>
                </div>
            </div>
            <%for (int reservationIndex = 0; reservationIndex < reservationBean.getReservations().size(); reservationIndex++) {%>
            <div class="list-group-item">
                <jsp:include page="reservationCard.jsp">
                    <jsp:param name="reservationIndex" value="<%=reservationIndex%>"/>
                </jsp:include>
            </div>
            <%}%>
        </div>
    </div>
</div>
</body>

</html>