package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class BathsResearch extends Decorator {

    private Integer baths;

    public BathsResearch(Integer baths, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.baths = baths;
    }

    private ArrayList<Structure> filterResearchBaths(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if (location.getNumOfBath().compareTo(baths) >= 0)
                    filteredLocations.add(location);
            }
            if (!filteredLocations.isEmpty()) {
                structure.setLocations(filteredLocations);
                filteredStructures.add(structure);
            }
        }
        return filteredStructures;
    }

    @Override
    public ArrayList<Structure> search() throws SQLException {
        return filterResearchBaths(super.search());
    }
}