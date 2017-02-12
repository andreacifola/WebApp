package controller.filteredSearch;


import controller.filteredSearch.decoration.*;
import dataSource.DataSource;
import model.User;
import model.feedback.Feedback;
import model.insertNewLocation.AvailableTime;
import model.insertNewLocation.Location;
import model.insertNewLocation.Service;
import model.insertNewLocation.Structure;
import model.payment.IBANCredentialNotValid;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class FilteredSearchController extends Component{

    /**
     * Looking in DB for feedbacks related to a certain location
     * @param idLocation the location ID
     * @return ArrayList of Feedback
     * @throws SQLException
     */
    public static ArrayList<Feedback> retrieveFeedbackByLocation(Integer idLocation) throws SQLException {
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.findFeedbackByLocation);
        preparedStatement.setInt(1, idLocation);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        while (resultSet.next()) {
            Integer rating = resultSet.getInt("rating");
            String description = resultSet.getString("description");
            String username = resultSet.getString("username");
            feedbacks.add(new Feedback(rating, description, username));
        }
        return feedbacks;
    }

    /**
     * Looking in DB for User given its username
     * @param u_username of the user we want find
     * @return the User
     * @throws SQLException
     */
    public static User retrieveOwnerInfoByUsername(String u_username) throws SQLException{
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.findUserByUsername);
        preparedStatement.setString(1, u_username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String u_name = resultSet.getString("name"),
                    u_surname = resultSet.getString("surname"),
                    u_city = resultSet.getString("city"),
                    u_address = resultSet.getString("address"),
                    u_email = resultSet.getString("email"),
                    u_password = resultSet.getString("password"),
                    u_iban = resultSet.getString("iban");
            Date u_date = resultSet.getDate("birthdate");
            Boolean u_scout = resultSet.getBoolean("scout");
            try {
                return new User(u_name, u_surname, u_city, u_address, u_date, u_email, u_username, u_password, u_iban, u_scout);
            } catch (IBANCredentialNotValid ibanCredentialNotValid) {
                ibanCredentialNotValid.printStackTrace();
            }        }
        throw new SQLException();
    }

    /**
     * Looking in DB for locations related to a certain structure
     * @param id Structure ID
     * @return ArrayList of Location
     * @throws SQLException
     */
    public static ArrayList<Location> retrieveLocationsInfoByStructureID(Integer id) throws SQLException {
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(Query.findLocationByStructure);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Location> locations = new ArrayList<>();
        while (resultSet.next()) {
            String description = resultSet.getString("description");
            Integer idLocation = resultSet.getInt("id"),
                    numberOfRooms = resultSet.getInt("numberofrooms"),
                    numberOfBathrooms = resultSet.getInt("numberofbathrooms"),
                    maxGuestsNumber = resultSet.getInt("maxguestsnumber"),
                    numberOfBeds = resultSet.getInt("numberofbeds");
            Double price = resultSet.getDouble("price");
            Boolean wifi = resultSet.getBoolean("wifi"),
                    smokingRoom = resultSet.getBoolean("smokingroom"),
                    petsAllowed = resultSet.getBoolean("petsallowed"),
                    parking = resultSet.getBoolean("parking"),
                    roomService = resultSet.getBoolean("roomservice"),
                    conditionedAir = resultSet.getBoolean("conditionedair"),
                    views = resultSet.getBoolean("views"),
                    plasmaTV = resultSet.getBoolean("plasmatv");

            ArrayList<Date[]> availability = retrieveAvailabilityByLocation(idLocation);
            ArrayList<Feedback> feedbacks = retrieveFeedbackByLocation(idLocation);
            Service service = new Service(wifi, smokingRoom, petsAllowed, parking, roomService, conditionedAir, views, plasmaTV);
            Location location = new Location(idLocation, description, numberOfRooms, numberOfBathrooms, maxGuestsNumber, numberOfBeds, price, service, new AvailableTime(availability), feedbacks);
            locations.add(location);
        }
        return locations;
    }

    /**
     * Looking in DB for Availability couple related to a certain location
     * @param idLocation of the location
     * @return ArrayList of Date[]
     * @throws SQLException
     */
    public static ArrayList<Date[]> retrieveAvailabilityByLocation(Integer idLocation) throws SQLException {
        PreparedStatement preparedStatementAvailability = DataSource.getConnection().prepareStatement(Query.findAvailability);
        preparedStatementAvailability.setInt(1, idLocation);
        ResultSet resultSetAvailability = preparedStatementAvailability.executeQuery();
        ArrayList<Date[]> availability = new ArrayList<>();
        while (resultSetAvailability.next()) {
            Date from = resultSetAvailability.getDate("fromdate");
            Date to = resultSetAvailability.getDate("todate");
            availability.add(new Date[]{from, to});
        }
        return availability;
    }

    /**
     * Looking in DB for Structure given a ResultSet
     * @param resultSet returned by a query
     * @return a Structure
     * @throws SQLException
     */
    public static Structure retrieveStructureInfoFromDatabaseQuery(ResultSet resultSet) throws SQLException {
        Integer s_id = resultSet.getInt("id");
        String s_name = resultSet.getString("name"),
                s_owner = resultSet.getString("owner"),
                s_description = resultSet.getString("description"),
                s_region = resultSet.getString("region"),
                s_city = resultSet.getString("city"),
                s_address = resultSet.getString("address"),
                s_housenumber = resultSet.getString("housenumber"),
                s_cap = resultSet.getString("cap");

        User owner = retrieveOwnerInfoByUsername(s_owner);
        ArrayList<Location> locations = retrieveLocationsInfoByStructureID(s_id);

        return new Structure(s_id, s_name, s_region, s_city, s_address, s_housenumber, s_cap, owner, s_description, locations);
    }

    /**
     * Looking in DB for structures
     * @return ArrayList of Structure
     * @throws SQLException
     */
    protected ArrayList<Structure> search() throws SQLException {
        PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.findStructures);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Structure> structures = new ArrayList<>();
        while (resultSet.next()) {
            structures.add(retrieveStructureInfoFromDatabaseQuery(resultSet));
        }
        return structures;
    }

    /**
     * Start search applying filters
     * @param from start Date
     * @param to end Date
     * @param region of Structure
     * @param city of Structure
     * @param name of Structure
     * @param rooms in Location
     * @param baths in Location
     * @param maxGuests in Location
     * @param beds in Location
     * @param maxPrice of Location
     * @param wifi service in Location
     * @param smoking service in Location
     * @param petsAllowed service in Location
     * @param parking service in Location
     * @param roomService service in Location
     * @param conditionedAir service in Location
     * @param views service in Location
     * @param plasmaTV service in Location
     * @return ArrayList of Structure
     * @throws SQLException
     */
    public ArrayList<Structure> startResearch(Date from, Date to, String region, String city, String name, Integer rooms, Integer baths, Integer maxGuests, Integer beds,
                                              Integer maxPrice, Boolean wifi, Boolean smoking, Boolean petsAllowed, Boolean parking, Boolean roomService,
                                              Boolean conditionedAir, Boolean views, Boolean plasmaTV) throws SQLException {

        Component fsc = this;
        fsc = new PriceResearch(maxPrice, fsc);

        if (from != null && to != null) {
            fsc = new AvailabilityResearch(from, to, fsc);
            if (from.after(to))
                return null;
        }

        if (!region.isEmpty()) fsc = new RegionResearch(region, fsc);
        if (!city.isEmpty()) fsc = new CityResearch(city, fsc);
        if (!name.isEmpty()) fsc = new NameResearch(name, fsc);
        if (!rooms.equals(0)) fsc = new RoomsResearch(rooms, fsc);
        if (!baths.equals(0)) fsc = new BathsResearch(baths, fsc);
        if (!maxGuests.equals(0)) fsc = new MaxGuests(maxGuests, fsc);
        if (!beds.equals(0)) fsc = new BedsResearch(beds, fsc);

        if (wifi) fsc = new WiFiResearch(fsc);
        if (smoking) fsc = new SmokingRoomResearch(fsc);
        if (petsAllowed) fsc = new PetsAllowedResearch(fsc);
        if (parking) fsc = new ParkingResearch(fsc);
        if (roomService) fsc = new RoomServiceResearch(fsc);
        if (conditionedAir) fsc = new ConditionedAirResearch(fsc);
        if (views) fsc = new ViewsResearch(fsc);
        if (plasmaTV) fsc = new PlasmaTVResearch(fsc);

        return fsc.search();

    }
}
