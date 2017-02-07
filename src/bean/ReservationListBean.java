package bean;

import model.Reservation.Reservation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tizianoditoma on 07/02/17.
 */
public class ReservationListBean implements Serializable {
    private ArrayList<Reservation> reservations;

    public ReservationListBean() {
        reservations = new ArrayList<>();
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}