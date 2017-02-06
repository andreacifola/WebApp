package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class MaxGuests extends Decorator {

    private Integer maxGuests;

    public MaxGuests(Integer maxGuests, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.maxGuests = maxGuests;
    }

    private ArrayList<Structure> filterResearchGuests(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if (location.getNumMaxGuests().compareTo(maxGuests) >= 0)
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
        return filterResearchGuests(super.search());
    }
}