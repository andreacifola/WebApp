package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Location;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class PriceResearch extends Decorator {

    private Integer price;

    public PriceResearch(Integer price, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.price = price;
    }

    private ArrayList<Structure> filterResearchPrice(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            ArrayList<Location> filteredLocations = new ArrayList<>();
            for (Location location : structure.getLocations()) {
                if ((int) Math.floor(location.getPrice()) <= price)
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
    public ArrayList<Structure> search() throws IBANCredentialNotValid, SQLException {
        return filterResearchPrice(super.search());
    }
}