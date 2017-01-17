package controller.filteredSearch.decoration;

import controller.filteredSearch.Decorator;
import controller.filteredSearch.FilteredSearchController;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;

import java.sql.SQLException;
import java.util.ArrayList;

public class NameResearch extends Decorator {

    private String name;

    public NameResearch(String name, FilteredSearchController filteredSearch) {
        super(filteredSearch);
        this.name = name;
    }

    private ArrayList<Structure> filterResearchName(ArrayList<Structure> structures) {
        ArrayList<Structure> filteredStructures = new ArrayList<>();

        for (Structure structure : structures) {
            if (structure.getName().equalsIgnoreCase(name))
                filteredStructures.add(structure);
        }
        return filteredStructures;
    }

    @Override
    public ArrayList<Structure> search() throws IBANCredentialNotValid, SQLException {
        return filterResearchName(super.search());
    }
}