package controller.ReservationController;

import controller.payment.PaymentController;
import controller.payment.PaymentObserver;
import dataSource.DataSource;
import model.User;
import model.insertNewLocation.Location;
import model.payment.Status;
import model.payment.TransactionNotValid;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by tizianoditoma on 13/09/16.
 */
public class ReservationController implements PaymentObserver {
    private User user, owner;
    private Location location;
    private PaymentController paymentController;
    private Date fromDate, toDate;

    public ReservationController(Location location, User user, User owner, Date fromDate, Date toDate) {
        this.location = location;
        this.user = user;
        this.owner = owner;
        this.fromDate = fromDate;
        this.toDate = toDate;

        try {
            this.paymentController = new PaymentController(priceCalculate(fromDate, toDate, location.getPrice()), owner); //TODO calcola prezzo
            paymentController.attachObserver(this);
        } catch (TransactionNotValid transactionNotValid) {
            transactionNotValid.printStackTrace();
        }
    }


    public Double priceCalculate(Date fromDate, Date toDate, Double price) {
        Double newPrice;

        long millisDiff = toDate.getTime() - fromDate.getTime();
        int days = (int) (millisDiff / 86400000) + 1;

        newPrice = price * days;
        return newPrice;

    }


    @Override
    public void update(Status status) {
        if (status.equals(Status.Approved)) {
            location.getAvailableTime().removeInterval(location, fromDate, toDate); //Rimuovo la disponibilità
            try {
                PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.addReservation);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setInt(2, location.getId());
                preparedStatement.setDate(3, new java.sql.Date(fromDate.getTime()));
                preparedStatement.setDate(4, new java.sql.Date(toDate.getTime()));
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //if (status.equals(Status.Cancelled) || status.equals(Status.Failed))
        //TODO annulla prenotazione
    }
}
