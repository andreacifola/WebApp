package controller.login;

import controller.UtilityMD5;
import dataSource.DataSource;
import model.User;
import model.payment.IBANCredentialNotValid;
import querySQL.Query;
import sun.text.normalizer.Utility;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    public static User LoginController (String username, String password) throws IBANCredentialNotValid {
        try{
            PreparedStatement statement = DataSource.getConnection().prepareStatement(Query.findRegisteredUser);
            statement.setString(1, username);
            statement.setString(2, UtilityMD5.stringByHashingPassword(password));
            ResultSet resultSet = statement.executeQuery();
            //resultSet returns false if the next row is not valid (or not exists)
            if (resultSet.next()) {
                return new User(resultSet);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new Frame(), "SQLException");
            e.printStackTrace();
        }
        return null;
    }
}
