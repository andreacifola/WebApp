package controller.filteredSearch.decoration;

import controller.filteredSearch.Component;
import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class SmokingRoomResearch extends Decorator {

    public SmokingRoomResearch(Component filteredSearchComponent) {
        super(filteredSearchComponent);
    }

    public ArrayList<Structure> filterResearchSmokingRoom(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if (location.getService().isSmokingRoom())
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
        return filterResearchSmokingRoom(super.search());
    }
}