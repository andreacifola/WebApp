package controller.filteredSearch;

import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Decorator extends FilteredSearchController {
    private FilteredSearchController filteredSearch;

    public Decorator(FilteredSearchController filteredSearch) {
        this.filteredSearch = filteredSearch;
    }

    @Override
    public ArrayList<Structure> search() throws SQLException {
        return filteredSearch.search();
    }
}
