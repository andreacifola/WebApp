package controller.InsertLocationController;

import controller.filteredSearch.FilteredSearchController;
import dataSource.DataSource;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by tizianoditoma on 09/09/16.
 */
public class FindStructureByUsername {

    public FindStructureByUsername() {
    }
    public ArrayList<Structure> findStructureByUsername(String username) throws SQLException, IBANCredentialNotValid {
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.findStructuresByUsername);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Structure> structures = new ArrayList<>();
        while (resultSet.next()) {
            structures.add(FilteredSearchController.retrieveStructureInfoFromDatabaseQuery(resultSet));
        }
        return structures;

    }
}