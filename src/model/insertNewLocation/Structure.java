package model.insertNewLocation;

import model.User;

import java.util.ArrayList;

/**
 * Created by tizianoditoma on 05/09/16.
 */
public class Structure {

    private Integer id;
    private User owner;
    private Address address;
    private ArrayList<Location> locations;
    private String name;
    private String description;

    public Structure(String name, String region, String city, String address, String numCivic, String CAP,
                     User owner, String description, ArrayList<Location> locations) {
        this.name = name;
        this.address = new Address(region, city, address, numCivic, CAP);
        this.description = description;
        this.owner = owner;
        this.locations = locations;
    }

    public Structure(Integer id, String name, String region, String city, String address, String numCivic, String CAP,
                     User owner, String description, ArrayList<Location> locations) {
        this(name, region, city, address, numCivic, CAP, owner, description, locations);
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Structure structure = (Structure) o;

        if (id != null ? !id.equals(structure.id) : structure.id != null) return false;
        if (owner != null ? !owner.equals(structure.owner) : structure.owner != null) return false;
        if (address != null ? !address.equals(structure.address) : structure.address != null) return false;
        if (locations != null ? !locations.equals(structure.locations) : structure.locations != null) return false;
        if (name != null ? !name.equals(structure.name) : structure.name != null) return false;
        return description != null ? description.equals(structure.description) : structure.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (locations != null ? locations.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
