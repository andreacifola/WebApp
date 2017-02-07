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