package controller.ReservationController;

import dataSource.DataSource;
import model.Reservation.Reservation;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tizianoditoma on 14/09/16.
 */
public class FindReservationByUsername {

    public FindReservationByUsername() {
    }

    public static Reservation retrieveReservationInfoFromDatabaseQuery(ResultSet resultSet) throws SQLException {
        Integer r_id = resultSet.getInt("id"),
                r_idLocation = resultSet.getInt("location");
        Date r_from = resultSet.getDate("fromdate"),
                r_to = resultSet.getDate("todate");
        String r_username = resultSet.getString("username");

        return new Reservation(r_id, r_username, r_idLocation, r_from, r_to);
    }

    public ArrayList<Reservation> findReservationByUsername(String username) throws SQLException {
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.selectReservation);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Reservation> reservations = new ArrayList<>();
        while (resultSet.next()) {
            reservations.add(retrieveReservationInfoFromDatabaseQuery(resultSet));
        }
        return reservations;
    }

}
