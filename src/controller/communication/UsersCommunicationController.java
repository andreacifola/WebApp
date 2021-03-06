package controller.communication;

import dataSource.DataSource;
import querySQL.Query;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UsersCommunicationController {
    private final static String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private boolean checkEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    /**
     * This method, with a query, searches email of the logged user starting from the username of the logged user
     *
     * @param username of the logged user
     * @return the email
     */
    public String searchEmailFromUsername(String username) {
        try {
            PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.searchEmailFromUsername);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getString("email");
        } catch (SQLException ignored) {
            return null;
        }
    }

    /**
     * This method sends email with the help of a query
     * @param sender of the email
     * @param receiver of the email
     * @param object of the email
     * @param body of the email
     * @return true in case of success (query sended), false otherwise
     */
    public boolean sendEmail(String sender, String receiver, String object, String body) {
        String emailSender = searchEmailFromUsername(sender);
        String emailReceiver = searchEmailFromUsername(receiver);
        if (emailSender != null && emailReceiver != null && checkEmail(emailSender)
                && checkEmail(emailReceiver) && !object.isEmpty() && !body.isEmpty()) {
            try {
                PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.enterNewEmail);
                statement.setString(1, emailSender);
                statement.setString(2, emailReceiver);
                statement.setString(3, object);
                statement.setString(4, body);
                statement.execute();
                statement.clearParameters();
            } catch (SQLException ignored) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * This method disables text fields which contains sender, receiver, object and body of the query
     * @param textField1
     * @param stringField1
     * @param textField2
     * @param stringField2
     */
    public void disableTextFieldForCommunication(JTextField textField1, String stringField1,
                                                 JTextField textField2, String stringField2) {
        textField1.setEnabled(false);
        textField1.setText(stringField1);
        textField1.setDisabledTextColor(Color.BLACK);
        textField2.setEnabled(false);
        textField2.setText(stringField2);
        textField2.setDisabledTextColor(Color.BLACK);
    }
}