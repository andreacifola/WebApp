package controller.managementLocationController;

import dataSource.DataSource;
import model.language.managementLocation.ManagementLocationLanguage;
import querySQL.Query;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagementLocationController {

    /**
     * This method check if the modified fields of the location respect the constraints
     *
     * @param numOfRoom   of the location to be changed
     * @param numOfBath   of the location to be changed
     * @param numMaxGuest of the location to be changed
     * @param numBeds     of the location to be changed
     * @param price       of the location to be changed
     * @return true in case of success (all fields are correct), false otherwise
     */
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

    /**
     * This method checks if the argument passed is an integer value
     * @param string the string to be evaluated be an integer
     * @return true in case of success (the string is effectively an integer), false otherwise
     * @throws IllegalArgumentException
     */
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

    /**
     * This method checks if the argument passed is a souble value
     * @param str the string to be evaluated be a value
     * @return true in case of success (the string is effectively a double), false otherwise
     */
    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method modify the location if all fields are correct
     * @param id of the location to be changed
     * @param description of the location to be changed
     * @param numOfRoom of the location to be changed
     * @param numOfBath of the location to be changed
     * @param numMaxGuest of the location to be changed
     * @param numBeds of the location to be changed
     * @param price of the location to be changed
     * @param wifi of the location to be changed
     * @param smookingRoom of the location to be changed
     * @param petsAllowed of the location to be changed
     * @param parking of the location to be changed
     * @param roomService of the location to be changed
     * @param conditionedAir of the location to be changed
     * @param view of the location to be changed
     * @param plasmaTV of the location to be changed
     * @return true in case of success (the location is correctly modified), false otherwise
     */
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