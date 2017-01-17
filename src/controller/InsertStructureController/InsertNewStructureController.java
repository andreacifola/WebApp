package controller.InsertStructureController;

import dataSource.DataSource;
import querySQL.Query;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by tizianoditoma on 07/09/16.
 */
public class InsertNewStructureController {

    public static boolean addNewStructure(String name, String user, String description, String region, String city, String address,
                                          Integer numCivic, Integer CAP) {
        if (checkFields(String.valueOf(numCivic), String.valueOf(CAP))) {
            Connection connection = DataSource.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query.addNewStrutture);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, user);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, region);
                preparedStatement.setString(5, city);
                preparedStatement.setString(6, address);
                preparedStatement.setInt(7, numCivic);
                preparedStatement.setInt(8, CAP);


                preparedStatement.execute();
                preparedStatement.clearParameters();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error occurs!");
                return false;
            }
            return true;
        }
        return false;
    }


    public static boolean checkFields(String numCivic, String CAP) {


        if (!isNumeric(numCivic) || !isNumeric(CAP)) {
            JOptionPane.showMessageDialog(null, "Some Integer Wrong");
            return false;
        }
        if (numCivic.isEmpty() || CAP.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill in all fields");

        }
        return true;
    }

    private static boolean isNumeric(String string) throws IllegalArgumentException {
        boolean isnumeric = false;
        if (string != null && !string.equals("")) {
            isnumeric = true;
            char chars[] = string.toCharArray();
            for (char aChar : chars) {
                isnumeric &= Character.isDigit(aChar);
                if (!isnumeric)
                    break;
            }
        }
        return isnumeric;
    }
}

