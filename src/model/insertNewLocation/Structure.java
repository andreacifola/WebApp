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
}
