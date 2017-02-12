package controller.filteredSearch;

import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by davidemagnanimi on 11/02/17.
 */
public abstract class Component {
    protected abstract ArrayList<Structure> search() throws SQLException;
}
