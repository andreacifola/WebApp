package model.Reservation;

import dataSource.DataSource;
import model.insertNewLocation.Location;
import querySQL.Query;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by tizianoditoma on 07/09/16.
 */
public class Reservation {

    private Integer id;
    private String usernameUser;
    private Integer idLocation;
    private Date fromDate;
    private Date toDate;

    public Reservation(Integer id, String usernameUser, Integer idLocation, Date fromDate, Date toDate) {
        this.id = id;
        this.usernameUser = usernameUser;
        this.idLocation = idLocation;
        this.fromDate = fromDate;
        this.toDate = toDate;

    }

    public static boolean Reservation(Location locationToReserve) throws SQLException {
        Integer id = locationToReserve.getId();

        if (checkFields(locationToReserve)) {
            Connection connection = DataSource.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query.deleteLocation);
                preparedStatement.setInt(1, id);

                preparedStatement.execute();
                preparedStatement.clearParameters();

                //TODO INSERISCI AVAILABILITY

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error occurs!");
                return false;
            }
            return true;
        }
        return false;

    }

    public static boolean checkFields(Location locationToReserve) {
        //TODO controlli inserisci nuova locazione errati

        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


}
