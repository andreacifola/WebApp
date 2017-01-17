<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="bean.UserBean" %>
<%@ page import="controller.registration.RegistrationController" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.HashMap" %>

<%
    String name = request.getParameter("forename");
    String surname = request.getParameter("surname");
    String city = request.getParameter("city");
    String address = request.getParameter("address");
    String date = request.getParameter("date");
    String email = request.getParameter("email");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String iban = request.getParameter("iban");
    Boolean scout = (request.getParameter("scout") != null) ? Boolean.TRUE : Boolean.FALSE;

    HashMap<String, Object> attributes = new HashMap<>();
    attributes.put("forename", name);
    attributes.put("surname", surname);
    attributes.put("city", city);
    attributes.put("address", address);
    attributes.put("date", date);
    attributes.put("email", email);
    //no username
    attributes.put("password", password);
    attributes.put("iban", iban);
    attributes.put("scout", scout);

    request.setAttribute("attributes", attributes);

    GregorianCalendar gregorianCalendar = null;

    try {
        UserBean userBean = new UserBean();
        RegistrationController rc = new RegistrationController();
        if (rc.validUsername(username)) {
            if (date != null) {
                String[] parts = date.split("/");
                Integer day = Integer.parseInt(parts[0]);
                Integer month = Integer.parseInt(parts[1]);
                Integer year = Integer.parseInt(parts[2]);
                gregorianCalendar = new GregorianCalendar(year, month, day);
            }
            rc.addNewUser(name, surname, city, address, gregorianCalendar, email, username, password, password, iban, scout);
            userBean.setUsername(username);
            session.setAttribute("userBean", userBean);
            request.getRequestDispatcher("../managementLocation/managementLocation.jsp").forward(request, response);
            //TODO rimandare al login
        } else {
            request.setAttribute("username_not_valid", username);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>