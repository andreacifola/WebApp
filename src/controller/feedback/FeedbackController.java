package controller.feedback;

import dataSource.DataSource;
import model.User;
import model.feedback.Feedback;
import model.insertNewLocation.Location;
import model.language.feedback.FeedbackLanguage;
import querySQL.Query;
import view.feedback.AddFeedback;
import view.filteredResearch.FilteredSearchResultLocation;

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
    private User user;
    private Location location;
    private FilteredSearchResultLocation filteredSearchResultLocation;
    private JFrame frame;

    public FeedbackController(FilteredSearchResultLocation filteredSearchResultLocation, User user, Location location) {
        this.user = user;
        this.location = location;
        this.filteredSearchResultLocation = filteredSearchResultLocation;

        try {
            if (!checkDate())
                JOptionPane.showMessageDialog(new JPanel(), FeedbackLanguage.feedack_cantInsertFeedback);
            else {
                Feedback loadedFeedback = loadFeedback();
                frame = new JFrame();
                frame.setContentPane(new AddFeedback(this, loadedFeedback).getjPanelMain());
                frame.pack();
                frame.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkDate() throws SQLException {
        PreparedStatement ps = DataSource.getConnection().prepareStatement(Query.checkReservation);
        ps.setString(1, user.getUsername());
        ps.setInt(2, location.getId());
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Date fromDate = resultSet.getDate("fromdate");
            Date today = Calendar.getInstance().getTime();
            if (fromDate.before(today))
                return true;
        }
        return false;
    }

    public boolean storeFeedback(Integer rating, String description) {
        Feedback feedback = new Feedback(rating, description.trim(), this.user.getUsername());
        try {
            PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.addFeedback);
            preparedStatement.setInt(1, feedback.getRating());
            preparedStatement.setString(2, feedback.getDescription());
            preparedStatement.setString(3, feedback.getUsername());
            preparedStatement.setInt(4, this.location.getId());

            preparedStatement.execute();

            for (Feedback feedback1 : location.getFeedbacks())
                if (feedback1.getUsername().equals(user.getUsername())) {
                    location.getFeedbacks().remove(feedback1);
                    break;
                }

            this.location.getFeedbacks().add(feedback);
            filteredSearchResultLocation.loadFeedback(location);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Feedback loadFeedback() {
        for (Feedback feedback : location.getFeedbacks())
            if (feedback.getUsername().equals(user.getUsername()))
                return feedback;
        return null;
    }

    public JFrame getFrame() {
        return frame;
    }
}
