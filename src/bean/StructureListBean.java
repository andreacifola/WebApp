package bean;

import model.insertNewLocation.Structure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by davidemagnanimi on 06/01/17.
 */
public class StructureListBean implements Serializable{
    private ArrayList<Structure> structures;

    public StructureListBean() {
        structures = null;
    }

    public ArrayList<Structure> getStructures() {
        return structures;
    }

    public void setStructures(ArrayList<Structure> structures) {
        this.structures = structures;
    }

    public ArrayList<Location> getLocation(Structure structure) {
        return structure.getLocations();
    }
}
