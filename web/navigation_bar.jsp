<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="logged_user" scope="session" class="model.User"/>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><strong>TorVergata Rent</strong></a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="search-navbar-link" ${param.current_tab.equalsIgnoreCase("1") ? "class=\"active\"" : null}><a href="/search/search.jsp">Ricerca<span class="sr-only">(current)</span></a></li>
                <%if (logged_user != null && logged_user.getUsername() != null) {%>
                <li id="reservations-navbar-link" ${param.current_tab.equalsIgnoreCase("2") ? "class=\"active\"" : null}><a href="/reservation/reservationJavaFind.jsp">Prenotazioni<span class="sr-only">(current)</span></a></li>
                <li id="locations-navbar-link" ${param.current_tab.equalsIgnoreCase("3") ? "class=\"active\"" : null}><a href="/management/managementStructure/structureJavaFind.jsp">Strutture<span class="sr-only">(current)</span></a></li>
                <li id="messages-navbar-link" ${param.current_tab.equalsIgnoreCase("4") ? "class=\"active\"" : null}><a
                        href="/checkCommunication/checkCommunication.jsp">Messaggi<span
                        class="sr-only">(current)</span></a></li>
                <li id="profile-navbar-link" ${param.current_tab.equalsIgnoreCase("5") ? "class=\"active\"" : null}><a
                        href="/managementeProfile/managementProfile.jsp">Profilo<span
                        class="sr-only">(current)</span></a></li>
                <%}%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form action="/logout.jsp" method="post" style="margin-bottom: -2%; margin-top: -2%">
                        <input id="logout-button-navbar-link" type="submit"  role="button" class="btn navbar-btn <%=(logged_user == null || logged_user.getUsername() == null)? "btn-primary" : "btn-danger"%> " value="<%=(logged_user == null || logged_user.getUsername() == null)? "Accedi" : "Esci"%>"/><span class="sr-only">(current)</span>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
