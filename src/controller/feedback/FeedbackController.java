package controller.feedback;

import dataSource.DataSource;
import model.feedback.Feedback;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by davidemagnanimi on 12/09/16 at 15:00.
 */
public class FeedbackController {// implements Runnable{

    /*
    String username, description;
    Integer locationID, rating;

    public FeedbackController(String username, String description, Integer locationID, Integer rating) {
        this.username = username;
        this.description = description;
        this.locationID = locationID;
        this.rating = rating;
    }

    public FeedbackController() {
    }
    */

    /**
     * This method checks if there is a reservation stored in DB for a certain location and username. It also checks
     * if the starting date of that reservation is already spent.
     * @param username of which should have a reservation in DB
     * @param locationID we are looking for in DB
     * @return true if is verified the check
     * @throws SQLException
     */
    private boolean checkDate(String username, Integer locationID) throws SQLException {
        PreparedStatement ps = DataSource.getConnection().prepareStatement(Query.checkReservation);
        ps.setString(1, username);
        ps.setInt(2, locationID);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Date fromDate = resultSet.getDate("fromdate");
            Date today = Calendar.getInstance().getTime();
            if (fromDate.before(today))
                return true;
        }
        return false;
    }

    /**
     * Store the feedback in DB
     * @param username of the user who wants to add the feedback
     * @param locationID referred by the feedbak
     * @param rating of the feeback
     * @param description of the feedback
     * @return true if it stores without error
     */
    public boolean storeFeedback(String username, Integer locationID, Integer rating, String description) {
        try {
            if (!checkDate(username, locationID))
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        Feedback feedback = new Feedback(rating, description.trim(), username);
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.addFeedback);
            preparedStatement.setInt(1, feedback.getRating());
            preparedStatement.setString(2, feedback.getDescription());
            preparedStatement.setString(3, feedback.getUsername());
            preparedStatement.setInt(4, locationID);

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
/*








    @Override
    public void run() {
        storeFeedback();
    }



    public synchronized boolean storeFeedback() {
        try {
            if (!checkDate())
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        Feedback feedback = new Feedback(rating, description.trim(), username);
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.addFeedback);
            preparedStatement.setInt(1, feedback.getRating());
            preparedStatement.setString(2, feedback.getDescription());
            preparedStatement.setString(3, feedback.getUsername());
            preparedStatement.setInt(4, locationID);

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private synchronized boolean checkDate() throws SQLException {
        PreparedStatement ps = DataSource.getConnection().prepareStatement(Query.checkReservation);
        ps.setString(1, username);
        ps.setInt(2, locationID);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Date fromDate = resultSet.getDate("fromdate");
            Date today = Calendar.getInstance().getTime();
            if (fromDate.before(today))
                return true;
        }
        return false;
    }
*/

}
