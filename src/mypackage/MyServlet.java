package mypackage;

import controller.insertLocationController.FindStructureByUsername;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tizianoditoma on 05/01/17.
 */

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        FindStructureByUsername findStructureByUsernameManagement = new FindStructureByUsername();
        ArrayList<Structure> foundedStructureManagement = null;
        try {
            try {
                foundedStructureManagement = findStructureByUsernameManagement.findStructureByUsername("tizianoditoma");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IBANCredentialNotValid ibanCredentialNotValid) {
            ibanCredentialNotValid.printStackTrace();
        }

    }

}
