package controller.communication;

import dataSource.DataSource;
import model.communication.Letter;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by andreacifola on 08/09/16.
 */
public class CommunicationController {

    /**
     * This method takes all the letters (received both sended) in the DB with the specific logged user email
     *
     * @param userEmail the email of the logged user
     * @param query     query that search both received email and sended email
     * @return the array of the letters. Each letter has username of the sender (or receiver),
     * object and body of the letter
     */
    public ArrayList<Letter> getEmailInfo(String userEmail, String query) {
        try {
            PreparedStatement statement = DataSource.getConnection().prepareStatement(query);
            statement.setString(1, userEmail);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Letter> result = new ArrayList<>();
            if (!resultSet.next())
                return null;
            else {
                do {
                    String username = resultSet.getString("username2");
                    String object = resultSet.getString("object");
                    String body = resultSet.getString("body");
                    result.add(new Letter(username, object, body));
                } while (resultSet.next());
                return result;
            }
        } catch (SQLException ignored) {
        }
        return null;
    }

    /**
     * This method disables some text fields, filled with the results of the query in getEmailInfo() function.
     * @param textField1
     * @param stringField1
     * @param textField2
     * @param stringField2
     * @param textPane
     * @param stringPane
     */
    public void disableTextField(JTextField textField1, String stringField1, JTextField textField2,
                                 String stringField2, JTextPane textPane, String stringPane) {
        textField1.setEnabled(false);
        textField1.setText(stringField1);
        textField1.setDisabledTextColor(Color.BLACK);
        textField2.setEnabled(false);
        textField2.setText(stringField2);
        textField2.setDisabledTextColor(Color.BLACK);
        textPane.setEnabled(false);
        textPane.setText(stringPane);
        textPane.setDisabledTextColor(Color.BLACK);
    }

    /**
     * This method fills the elements of the check communication panel with the first letter information
     * (both sended and received)
     * @param arrayList
     * @param senderOrReceiver
     * @param object
     * @param body
     * @param i
     */
    public void setCommunicationTabParameters(ArrayList<Letter> arrayList, String[] senderOrReceiver, String[] object, String[] body, int[] i) {
        if (arrayList != null) {
            senderOrReceiver[0] = arrayList.get(i[0]).getUsername().trim();
            object[0] = arrayList.get(i[0]).getObject().trim();
            body[0] = arrayList.get(i[0]).getBody().trim();
        } else {
            senderOrReceiver[0] = "";
            object[0] = "";
            body[0] = "";
        }
    }
}