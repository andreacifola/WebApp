package controller.insertLocationController;

import dataSource.DataSource;
import model.insertNewLocation.Location;
import model.insertNewLocation.Service;
import querySQL.Query;
import view.LocationForStructure;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by tizianoditoma on 06/09/16.
 */
public class InsertNewLocationController {
    private static LocationForStructure locationForStructure;

    public InsertNewLocationController(LocationForStructure locationForStructure) {
        InsertNewLocationController.locationForStructure = locationForStructure;
    }

    public static boolean checkFields(String numOfRoom, String numOfBath, String numMaxGuest, String numBeds, String price) {
        if (!isNumeric(numOfRoom) || !isNumeric(numOfBath) || !isNumeric(numMaxGuest) || !isNumeric(numBeds)) {
            JOptionPane.showMessageDialog(null, "Some Integer Wrong");
            return false;
        }
        if (!isDouble(price)) {
            JOptionPane.showMessageDialog(null, "Double price value wrong in Price Field");
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

    public static boolean addNewLocation(String description, String numOfRoom, String numOfBath, String numMaxGuest,
                                         String numBeds, String price, Date from, Date to, Service service, Integer idStructure) {
        if (checkFields(numOfRoom, numOfBath, numMaxGuest, numBeds, price)) {
            Connection connection = DataSource.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query.addNewLocation);

                preparedStatement.setString(1, description);
                preparedStatement.setInt(2, Integer.parseInt(numOfRoom));
                preparedStatement.setInt(3, Integer.parseInt(numOfBath));
                preparedStatement.setInt(4, Integer.parseInt(numMaxGuest));
                preparedStatement.setInt(5, Integer.parseInt(numBeds));
                preparedStatement.setInt(6, Integer.parseInt(price));
                preparedStatement.setBoolean(7, service.isWifi());
                preparedStatement.setBoolean(8, service.isSmokingRoom());
                preparedStatement.setBoolean(9, service.isPetsAllowed());
                preparedStatement.setBoolean(10, service.isParking());
                preparedStatement.setBoolean(11, service.isRoomService());
                preparedStatement.setBoolean(12, service.isConditionedAir());
                preparedStatement.setBoolean(13, service.isViews());
                preparedStatement.setBoolean(14, service.isPlasmaTv());
                preparedStatement.setInt(15, idStructure);

                preparedStatement.execute();
                preparedStatement.clearParameters();

                Location locationAdded = new Location(description, Integer.parseInt(numOfRoom), Integer.parseInt(numOfBath), Integer.parseInt(numMaxGuest),
                        Integer.parseInt(numBeds), Double.parseDouble(price), service, null, new ArrayList<>());


                //TODO INSERISCI AVAILABILITY
                //PreparedStatement preparedStatement1 = connection.prepareStatement(Query.addAvailability);


                //preparedStatement1.setDate(1, (java.sql.Date) from);
                //preparedStatement1.setDate(2, (java.sql.Date) to);
                //preparedStatement1.setInt(3, locationId);

                //preparedStatement1.execute();
                //preparedStatement1.clearParameters();
                //Location locationToAdd = new Location(description, Integer.parseInt(numOfRoom), Integer.parseInt(numOfBath), Integer.parseInt(numMaxGuest), Integer.parseInt(numBeds),
                //        Double.parseDouble(price), service, availability, new ArrayList<>());
                //locationForStructure.getStructure().getLocations().add(locationToAdd);
                //locationForStructure.loadLocation(locationForStructure.getStructure());

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error occurs!");
                return false;
            }
            return true;
        }
        return false;
    }


}

