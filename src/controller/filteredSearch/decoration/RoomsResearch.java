package controller.filteredSearch.decoration;

import controller.filteredSearch.Component;
import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomsResearch extends Decorator {

    private Integer rooms;

    public RoomsResearch(Integer rooms, Component filteredSearchComponent) {
        super(filteredSearchComponent);
        this.rooms = rooms;
    }

    private ArrayList<Structure> filterResearchRooms(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if (location.getNumOfRooms().compareTo(rooms) >= 0)
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
        return filterResearchRooms(super.search());
    }
}