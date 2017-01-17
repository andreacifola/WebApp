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

    private boolean isAlpha(String string) {
        return (string.chars().allMatch(Character::isLetter));
    }

    private boolean minLength(String string, int length) {
        return (string.length() >= length);
    }

    private boolean validUsername(String username) {
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

    private boolean checkPass(String pass1, String pass2) {
        return pass1.equals(pass2);
    }

    private boolean checkEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

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

    public boolean addNewUser(String name, String surname, String city, String address, GregorianCalendar birthDate,
                              String email, String username, String password, String repeatPass, String IBAN) {
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