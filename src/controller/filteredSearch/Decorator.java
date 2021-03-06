package controller.filteredSearch;

import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Decorator extends Component {
    private Component filteredSearchComponent;

    public Decorator(Component filteredSearchComponent) {
        this.filteredSearchComponent = filteredSearchComponent;
    }

    /**
     * Apply filter to a search with decorator pattern
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Structure> search() throws SQLException {
        return filteredSearchComponent.search();
    }
}
