package controller.managementLocationController;

import dataSource.DataSource;
import model.language.managementLocation.ManagementLocationLanguage;
import querySQL.Query;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by andreacifola on 13/09/16.
 */
public class ManagementLocationController {

    public static boolean checkFields(String numOfRoom, String numOfBath, String numMaxGuest, String numBeds, String price) {
        if (!isNumeric(numOfRoom) || !isNumeric(numOfBath) || !isNumeric(numMaxGuest) || !isNumeric(numBeds)) {
            JOptionPane.showMessageDialog(null, ManagementLocationLanguage.managementLocation_wrongValue);
            return false;
        }
        if (!isDouble(price)) {
            JOptionPane.showMessageDialog(null, ManagementLocationLanguage.managementLocation_wrongPrice);
            return false;
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

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean modifyLocation(Integer id, String description, Integer numOfRoom, Integer numOfBath, Integer numMaxGuest,
                                  Integer numBeds, Double price, Boolean wifi, Boolean smookingRoom, Boolean petsAllowed,
                                  Boolean parking, Boolean roomService, Boolean conditionedAir, Boolean view, Boolean plasmaTV) {
        if (checkFields(String.valueOf(numOfRoom), String.valueOf(numOfBath), String.valueOf(numMaxGuest), String.valueOf(numBeds), String.valueOf(price))) {
            try {
                PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.enterLocationChanges);
                statement.setInt(1, id);
                statement.setString(2, description);
                statement.setInt(3, numOfRoom);
                statement.setInt(4, numOfBath);
                statement.setInt(5, numMaxGuest);
                statement.setInt(6, numBeds);
                statement.setDouble(7, price);
                statement.setBoolean(8, wifi);
                statement.setBoolean(9, smookingRoom);
                statement.setBoolean(10, petsAllowed);
                statement.setBoolean(11, parking);
                statement.setBoolean(12, roomService);
                statement.setBoolean(13, conditionedAir);
                statement.setBoolean(14, view);
                statement.setBoolean(15, plasmaTV);
                statement.execute();
                statement.clearParameters();
                return true;
            } catch (SQLException ignored) {
                JOptionPane.showMessageDialog(null, "SQL Error!");
                return false;
            }
        }
        return false;
    }
}