<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><strong>TorVergata Rent</strong></a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
.                <li id="search-navbar-link" ${param.current_tab.equalsIgnoreCase("1") ? "class=\"active\"" : null}><a href="#">Ricerca<span class="sr-only">(current)</span></a></li>
                <li id="reservations-navbar-link" ${param.current_tab.equalsIgnoreCase("2") ? "class=\"active\"" : null}><a href="#">Prenotazioni<span class="sr-only">(current)</span></a></li>
                <li id="locations-navbar-link" ${param.current_tab.equalsIgnoreCase("3") ? "class=\"active\"" : null}><a href="#">Locazioni<span class="sr-only">(current)</span></a></li>
                <li id="messages-navbar-link" ${param.current_tab.equalsIgnoreCase("4") ? "class=\"active\"" : null}><a href="#">Messaggi<span class="sr-only">(current)</span></a></li>
                <li id="profile-navbar-link" ${param.current_tab.equalsIgnoreCase("5") ? "class=\"active\"" : null}><a href="#">Profilo<span class="sr-only">(current)</span></a></li>
            </ul>
            <% if((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) { %>
            <ul class="nav navbar-nav navbar-right">
                <li><button id="logout-button-navbar-link" type="button" class="btn btn-danger navbar-btn">Logout</button><span class="sr-only">(current)</span></li>
            </ul>
            <%}else{ %>
            <ul class="nav navbar-nav navbar-right">
                <li><button id="login-button-navbar-link" type="button" class="btn btn-default navbar-btn">Login</button><span class="sr-only">(current)</span></li>
            </ul>
            <%}%>
        </div>
    </div>
</nav>
