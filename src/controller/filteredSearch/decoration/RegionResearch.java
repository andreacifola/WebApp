package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegionResearch extends Decorator {

    private String region;

    public RegionResearch(String region, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.region = region;
    }

    private ArrayList<Structure> filterResearchRegion(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            if (structure.getAddress().getRegion().equalsIgnoreCase(region))
                filteredStructures.add(structure);
        }
        return filteredStructures;
    }

    @Override
    public ArrayList<Structure> search() throws IBANCredentialNotValid, SQLException {
        return filterResearchRegion(super.search());
    }
}