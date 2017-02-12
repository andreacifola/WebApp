package controller.registration;

import controller.UtilityMD5;
import dataSource.DataSource;
import querySQL.Query;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * Created by andreacifola on 05/09/16.
 */
public class RegistrationController {

    private final static String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * This method check if the fields filled by the user are correct
     *
     * @param name      entered by the user
     * @param surname   entered by the user
     * @param city      entered by the user
     * @param birthDate entered by the user
     * @param email     entered by the user
     * @param username  entered by the user
     * @param password1 entered by the user
     * @param password2 entered by the user
     * @return true in case of success (the fields are all correct), false otherwise
     */
    public boolean checkFields(String name, String surname, String city, GregorianCalendar birthDate,
                               String email, String username, String password1, String password2) {
        if (!isAlpha(name) || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name!");
            return false;
        }
        if (!isAlpha(surname) || surname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid surname!");
            return false;
        }
        if (!isAlpha(city)) {
            JOptionPane.showMessageDialog(null, "Invalid city!");
            return false;
        }
        if (!checkIfMajor(birthDate)) {
            JOptionPane.showMessageDialog(null, "The user is not of legal age!");
            return false;
        }
        if (!checkEmail(email)) {
            JOptionPane.showMessageDialog(null, "This e-mail is not valid");
            return false;
        }
        if (!minLength(username,6)) {
            JOptionPane.showMessageDialog(null, "Username too short! (min 6 characters)");
            return false;
        }
        if (!validUsername(username)) {
            JOptionPane.showMessageDialog(null, "This User-id already exists!");
            return false;
        }
        if (!minLength(password1,6)) {
            JOptionPane.showMessageDialog(null, "Password too short! (min 6 characters)");
            return false;
        }
        if (!checkPass(password1,password2)) {
            JOptionPane.showMessageDialog(null, "Passwords don't match");
            return false;
        }
        return true;
    }

    /**
     * This method check if the string passed as parameter is composed by characters only
     * @param string to be checked
     * @return true in case of success (the string is effectively composed by characters only), false otherwise
     */
    private boolean isAlpha(String string) {
        return (string.chars().allMatch(Character::isLetter));
    }

    /**
     * This method checks if the string has minimum length
     * @param string to be checked
     * @param length minimum length of the string
     * @return true in case of success (the string has at least the required length), false otherwise
     */
    private boolean minLength(String string, int length) {
        return (string.length() >= length);
    }

    /**
     * This method checks if the entered username for the registration exists already in the DB
     * @param username to be checked in the DB
     * @return true in case of success (the username is not used by anyone), false otherwise
     */
    public boolean validUsername(String username) {
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(Query.countUsername);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                final int count = resultSet.getInt(1);
                if (count == 0)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * This method checks if password and repeat password match
     * @param pass1
     * @param pass2
     * @return true in case of success (passwords match), false otherwise
     */
    private boolean checkPass(String pass1, String pass2) {
        return pass1.equals(pass2);
    }

    /**
     * This method checks, with the help of email regex, if the structure of the entered email is correct
     * @param email to be checked
     * @return true in case of success (the email is correct), false otherwise
     */
    private boolean checkEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    /**
     * This method checks if the entered birthdate is legal, that is the user is of age
     * @param birthDate
     * @return
     */
    public boolean checkIfMajor(GregorianCalendar birthDate) {
        GregorianCalendar now = new GregorianCalendar();

        int day = birthDate.get(Calendar.DAY_OF_MONTH);
        int month = birthDate.get(Calendar.MONTH);
        int year = birthDate.get(Calendar.YEAR) + 18;
        GregorianCalendar majorAge = new GregorianCalendar(year,month,day,0,0,0);
        majorAge.set(Calendar.MILLISECOND, 0);
        long difference = now.getTimeInMillis()-majorAge.getTimeInMillis();

        return difference > 0;
    }

    /**
     * This method adds in the DB a new user, with the information entered by the user himself
     * @param name
     * @param surname
     * @param city
     * @param address
     * @param birthDate
     * @param email
     * @param username
     * @param password
     * @param repeatPass
     * @param IBAN
     * @param scout
     * @return true in case of success (the user has been added), false otherwise
     */
    public boolean addNewUser(String name, String surname, String city, String address, GregorianCalendar birthDate,
                              String email, String username, String password, String repeatPass, String IBAN, Boolean scout) {
        if (checkFields(name, surname, city, birthDate, email, username, password, repeatPass)) {
            Connection connection = DataSource.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query.addNewUser);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, surname);
                preparedStatement.setString(3, city);
                preparedStatement.setString(4, address);
                preparedStatement.setDate(5, new java.sql.Date(birthDate.getTimeInMillis()));
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, username);
                preparedStatement.setString(8, UtilityMD5.stringByHashingPassword(password));
                preparedStatement.setString(9, IBAN);
                preparedStatement.setBoolean(10, scout);

                preparedStatement.execute();
                preparedStatement.clearParameters();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error");
                return false;
            }
            return true;
        }
        return false;
    }
}