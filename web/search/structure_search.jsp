<%@ page import="controller.filteredSearch.FilteredSearchController" %>
<%@ page import="bean.StructureListBean" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="bean.PaymentBean" %>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<jsp:useBean id="filters" scope="request" class="bean.FilterSearchBean">
    <jsp:setProperty name="filters" property="*"/>
</jsp:useBean>
<%
    StructureListBean structures = new StructureListBean();
    Date startDate = null, endDate = null;
    try {
        startDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY).parse(filters.getStart_date());
    } catch (ParseException e) {
        e.printStackTrace();
        if (filters.getStart_date().equals(""))
            startDate = null;
        else {
            request.getRequestDispatcher("/search/search_error.jsp").forward(request, response);
            return;
        }
    }
    try {
        endDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY).parse(filters.getEnd_date());
    } catch (ParseException e) {
        e.printStackTrace();
        if (filters.getEnd_date().equals(""))
            endDate = null;
        else {
            request.getRequestDispatcher("/search/search_error.jsp").forward(request, response);
            return;
        }
    }

    PaymentBean paymentBean = new PaymentBean();
    paymentBean.setStart_date(startDate);
    paymentBean.setEnd_date(endDate);

    try {
        structures.setStructures(new FilteredSearchController().startResearch(startDate, endDate, filters.getRegion(),
                filters.getCity(), filters.getStructure(), filters.getRooms(),
                filters.getBaths(), filters.getGuests(), filters.getBeds(), filters.getPrice(),filters.getWifi(),
                filters.getSmoking(), filters.getPets(), filters.getParking(), filters.getRoom_service(),
                filters.getConditioned_air(), filters.getView(), filters.getPlasma_tv()));
        if (structures.getStructures() == null)
            request.getRequestDispatcher("/search/search_error.jsp").forward(request,response);
        else {
            session.setAttribute("paymentBean", paymentBean);
            session.setAttribute("structuresBean", structures);
            request.getRequestDispatcher("/search/search.jsp").forward(request, response);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        request.getRequestDispatcher("/search/search_error.jsp").forward(request,response);
    }
%>