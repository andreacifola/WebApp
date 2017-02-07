package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.SearchServlet")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("start-date"),
                endDate = req.getParameter("end-date"),
                region = req.getParameter("region"),
                city = req.getParameter("city"),
                structure = req.getParameter("structure");
        Integer rooms = Integer.valueOf(req.getParameter("rooms")),
                toilets = Integer.valueOf(req.getParameter("toilets")),
                people = Integer.valueOf(req.getParameter("people")),
                beds = Integer.valueOf(req.getParameter("beds")),
                price = Integer.valueOf(req.getParameter("price"));
        Boolean wifi = (req.getParameter("wifi") != null) ? Boolean.TRUE : Boolean.FALSE,
                animals = (req.getParameter("animals") != null) ? Boolean.TRUE : Boolean.FALSE,
                roomService = (req.getParameter("room-service") != null) ? Boolean.TRUE : Boolean.FALSE,
                view = (req.getParameter("view") != null) ? Boolean.TRUE : Boolean.FALSE,
                smoking = (req.getParameter("smoking") != null) ? Boolean.TRUE : Boolean.FALSE,
                parking = (req.getParameter("parking") != null) ? Boolean.TRUE : Boolean.FALSE,
                conditionedAir = (req.getParameter("conditioned-air") != null) ? Boolean.TRUE : Boolean.FALSE,
                plasmaTv = (req.getParameter("plasma-tv") != null) ? Boolean.TRUE : Boolean.FALSE;

        /*try {
            ArrayList<Structure> s = new FilteredSearchController().startResearch(null,null, region, city, structure,rooms,toilets,
                        people,beds,price,wifi,smoking,animals,parking,roomService,conditionedAir,view,plasmaTv);
            s.size();
        } catch (IBANCredentialNotValid ibanCredentialNotValid) {
            ibanCredentialNotValid.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        req.getRequestDispatcher("results.html").forward(req, resp);
    }

}
