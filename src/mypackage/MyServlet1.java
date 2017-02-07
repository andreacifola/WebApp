package mypackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String description = req.getParameter("description");
        String numRooms = req.getParameter("numRooms");
        String numBath = req.getParameter("numBath");
        String maxNumGuests = req.getParameter("maxNumGuests");
        String price = req.getParameter("price");
        String startAvaibility = req.getParameter("startAvaibility");
        String endAvaibility = req.getParameter("endAvaibility");
        String numBed = req.getParameter("numOfBed");

        //new InsertNewLocationController().addNewLocation(description, numRooms, numBath, maxNumGuests, numBed, price, null, null, 1);


        req.setAttribute("description", description);
        req.setAttribute("numRooms", numRooms);
        req.setAttribute("numBath", numBath);
        req.setAttribute("maxNumGuests", maxNumGuests);
        req.setAttribute("price", price);
        req.setAttribute("startAvaibility", startAvaibility);
        req.setAttribute("endAvaibility", endAvaibility);
        req.setAttribute("numOfBed", numBed);

        RequestDispatcher dispatcher;
        dispatcher = getServletContext().getRequestDispatcher("/detailLocation.jsp");
        dispatcher.forward(req, resp);

    }
}
