package controller.feedback;

import dataSource.DataSource;
import model.User;
import model.feedback.Feedback;
import model.insertNewLocation.Location;
import model.language.feedback.FeedbackLanguage;
import querySQL.Query;
import view.feedback.AddFeedback;
import view.filteredResearch.FilteredSearchResultLocation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by davidemagnanimi on 12/09/16 at 15:00.
 */
public class FeedbackController {

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
}
