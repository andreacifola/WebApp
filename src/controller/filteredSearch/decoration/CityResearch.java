package controller.filteredSearch.decoration;

import controller.filteredSearch.Component;
import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class CityResearch extends Decorator {

    private String city;

    public CityResearch(String city, Component filteredSearchComponent) {
        super(filteredSearchComponent);
        this.city = city;
    }

    private ArrayList<Structure> filterResearchCity(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            if (structure.getAddress().getCity().equalsIgnoreCase(city))
                filteredStructures.add(structure);
        }
        return filteredStructures;
    }

    @Override
    public ArrayList<Structure> search() throws SQLException {
        return filterResearchCity(super.search());
    }
}