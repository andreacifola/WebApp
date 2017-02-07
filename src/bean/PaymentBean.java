package bean;

import model.User;
import model.insertNewLocation.Location;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by davidemagnanimi on 07/02/17.
 */
public class PaymentBean implements Serializable {
    Date start_date, end_date;
    Location location;
    User owner;

    public PaymentBean() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
