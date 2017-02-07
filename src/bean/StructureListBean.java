package bean;

import model.insertNewLocation.Structure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by davidemagnanimi on 06/01/17.
 */
public class StructureListBean implements Serializable{
    private ArrayList<Structure> structures;
    private Integer structureSelected, locationSelected;

    public StructureListBean() {
        structures = null;
        structureSelected = -1;
        locationSelected = -1;
    }

    public ArrayList<Structure> getStructures() {
        return structures;
    }

    public void setStructures(ArrayList<Structure> structures) {
        this.structures = structures;
    }

    public Integer getStructureSelected() {
        return structureSelected;
    }

    public void setStructureSelected(Integer structureSelected) {
        this.structureSelected = structureSelected;
    }

    public Integer getLocationSelected() {
        return locationSelected;
    }

    public void setLocationSelected(Integer locationSelected) {
        this.locationSelected = locationSelected;
    }
}
