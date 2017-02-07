package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AvailabilityResearch extends Decorator {

    private Date from, to;

    public AvailabilityResearch(Date from, Date to, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.from = from;
        this.to = to;
    }

    private ArrayList<Structure> filterResearchAvailability(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if (location.getAvailableTime().checkAvailability(from, to))
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
        return filterResearchAvailability(super.search());
    }
}