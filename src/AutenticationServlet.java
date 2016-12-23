import bean.BeanUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AutenticationServlet")
public class AutenticationServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanUser user = DataSource.searchUser((String) request.getParameter("username"), (String) request.getParameter("password"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/autentication.jsp").forward(request, response);
    }

}
