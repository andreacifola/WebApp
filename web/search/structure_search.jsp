<%@ page import="controller.filteredSearch.FilteredSearchController" %>
<%@ page import="bean.StructureListBean" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<jsp:useBean id="filters" scope="request" class="bean.FilterSearchBean">
    <jsp:setProperty name="filters" property="*"/>
</jsp:useBean>
<%
    try {
        StructureListBean structures = new StructureListBean();
        structures.setStructures(new FilteredSearchController().startResearch(new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY).parse(filters.getStart_date()),
                    new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY).parse(filters.getEnd_date()), filters.getRegion(), filters.getCity(), filters.getStructure(), filters.getRooms(),
                    filters.getBaths(), filters.getGuests(), filters.getBeds(), filters.getPrice(),filters.getWifi(),
                    filters.getSmoking(), filters.getPets(), filters.getParking(), filters.getRoom_service(),
                    filters.getConditioned_air(), filters.getView(), filters.getPlasma_tv()));
        session.setAttribute("structuresBean",structures);
    } catch (Exception e) {
        e.printStackTrace();
    }
    request.getRequestDispatcher("search.jsp").forward(request,response);
%>