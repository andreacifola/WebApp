package bean;

import java.io.Serializable;

/**
 * Created by davidemagnanimi on 17/01/17.
 */
public class FilterSearchBean implements Serializable {
    String start_date, end_date, region, city, structure;
    Integer rooms, baths, guests, beds, price;
    Boolean wifi, pets, room_service, view, smoking, parking, conditioned_air, plasma_tv;

    public FilterSearchBean() {
        start_date = end_date = region = city = structure = "";
        rooms = baths = guests = beds = 1;
        price = 75;
        wifi = pets = room_service = view = smoking = parking = conditioned_air = plasma_tv = false;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public Boolean getRoom_service() {
        return room_service;
    }

    public void setRoom_service(Boolean room_service) {
        this.room_service = room_service;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getConditioned_air() {
        return conditioned_air;
    }

    public void setConditioned_air(Boolean conditioned_air) {
        this.conditioned_air = conditioned_air;
    }

    public Boolean getPlasma_tv() {
        return plasma_tv;
    }

    public void setPlasma_tv(Boolean plasma_tv) {
        this.plasma_tv = plasma_tv;
    }
}
