package model.insertNewLocation;

import model.feedback.Feedback;

import java.util.ArrayList;

/**
 * Created by tizianoditoma on 05/09/16.
 */
public class Location {

    private String description;
    private Integer numOfRooms;
    private Integer numOfBath;
    private Integer numMaxGuests;
    private Integer numBeds;
    private Integer id;
    private Double price;
    private Service service;
    private AvailableTime availableTime;
    private ArrayList<Feedback> feedbacks;

    public Location(String description, Integer numOfRooms, Integer numOfBath, Integer numMaxGuests,
                    Integer numBeds, Double price, Service service, AvailableTime availableTime, ArrayList<Feedback> feedbacks) {
        this.id = null;
        this.description = description;
        this.numOfRooms = numOfRooms;
        this.numOfBath = numOfBath;
        this.numMaxGuests = numMaxGuests;
        this.numBeds = numBeds;
        this.price = price;
        this.service = service;
        this.availableTime = availableTime;
        this.feedbacks = feedbacks;
    }

    public Location(Integer id, String description, Integer numOfRooms, Integer numOfBath, Integer numMaxGuests,
                    Integer numBeds, Double price, Service service, AvailableTime availableTime, ArrayList<Feedback> feedbacks) {
        this(description, numOfRooms, numOfBath, numMaxGuests, numBeds, price, service, availableTime, feedbacks);
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public Integer getNumOfBath() {
        return numOfBath;
    }

    public void setNumOfBath(Integer numOfBath) {
        this.numOfBath = numOfBath;
    }

    public Integer getNumMaxGuests() {
        return numMaxGuests;
    }

    public void setNumMaxGuests(Integer numMaxGuests) {
        this.numMaxGuests = numMaxGuests;
    }

    public Integer getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(Integer numBeds) {
        this.numBeds = numBeds;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AvailableTime getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(AvailableTime availableTime) {
        this.availableTime = availableTime;
    }

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
