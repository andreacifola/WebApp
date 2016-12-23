import bean.BeanUser;
import dataSource.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeanUser user = DataSource.searchUser(request.getParameter("username"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/Registration.jsp").forward(request, response);
    }
}