package controller.managementProfile;

import controller.UtilityMD5;
import dataSource.DataSource;
import model.User;
import model.language.managementProfile.ManagementProfileLanguage;
import model.payment.IBANCredentialNotValid;
import querySQL.Query;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;


/**
 * Created by luca on 09/09/16.
 */
public class ManagementProfileController {

    private final static String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean modifyData (String name, String surname, String city, String address,Date birthdate, String email, String password, String iban,
                                   User user) {

        if (checkFields(name, surname, city, birthdate, email, password)) {
            try {
                PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.updateUser);
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, city);
                statement.setString(4, address);
                statement.setDate(5, new java.sql.Date(birthdate.getTime()));
                statement.setString(6, email);
                statement.setString(7, password);
                statement.setString(8, iban);
                statement.setString(9, user.getUsername());
                statement.execute();
                //resultSet returns false if the next row is not valid (or not exists)
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new Frame(), "SQLException");
                e.printStackTrace();
            }
            return true;
        } else
            return false;
    }

    public static boolean checkMajorAge(Date birthDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+18);

        Calendar now = Calendar.getInstance();
        long difference = now.getTimeInMillis()-calendar.getTimeInMillis();


        return difference > 0;
    }

    private static boolean isAlpha(String string) {
        return (string.chars().allMatch(Character::isLetter));
    }

    private static boolean minLength(String string, int length) {
        return (string.length() >= length);
    }

    private static boolean checkEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    private static boolean checkFields(String name, String surname, String city, Date birthDate,
                                      String email, String password1) {
        if (!isAlpha(name) || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_invalidName);
            return false;
        }
        if (!isAlpha(surname) || surname.isEmpty()) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_invalidSurname);
            return false;
        }
        if (!isAlpha(city)) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_invalidCity);
            return false;
        }
        if (!checkMajorAge(birthDate)) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_notMajorAge);
            return false;
        }
        if (!checkEmail(email)) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_invalidEmail);
            return false;
        }
        if (!minLength(password1,6)) {
            JOptionPane.showMessageDialog(null, ManagementProfileLanguage.managementProfile_invalidPassword);
            return false;
        }
        return true;
    }

}
